package by.tr.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;

public abstract class BaseBuilder {
	private List<Flower> orangery = new ArrayList<Flower>();
	public List<Flower> getOrangery(){
		return orangery;
	}
	public void setOrangery(List<Flower> flowers){
		orangery = flowers;
	}
	public abstract void buildParser() throws DAOExeption, SAXException;
}
