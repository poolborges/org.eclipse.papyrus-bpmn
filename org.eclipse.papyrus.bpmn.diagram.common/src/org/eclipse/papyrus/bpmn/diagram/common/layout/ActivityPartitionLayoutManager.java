/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.diagram.common.layout;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.bpmn.diagram.common.figures.ActivityHorizontalPartitionFigure;

public class ActivityPartitionLayoutManager extends AbstractLayout {

	public void layout(IFigure container) {
		ActivityHorizontalPartitionFigure ActivityHorizontalPartitionFigure = (ActivityHorizontalPartitionFigure) container;
		Rectangle parentBounds = ActivityHorizontalPartitionFigure.getParent().getBounds();
		int newY = parentBounds.y() + (parentBounds.height / 2);
		Rectangle verticalLabelBounds = new Rectangle(parentBounds.x(), newY, 100, 100);
		ActivityHorizontalPartitionFigure.getVerticalLabel().setBounds(verticalLabelBounds);
		
		ActivityHorizontalPartitionFigure.getStereotypesLabel().setBounds(new Rectangle(0,0,0,0));
		ActivityHorizontalPartitionFigure.getNameLabel().setBounds(new Rectangle(0,0,0,0));

		Rectangle newBounds = ActivityHorizontalPartitionFigure.getBounds();
		int newHight = newBounds.height() + ActivityHorizontalPartitionFigure.getNameLabel().getBounds().height();
		newBounds.setHeight(newHight);
		ActivityHorizontalPartitionFigure.getActivityPartitionCompartment().setBounds(newBounds);
		
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		
		return new Dimension(20, 20);
	}



}
