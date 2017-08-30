/*****************************************************************************
 * Copyright (c) 2017 CEA.
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>
 * Contributors:
 * Géry Deloge (CEATech AQUI) gery.deloge@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.architecture.migration;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler_1_3_0;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle;
import org.eclipse.papyrus.bpmn.architecture.BpmnRepresentationKinds;


@SuppressWarnings({"nls", "deprecation"})
public class NeonToOxygenDiagramReconcilier extends DiagramReconciler_1_3_0 {

	private static final String COLLABORATION_DIAGRAM_URI = "platform:/plugin/org.eclipse.papyrus.bpmn.diagram/viewpoints/bpmn.configuration#_0kzWAPL_EeONXPQ2mbw9vB";
	private static final String PROCESS_DIAGRAM_URI = "platform:/plugin/org.eclipse.papyrus.bpmn.diagram/viewpoints/bpmn.configuration#_0kzWAPL_EeONXPQ2mbw9vA";

	private static final String CONTEXT_ID = "org.eclipse.papyrus.bpmn.descriptionLanguage"; // defined in architecture file



	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler_1_3_0#getPapyrusDiagram(org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle)
	 *
	 * @param oldStyle
	 * @return
	 */
	@Override
	protected PapyrusDiagram getDiagramKind(Diagram diagram, PapyrusViewStyle oldStyle) {
		if (oldStyle != null) {
			PapyrusView configuration = oldStyle.getConfiguration();
			if (configuration != null) {
				URI uri = EcoreUtil.getURI(configuration);
				if (uri != null) {
					switch (uri.toString()) {
					case COLLABORATION_DIAGRAM_URI:
						return getPapyrusDiagramById(BpmnRepresentationKinds.COLLABORATION_ID);
					case PROCESS_DIAGRAM_URI :
						return getPapyrusDiagramById(BpmnRepresentationKinds.PROCESS_ID);
					default:
						break;
					}
				}
			}
		}
		return null;
	}


	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		ICommand reconcileCommand = super.getReconcileCommand(diagram);
		if (reconcileCommand != null && diagram != null) {
			Resource eResource = diagram.eResource();
			if (eResource != null) {
				ResourceSet resourceSet = eResource.getResourceSet();
				if (resourceSet instanceof ModelSet) {
					CompositeCommand compositeCommand = new CompositeCommand("Update viewpoints from configuration to architecture and set BPMN as default architecture");
					compositeCommand.add(reconcileCommand);
					Command setContextCommand = getSetContextCommand((ModelSet) resourceSet, CONTEXT_ID);
					compositeCommand.add(EMFtoGMFCommandWrapper.wrap(setContextCommand));
					return compositeCommand;
				}
			}
		}
		return reconcileCommand;
	}

	///////////////////////////////////////////////////////////////////////////////
	// FIXME: should be in Papyrus core API
	protected Command getSetContextCommand(ModelSet modelSet, String contextId) {
		return new RecordingCommand(modelSet.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				ArchitectureDescription description = DiModelUtils.getOrAddArchitectureDescription(modelSet);
				description.setContextId(contextId);
			}
		};
	}

	protected PapyrusDiagram getPapyrusDiagramById(String id) {
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		Collection<MergedArchitectureContext> visibleArchitectureContexts = manager.getVisibleArchitectureContexts();
		for (MergedArchitectureContext mergedArchitectureContext : visibleArchitectureContexts) {
			if (mergedArchitectureContext instanceof MergedArchitectureDescriptionLanguage) {
				MergedArchitectureDescriptionLanguage mergedArchitectureDescriptionLanguage = (MergedArchitectureDescriptionLanguage) mergedArchitectureContext;
				for (RepresentationKind representationKind : mergedArchitectureDescriptionLanguage
						.getRepresentationKinds()) {
					if (representationKind instanceof PapyrusDiagram && representationKind.getId().equals(id)) {
						return (PapyrusDiagram) representationKind;
					}
				}
			}
		}
		return null;
	}
	////////////////////////////////////////////////////////////////////////////////
}
