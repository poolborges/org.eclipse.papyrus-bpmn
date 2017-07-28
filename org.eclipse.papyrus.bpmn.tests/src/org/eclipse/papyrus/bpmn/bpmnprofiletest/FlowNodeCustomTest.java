/*****************************************************************************
 * Copyright (c) 2016 CEA.
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>
 * Contributors:
 * Géry Deloge (CEATech AQUI) gery.deloge@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.bpmnprofiletest;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowNodeCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.*;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FlowNodeCustomTest {

	private OpaqueAction source;
	private OpaqueAction target;
	
	@Before
	public void setUp() {
		Model model = BPMNResource.createBPMNModel();

		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());

		ControlFlow controlFlow = UMLFactory.eINSTANCE.createControlFlow();
		controlFlow.setActivity(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(controlFlow, BPMNProfilePackage.eINSTANCE.getSequenceFlow());
	
		source = UMLFactory.eINSTANCE.createOpaqueAction();
		activity.getOwnedNodes().add(source);		
		StereotypeApplicationHelper.getInstance(null).applyStereotype(source, BPMNProfilePackage.eINSTANCE.getTask());
	
		target = UMLFactory.eINSTANCE.createOpaqueAction();
		activity.getOwnedNodes().add(target);		
		StereotypeApplicationHelper.getInstance(null).applyStereotype(target, BPMNProfilePackage.eINSTANCE.getTask());

		controlFlow.setSource(source);
		controlFlow.setTarget(target);
	}
	
	@Test
	public void getOutgoingGeneratedTest(){
		FlowNode flownode = UMLUtil.getStereotypeApplication(source, FlowNode.class);
		try{			
			flownode.getOutgoing();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}

	/* ignored for now
	   see https://bugs.eclipse.org/bugs/show_bug.cgi?id=516820
	 */
	@Ignore @Test
	public void getOutgoingGeneratedCustomTest(){
		FlowNode flownode = UMLUtil.getStereotypeApplication(source, FlowNode.class);	
		EList<BPMNAssociation> list = FlowNodeCustom.getOutgoing(flownode);
		Assert.assertEquals(1, list.size());
		Assert.assertEquals(target, list.get(0));
	}

	/* ignored for now
	   see https://bugs.eclipse.org/bugs/show_bug.cgi?id=516820
	 */
	@Ignore @Test
	public void getOutgoingTest(){
		FlowNode flownode = UMLUtil.getStereotypeApplication(source, FlowNode.class);	
		EList<BPMNAssociation> list = flownode.getOutgoing();
		Assert.assertEquals(1, list.size());
		Assert.assertEquals(target, list.get(0));
	}


	@Test
	public void getIncomingGeneratedTest(){
		FlowNode flownode = UMLUtil.getStereotypeApplication(target, FlowNode.class);
		try{
			flownode.getIncoming();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}

	/* ignored for now
   	   see https://bugs.eclipse.org/bugs/show_bug.cgi?id=516820
 	*/
	@Ignore @Test
	public void getIncomingGeneratedCustomTest(){
		FlowNode flownode = UMLUtil.getStereotypeApplication(target, FlowNode.class);	
		EList<BPMNAssociation> list = FlowNodeCustom.getOutgoing(flownode);
		Assert.assertEquals(1, list.size());
		Assert.assertEquals(source, list.get(0));
	}

	/* ignored for now
	   see https://bugs.eclipse.org/bugs/show_bug.cgi?id=516820
 	*/
	@Ignore @Test
	public void getIncomingTest(){
		FlowNode flownode = UMLUtil.getStereotypeApplication(target, FlowNode.class);	
		EList<BPMNAssociation> list = flownode.getOutgoing();
		Assert.assertEquals(1, list.size());
		Assert.assertEquals(source, list.get(0));
	}
}
