package by.tr.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.tr.web.controller.Controller;
import by.tr.web.dao.DAO;
import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;
import by.tr.web.service.Service;
import by.tr.web.service.exeption.ServiceExeption;

public class ServiceImpl implements Service{

	private static final Logger log = Logger.getLogger(Controller.class);
	public List<Flower> parse(String parser) throws ServiceExeption, SAXException {
		log.info("parse");
		DAOFactory factory = DAOFactory.getInstance();
		DAO dao = factory.getDAO();
		List<Flower> orangery = null;
		if("SAX".equals(parser)){
			try {
				orangery = dao.parseSAX();
			} catch (DAOExeption e) {
				throw  new ServiceExeption();
			}
		}
		if("STAX".equals(parser)){
			try {
				orangery = dao.parseSTAX();
			} catch (DAOExeption e) {
				throw  new ServiceExeption();
			}
		}
		if("DOM".equals(parser)){
			try {
				orangery = dao.parseDOM();
			} catch (DAOExeption e) {
				throw  new ServiceExeption();
			}
		}
		return orangery;
	}

}

