/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>
 * Contributors:
 * CEA LIST - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.util.UMLUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class FlowNodeCustom {

	private FlowNodeCustom() {
	}

	/*
	 * from BPMN profile v1.0 §10.2.2.4, should return List<SequenceFlow>
	 */
	public static EList<BPMNAssociation> getOutgoing(FlowNode flowNode) {

		ActivityNode activityNode = flowNode.getBase_ActivityNode();
		List<BPMNAssociation> list = new ArrayList<>();
		if (activityNode != null) {
			EList<ActivityEdge> outgoings = activityNode.getOutgoings();
			list = outgoings.stream().map(e -> UMLUtil.getStereotypeApplication(e, BPMNAssociation.class))
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}

		return new BasicEList<>(list);
	}

	/*
	 * from BPMN profile v1.0 §10.2.2.4, should return List<SequenceFlow>
	 */
	public static EList<BPMNAssociation> getIncoming(FlowNode flowNode) {

		ActivityNode activityNode = flowNode.getBase_ActivityNode();
		List<BPMNAssociation> list = new ArrayList<>();
		if (activityNode != null) {
			EList<ActivityEdge> incomings = activityNode.getIncomings();
			list = incomings.stream().map(e -> UMLUtil.getStereotypeApplication(e, BPMNAssociation.class))
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}

		return new BasicEList<>(list);
	}

}
