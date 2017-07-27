/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.apache.log4j.Logger;
import org.eclipse.papyrus.bpmn.BPMNProfile.Lane;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.util.UMLUtil;

public class LaneCustom {
	private static final Logger log = Logger.getLogger(LaneCustom.class);

	private LaneCustom() {
	}

	public static LaneSet basicGetChildLaneSet(Lane lane) {
		LaneSet laneSet = null;
		ActivityPartition activityPartition = lane.getBase_ActivityPartition();
		if (activityPartition != null) {
			laneSet = UMLUtil.getStereotypeApplication(activityPartition, LaneSet.class);
		}

		return laneSet;
	}


	public static LaneSet basicGetLaneSet(Lane lane) {
		LaneSet laneSet = null;
		ActivityPartition activityPartition = lane.getBase_ActivityPartition();
		if (activityPartition != null) {
			ActivityPartition superPartition = activityPartition.getSuperPartition();
			if (superPartition != null) {
				laneSet = UMLUtil.getStereotypeApplication(superPartition, LaneSet.class);
			}
		}
		return laneSet;
	}
}
