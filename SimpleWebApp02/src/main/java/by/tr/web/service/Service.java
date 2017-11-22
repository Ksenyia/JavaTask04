package by.tr.web.service;

import java.util.List;

import org.xml.sax.SAXException;

import by.tr.web.entity.flower.Flower;
import by.tr.web.service.exeption.ServiceExeption;

public interface Service {

	List<Flower> parse(String parser) throws ServiceExeption, SAXException;
}
