package by.tr.web.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.tr.web.controller.Controller;
import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.Growing;
import by.tr.web.entity.TagName;
import by.tr.web.entity.Visual;
import by.tr.web.entity.TagName.FlowerTagName;
import by.tr.web.entity.flower.AnnualFlower;
import by.tr.web.entity.flower.BiennialFlower;
import by.tr.web.entity.flower.Flower;
import by.tr.web.entity.flower.PerennialsFlower;

public class DomParser {

	private static final Logger log = Logger.getLogger(Controller.class);
	
	public DomParser() {
	}
	
	public static List<Flower> parse(File file) throws DAOExeption {
		DOMParser parser = new DOMParser(); 
		try {
			parser.parse(new InputSource(new FileReader(file)));
		} catch (SAXException | IOException e) {
			log.error("Error" + e.getMessage());
		} 
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<Flower> orangery = new ArrayList<Flower>();
		NodeList flowerNodes = root.getChildNodes();
		for (int i = 0; i < flowerNodes.getLength(); i++) {
			addFlower(orangery, flowerNodes, i);
		}
		
		return orangery;

	}
	
	private static void addFlower(List<Flower> orangery, NodeList flowerNodes, int i) {
		Flower flower = null;
		FlowerTagName elementName = FlowerTagName.getElementTagName(flowerNodes.item(i).getNodeName());
		if(elementName == FlowerTagName.PERENNIALS_FLOWER){
			flower = new PerennialsFlower();
			getFlower(flowerNodes, flower, i);
			orangery.add(flower);
		}
		if(elementName == FlowerTagName.BIENNIAL_FLOWER){
			flower = new BiennialFlower();
			getFlower(flowerNodes, flower, i);
			orangery.add(flower);
		}
		if(elementName == FlowerTagName.ANNUAL_FLOWER){
			flower = new AnnualFlower();
			getFlower(flowerNodes, flower, i);
			orangery.add(flower);
		}
	}
	
	private static void getFlower(NodeList flowerNodes, Flower flower, int i) {
		Element flowerElement = (Element) flowerNodes.item(i);
		flower.setId(flowerElement.getAttribute(TagName.ID));
		flower.setMultiplying(flowerElement.getAttribute(TagName.MULTIPLYING));
		flower.setName(getSingleChild(flowerElement, FlowerTagName.NAME.getStringElementTagName()).getTextContent().trim());
		flower.setSoil(getSingleChild(flowerElement, FlowerTagName.SOIL.getStringElementTagName()).getTextContent().trim());
		flower.setOrigin(getSingleChild(flowerElement, FlowerTagName.ORIGIN.getStringElementTagName()).getTextContent().trim());
		Visual visual = getVisualParametrs(flowerElement);
		Growing growing = getGrowingTips(flowerElement);
		flower.setVisualParameters(visual);
		flower.setGrowingTips(growing);
	}
	
	private static Growing getGrowingTips(Element flowerElement) {
		Growing growing = new Growing();
		Element growingElement = (Element)getSingleChild(flowerElement, FlowerTagName.GROWING_TIPS.getStringElementTagName());
		Integer temperature = Integer.parseInt(getSingleChild(growingElement, FlowerTagName.TEMPERATURE.getStringElementTagName()).getTextContent().trim());
		Integer watering = Integer.parseInt(getSingleChild(growingElement, FlowerTagName.WATERING.getStringElementTagName()).getTextContent().trim());
		growing.setTemperature(temperature);
		growing.setWatering(watering);
		return growing;
	}
	
	private static Visual getVisualParametrs(Element flowerElement) {
		Visual visual = new Visual();
		Element visualElement = (Element)getSingleChild(flowerElement, FlowerTagName.VISUAL_PARAMETERS.getStringElementTagName());
		visual.setLeafColor(getSingleChild(visualElement, FlowerTagName.LEAF_COLOR.getStringElementTagName()).getTextContent().trim());
		visual.setStemColor(getSingleChild(visualElement, FlowerTagName.STEM_COLOR.getStringElementTagName()).getTextContent().trim());
		Integer plantSize = Integer.parseInt(getSingleChild(visualElement, FlowerTagName.PLANT_SIZE.getStringElementTagName()).getTextContent().trim());
		visual.setPlantSize(plantSize);
		return visual;
	}

	private static Element getSingleChild(Element element, String childName){ 
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}
