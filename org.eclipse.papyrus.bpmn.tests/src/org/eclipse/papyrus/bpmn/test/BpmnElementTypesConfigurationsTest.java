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
package org.eclipse.papyrus.bpmn.test;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SuppressWarnings("nls") 
public class BpmnElementTypesConfigurationsTest {

	private static final String elementTypesConfiguration = "../org.eclipse.papyrus.bpmn/model/bpmn.elementtypesconfigurations";
	private static final String elementTypesCustomConfiguration = "../org.eclipse.papyrus.bpmn/model/customBpmn.elementtypesconfigurations";


	private Document openDoc(String file) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new FileInputStream(file));
		doc.getDocumentElement().normalize();
		return doc;
	}

	@Test
	public void checkId() throws ParserConfigurationException, IOException, SAXException {
		Document doc = openDoc(elementTypesConfiguration);
		NodeList nodeList = doc.getElementsByTagName("elementTypeConfigurations");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String identifier = element.getAttribute("identifier");
				String xmiid = element.getAttribute("xmi:id");

				Assert.assertEquals("xmi::id and identifier should be equal", xmiid, identifier);
			}
		}
	}


	@Test
	public void checkCustomId() throws ParserConfigurationException, IOException, SAXException {
		Document doc = openDoc(elementTypesCustomConfiguration);
		NodeList nodeList = doc.getElementsByTagName("elementTypeConfigurations");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String identifier = element.getAttribute("identifier");
				String xmiid = element.getAttribute("xmi:id");

				Assert.assertEquals("xmi::id and identifier should be equal", xmiid, identifier);
			}
		}
	}

}
