package by.tr.web.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.Growing;
import by.tr.web.entity.Visual;
import by.tr.web.entity.flower.AnnualFlower;
import by.tr.web.entity.flower.BiennialFlower;
import by.tr.web.entity.flower.Flower;
import by.tr.web.entity.flower.PerennialsFlower;

public class DomParser {

	public DomParser() {
	}
	public static List<Flower> parse(File file) throws DAOExeption {
		DOMParser parser = new DOMParser(); 
		try {
			parser.parse(new InputSource(new FileReader(file)));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<Flower> orangery = new ArrayList<Flower>();
		NodeList flowerNodes = root.getChildNodes();
		Flower flower = null;
		for (int i = 0; i < flowerNodes.getLength(); i++) {
			if(flowerNodes.item(i).getNodeName().equals("perennials-flower")){
				flower = new PerennialsFlower();
				getFlower(flowerNodes, flower, i);
				orangery.add(flower);
			}
			if(flowerNodes.item(i).getNodeName().equals("biennial-flower")){
				flower = new BiennialFlower();
				getFlower(flowerNodes, flower, i);
				orangery.add(flower);
			}
			if(flowerNodes.item(i).getNodeName().equals("annual-flower")){
				flower = new AnnualFlower();
				getFlower(flowerNodes, flower, i);
				orangery.add(flower);
			}
		}
		
		return orangery;

		}
	private static void getFlower(NodeList flowerNodes, Flower flower, int i) {
		Element flowerElement = (Element) flowerNodes.item(i);
		flower.setId(flowerElement.getAttribute("id"));
		flower.setMultiplying(flowerElement.getAttribute("multiplying"));
		flower.setName(getSingleChild(flowerElement, "name").getTextContent().trim());
		flower.setSoil(getSingleChild(flowerElement, "soil").getTextContent().trim());
		flower.setOrigin(getSingleChild(flowerElement, "origin").getTextContent().trim());
		Visual visual = getVisualParametrs(flowerElement);
		Growing growing = getGrowingTips(flowerElement);
		flower.setVisualParameters(visual);
		flower.setGrowingTips(growing);
	}
	private static Growing getGrowingTips(Element flowerElement) {
		Growing growing = new Growing();
		Element growingElement = (Element)getSingleChild(flowerElement, "growing-tips");
		Integer temperature = Integer.parseInt(getSingleChild(growingElement, "temperature").getTextContent().trim());
		Integer watering = Integer.parseInt(getSingleChild(growingElement, "watering").getTextContent().trim());
		growing.setTemperature(temperature);
		growing.setWatering(watering);
		return growing;
	}
	private static Visual getVisualParametrs(Element flowerElement) {
		Visual visual = new Visual();
		Element visualElement = (Element)getSingleChild(flowerElement, "visual-parameters");
		visual.setLeafColor(getSingleChild(visualElement, "leaf-color").getTextContent().trim());
		visual.setStemColor(getSingleChild(visualElement, "stem-color").getTextContent().trim());
		Integer plantSize = Integer.parseInt(getSingleChild(visualElement, "plant-size").getTextContent().trim());
		visual.setPlantSize(plantSize);
		return visual;
	}

	private static Element getSingleChild(Element element, String childName){ 
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}
