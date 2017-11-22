package by.tr.web.dao.impl;

import java.io.File;
import java.util.List;

import org.xml.sax.SAXException;

import by.tr.web.dao.DAO;
import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;

public class DAOImpl implements DAO{

	public List<Flower> parseSAX() throws DAOExeption, SAXException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("orangery.xml").getFile());
		
		List<Flower> orangery = SaxParser.parse(file);


		return orangery;
	}
	public List<Flower> parseSTAX() throws DAOExeption {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("orangery.xml").getFile());
		
		List<Flower> orangery = StaxParser.parse(file);


		return orangery;
	}
	public List<Flower> parseDOM() throws DAOExeption {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("orangery.xml").getFile());
		
		List<Flower> orangery = DomParser.parse(file);


		return orangery;
	}

}

