package by.tr.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.tr.web.controller.Controller;
import by.tr.web.dao.DOMBuilder;
import by.tr.web.dao.Director;
import by.tr.web.dao.SAXBuilder;
import by.tr.web.dao.StAXBuilder;
import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;
import by.tr.web.service.Service;
import by.tr.web.service.exeption.ServiceExeption;

public class ServiceImpl implements Service{

	private static final Logger log = Logger.getLogger(Controller.class);
	public List<Flower> parse(String parser) throws ServiceExeption, SAXException {
		log.info("parse");
		List<Flower> orangery = null;
		if("SAX".equals(parser)){
			try {
				orangery = Director.createOrangery(new SAXBuilder());
			} catch (DAOExeption e) {
				throw  new ServiceExeption();
			}
		}
		if("STAX".equals(parser)){
			try {
				orangery = Director.createOrangery(new StAXBuilder());
			} catch (DAOExeption e) {
				throw  new ServiceExeption();
			}
		}
		if("DOM".equals(parser)){
			try {
				orangery = Director.createOrangery(new DOMBuilder());
			} catch (DAOExeption e) {
				throw  new ServiceExeption();
			}
		}
		return orangery;
	}

}

