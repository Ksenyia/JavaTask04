package by.tr.web.dao.impl;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.tr.web.controller.Controller;
import by.tr.web.dao.DAO;
import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;

public class DAOImpl implements DAO{

public static final String fileName = "orangery.xml";
private static final Logger log = Logger.getLogger(Controller.class);
	
	public List<Flower> parseSAX() throws DAOExeption, SAXException {
		log.info("SAX parser");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		List<Flower> orangery = SaxParser.parse(file);
		
		return orangery;
	}
	public List<Flower> parseSTAX() throws DAOExeption {
		log.info("STAX parser");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		List<Flower> orangery = StaxParser.parse(file);


		return orangery;
	}
	public List<Flower> parseDOM() throws DAOExeption {
		log.info("DOM parser");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		List<Flower> orangery = DomParser.parse(file);


		return orangery;
	}

}

