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
package org.eclipse.papyrus.bpmn.diagram.common;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PaletteTest {

	private static final Logger log = Logger.getLogger(PaletteTest.class);
	private Set<String> elementtypesSet;

	@Before
	public void loadElementtypes() throws ParserConfigurationException, IOException, SAXException{
		elementtypesSet = getGraphicalElementtypesSet("platform:/plugin/org.eclipse.papyrus.bpmn.diagram.common/model/bpmndi.elementtypesconfigurations");
		elementtypesSet.addAll(getGraphicalElementtypesSet("platform:/plugin/org.eclipse.papyrus.bpmn.diagram.common/model/customBpmndi.elementtypesconfigurations"));
	}
	
	private Set<String> getGraphicalElementtypesSet(String elementtypes) throws ParserConfigurationException, IOException, SAXException{
		
		URL url = new URL(elementtypes);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();		
		String file = FileLocator.toFileURL(url).getFile();
		Document doc = builder.parse(new FileInputStream(file));
		doc.getDocumentElement().normalize();
		
		NodeList nodeList = doc.getElementsByTagName("elementTypeConfigurations");
		Set<String> set = new HashSet<>();
		for(int i = 0; i < nodeList.getLength() ; i++){
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element)node;
				String identifier = element.getAttribute("identifier");
				if(!set.add(identifier)){
					log.error("duplicate "+ identifier);
					throw new UnsupportedOperationException("duplicate "+ identifier);
				}
			}
		}
		return set;
	}
	
	private Set<String> getPaletteElementtypes(String paletteConfiguration) throws ParserConfigurationException, IOException, SAXException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		String file = FileLocator.toFileURL(new URL(paletteConfiguration)).getFile();
		Document doc = builder.parse(new FileInputStream(file));
		doc.getDocumentElement().normalize();
		
		NodeList nodeList = doc.getElementsByTagName("elementType");
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < nodeList.getLength() ; i++){
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element)node;
				String href = element.getAttribute("href");
				String id = href.substring(href.indexOf('#') + 1);
				set.add(id);
			}
		}
		
		return set;
	}
	
	@Test
	public void checkCollaborationPaletteElementTypeTest() throws ParserConfigurationException, SAXException, IOException{
		
		Set<String> paletteSet = getPaletteElementtypes("platform:/plugin/org.eclipse.papyrus.bpmn.diagram.collaboration/model/collaboration.paletteConfiguration");
		
		for(String id : paletteSet) {
			if(!elementtypesSet.contains(id)){
				log.error("collaboration " + id + " is not graphical elementtype");
				fail(id);
			}
		}
	}
	
	@Test
	public void checkProcessPaletteElementTypeTest() throws ParserConfigurationException, SAXException, IOException{
		
		Set<String> paletteSet = getPaletteElementtypes("platform:/plugin/org.eclipse.papyrus.bpmn.diagram.process/model/process.paletteConfiguration");
		
		for(String id : paletteSet) {
			if(!elementtypesSet.contains(id)){
				log.error("process " + id + " is not graphical elementtype");
				fail(id);
			}
		}
	}
}
