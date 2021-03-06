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
package org.eclipse.papyrus.bpmn.diagram.common.figures;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.activity.figures.ActivityPartitionFigure;

public class ActivityHorizontalPartitionFigure extends ActivityPartitionFigure {
	protected VerticalLabel verticalLabel;

	@Override
	protected void createNameLabel() {
		super.createNameLabel();
		verticalLabel = new VerticalLabel();
		nameLabel.add(verticalLabel);
		getNameLabelContainer().add(verticalLabel, getNameLabelConstraint(), -1);
	}

	@Override
	public void setName(String name) {
		verticalLabel.setText(name);
		super.setName(name);
	}
	
	@Override
	protected void layout() {
		// TODO Auto-generated method stub
		super.layout();
		getNameLabel().setBounds(new Rectangle(0,0,0,0));

		Rectangle parentBounds = getParent().getBounds();
		int y = parentBounds.y() + (parentBounds.height / 2) - (verticalLabel.getImage().getBounds().height / 2);
		verticalLabel.setBounds(new Rectangle(parentBounds.x(), y, 200, 200));
		if(stereotypesLabel != null){
			stereotypesLabel.setVisible(false);
		}
		setBounds(parentBounds);
	}
	
//	@Override
//	public LayoutManager getLayoutManager() {
//		layout = new ActivityPartitionLayoutManager();
//		return layout;
//	}

	public VerticalLabel getVerticalLabel() {
		return verticalLabel;
	}
	
	
}