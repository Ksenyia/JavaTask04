package by.tr.web.dao;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.tr.web.controller.Controller;
import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.dao.impl.SaxParser;
import by.tr.web.entity.flower.Flower;

public class SAXDirector extends BaseBuilder {

	public static final String fileName = "orangery.xml";
	private static final Logger log = Logger.getLogger(Controller.class);
	
	@Override
	public void buildParser() throws DAOExeption, SAXException {
		log.info("DOM parser");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		List<Flower> orangery = SaxParser.parse(file);
		setOrangery(orangery);
		
	}

}
