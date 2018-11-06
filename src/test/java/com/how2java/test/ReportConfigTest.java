package com.how2java.test;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import org.junit.Ignore;
import org.junit.Test;


public class ReportConfigTest {

	//@Ignore
	@Test
	public void LoadXml() throws Exception {
		DocumentBuilderFactory builderFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder  builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src\\main\\resources\\ReportConfig\\*.ReportConfig.xml");
		NodeList list = document.getElementsByTagName("Reps");
		for(int i=0;i<list.getLength();i++){
			Node node = list.item(i);
			String str = node.getTextContent();
			System.out.println(str);
		}

		
	
	}
}
