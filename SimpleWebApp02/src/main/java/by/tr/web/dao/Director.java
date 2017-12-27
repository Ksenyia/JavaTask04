package by.tr.web.dao;

import java.util.List;

import org.xml.sax.SAXException;

import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;

public class Director {
	public static List<Flower> createOrangery(BaseBuilder builder) throws DAOExeption, SAXException{
		builder.buildParser();
		List<Flower> orangery = builder.getOrangery();;
		return orangery;
	}
}
