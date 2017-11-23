package by.tr.web.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import by.tr.web.controller.Controller;
import by.tr.web.entity.Growing;
import by.tr.web.entity.TagName;
import by.tr.web.entity.TagName.FlowerTagName;
import by.tr.web.entity.Visual;
import by.tr.web.entity.flower.AnnualFlower;
import by.tr.web.entity.flower.BiennialFlower;
import by.tr.web.entity.flower.Flower;
import by.tr.web.entity.flower.PerennialsFlower;

public class StaxParser {
	private static final Logger log = Logger.getLogger(Controller.class);
	
	public StaxParser() {
		
	}
	public static List<Flower> parse(File file){
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		List<Flower> orangery = null;
		try {
			InputStream input = null;
			try {
				input = new FileInputStream((file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				log.error("Error" + e.getMessage());
			}
			 

			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			orangery = process(reader);

		} catch (XMLStreamException e) { 
			e.printStackTrace();
			log.error("Error" + e.getMessage());
		}
		return orangery;
	}

	private static List<Flower> process(XMLStreamReader reader)
		throws XMLStreamException { 
		List<Flower> orangery = new ArrayList<Flower>();
		Flower flower = null;
		Visual visual = null;
		Growing growing = null;
		FlowerTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = FlowerTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case ANNUAL_FLOWER:
					flower = new AnnualFlower();
					addAttributes(reader, flower);
					break;
				case BIENNIAL_FLOWER:
					flower = new BiennialFlower();
					addAttributes(reader, flower);
					break;
				case PERENNIALS_FLOWER:
					flower = new PerennialsFlower();
					addAttributes(reader, flower);
					break;
				case VISUAL_PARAMETERS:
					visual = new Visual();
					break;
				case GROWING_TIPS:
					growing = new Growing();
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case NAME:
					flower.setName(text);
					break;
				case ORIGIN:
					flower.setOrigin(text);
					break;
				case SOIL:
					flower.setSoil(text);
					break;
				case TEMPERATURE:
					Integer temperature = Integer.parseInt(text);
					growing.setTemperature(temperature);
					break;
				case LEAF_COLOR:
					visual.setLeafColor(text);
					break;
				case PLANT_SIZE:
					Integer plantSize = Integer.parseInt(text);
					visual.setPlantSize(plantSize);
					break;
				case STEM_COLOR:
					visual.setStemColor(text);
					break;
				case WATERING:
					Integer watering = Integer.parseInt(text);
					growing.setWatering(watering);
					break;
				default:
					break;
				}
				break;
	
			case XMLStreamConstants.END_ELEMENT:
				elementName = FlowerTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case ANNUAL_FLOWER:
					orangery.add(flower);
					break;
				case BIENNIAL_FLOWER:
					orangery.add(flower);
					break;
				case PERENNIALS_FLOWER:
					orangery.add(flower);
					break;
				case GROWING_TIPS:
					flower.setGrowingTips(growing);
					break;
				case VISUAL_PARAMETERS:
					flower.setVisualParameters(visual);
					break;
				default:
					break;
				}
			 
			}

		}
		return orangery;
	}
	private static void addAttributes(XMLStreamReader reader, Flower flower) {
		String idAnnualFlower = reader.getAttributeValue(null, TagName.ID);
		String multiplyingAnnualFlower = reader.getAttributeValue(null, TagName.MULTIPLYING);
		flower.setId(idAnnualFlower);
		flower.setMultiplying(multiplyingAnnualFlower);
	}
}
