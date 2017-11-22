package by.tr.web.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;

public class SaxParser {

	public SaxParser() {
		
	}
	
	public static List<Flower> parse(File file) throws DAOExeption, SAXException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		FlowerSaxHandler handler = new FlowerSaxHandler();
		reader.setContentHandler(handler);
		try {
			reader.parse(new InputSource(new FileReader(file)));
		} catch (IOException e4) {
			e4.printStackTrace();
		} catch (SAXException e4) {
			e4.printStackTrace();
		}

		try {
			reader.setFeature("http://xml.org/sax/features/validation", true);
		} catch (SAXNotRecognizedException e3) {
			e3.printStackTrace();
		} catch (SAXNotSupportedException e3) {
			e3.printStackTrace();
		}
		try {
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
		} catch (SAXNotRecognizedException e2) {
			e2.printStackTrace();
		} catch (SAXNotSupportedException e2) {
			e2.printStackTrace();
		}
		 
		try {
			reader.setFeature("http://xml.org/sax/features/string-interning",true);
		} catch (SAXNotRecognizedException e1) {
			e1.printStackTrace();
		} catch (SAXNotSupportedException e1) {
			e1.printStackTrace();
		}
		 
		try {
			reader.setFeature("http://apache.org/xml/features/validation/schema",true);
		} catch (SAXNotRecognizedException e) {
			e.printStackTrace();
		} catch (SAXNotSupportedException e) {
			e.printStackTrace();
		}

		List<Flower> orangery = handler.getFlowerList();
		return orangery;
	}
	
}
