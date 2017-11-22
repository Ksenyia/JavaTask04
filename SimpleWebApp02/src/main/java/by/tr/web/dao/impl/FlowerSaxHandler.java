package by.tr.web.dao.impl;

import org.xml.sax.helpers.DefaultHandler;

import by.tr.web.controller.Controller;
import by.tr.web.entity.Growing;
import by.tr.web.entity.TagName.FlowerTagName;
import by.tr.web.entity.Visual;
import by.tr.web.entity.flower.AnnualFlower;
import by.tr.web.entity.flower.BiennialFlower;
import by.tr.web.entity.flower.Flower;
import by.tr.web.entity.flower.PerennialsFlower;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class FlowerSaxHandler extends DefaultHandler {

	private List<Flower> flowerList = new ArrayList<Flower>();
	private Flower flower;
	private Growing growing;
	private Visual visual;
	private StringBuilder text;
	private static final Logger log = Logger.getLogger(Controller.class);

	public List<Flower> getFlowerList() {
	return flowerList;
	}

	public void startDocument() throws SAXException {
		String message = "Parsing started.";
		log.info(message);
	}

	public void endDocument() throws SAXException { 
		String message = "Parsing ended.";
		log.info(message);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		String message = "startElement -> " + "uri: " + uri + ", localName:" + localName + ", qName: " + qName;
		log.info(message);
		text = new StringBuilder();
		if (qName.equals("annual-flower")){ 
			flower = new AnnualFlower();
			flower.setId((attributes.getValue("id")));
			flower.setMultiplying((attributes.getValue("multiplying")));
		}
		if (qName.equals("biennial-flower")){ 
			flower = new BiennialFlower();
			flower.setId((attributes.getValue("id")));
			flower.setMultiplying((attributes.getValue("multiplying")));
		}
		if (qName.equals("perennials-flower")){ 
			flower = new PerennialsFlower();
			flower.setId((attributes.getValue("id")));
			flower.setMultiplying((attributes.getValue("multiplying")));
		}
		if (qName.equals("growing-tips")){ 
			growing = new Growing();
		}
		if (qName.equals("visual-parameters")){ 
			visual = new Visual();
		}
	}

	public void characters(char[] buffer, int start, int length){ 
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException{ 
		FlowerTagName tagName = FlowerTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName){ 
		case NAME:
			flower.setName(text.toString());
			break;
		case ORIGIN:
			flower.setOrigin(text.toString());
			break; 
		case SOIL:
			flower.setSoil(text.toString());
			break;
		case TEMPERATURE:
			Integer temperature = Integer.parseInt(text.toString());
			growing.setTemperature(temperature);
			break;
		case WATERING:
			Integer watering = Integer.parseInt(text.toString());
			growing.setWatering(watering);
			break; 
		case LEAF_COLOR:
			String leafColor = text.toString();
			visual.setLeafColor(leafColor);
			break;
		case STEM_COLOR:
			String stemColor = text.toString();
			visual.setStemColor(stemColor);
			break; 
		case PLANT_SIZE:
			Integer plantSize = Integer.parseInt(text.toString());
			visual.setPlantSize(plantSize);
			break; 
		case GROWING_TIPS:
			flower.setGrowingTips(growing);
			growing = null;
			break;
		case VISUAL_PARAMETERS:
			flower.setVisualParameters(visual);
			visual = null;
			break;
		case ANNUAL_FLOWER:
			flowerList.add(flower);
			flower = null;
			break;
		case BIENNIAL_FLOWER:
			flowerList.add(flower);
			flower = null;
			break;
		case PERENNIALS_FLOWER:
			flowerList.add(flower);
			flower = null;
			break;
		default:
			break;
		}
	}

	public void warning(SAXParseException exception) {
		String message = "WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage();
		log.warn(message);
	}

	public void error(SAXParseException exception) { 
		String message = "ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage();
		log.error(message);
	}

	public void fatalError(SAXParseException exception) throws SAXException { 
		String message = "FATAL: line " + exception.getLineNumber() + ": "+ exception.getMessage();
		log.fatal(message);
	throw (exception);
	}
}

