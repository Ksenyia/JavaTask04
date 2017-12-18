package by.tr.web.dao;

import java.util.List;

import org.xml.sax.SAXException;

import by.tr.web.dao.exeption.DAOExeption;
import by.tr.web.entity.flower.Flower;

public interface DAO {
	List<Flower> parseSAX() throws DAOExeption, SAXException;
	List<Flower> parseSTAX() throws DAOExeption;
	List<Flower>  parseDOM() throws DAOExeption;
}
