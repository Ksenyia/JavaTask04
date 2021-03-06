package by.tr.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.tr.web.entity.flower.Flower;
import by.tr.web.service.Service;
import by.tr.web.service.impl.ServiceImpl;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Controller.class);

    	public Controller() {
    		super();
    	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recordsPerPage = 5;
        	int firstPage = 1;
        	double convertIntToDouble = 1.0;
		String massage = "do Post";
		log.info(massage); 
		String requestAttribute = "naming";
		String jspFile = "/information.jsp";
        	HttpSession httpSession = request.getSession();
		String submitName = "parser";
		String parser = request.getParameter(submitName);
		Service service = new ServiceImpl();
		List<Flower> orangery = null;
		try {
			orangery = service.parse(parser);
		} catch (SAXException e) {
			log.error(e.getMessage());
		}
		int countOfRecords = orangery.size();
		String recordsPerPageAttr = "recordsPerPage";
		httpSession.setAttribute(recordsPerPageAttr, recordsPerPage);
        	String countOfRecordsAttr = "countOfRecords";
		httpSession.setAttribute(countOfRecordsAttr, countOfRecords);
        	int countOfPages = (int) Math.ceil(countOfRecords * convertIntToDouble / recordsPerPage);
        	String countOfPageAttr = "countOfPages";
		httpSession.setAttribute(countOfPageAttr, countOfPages);
        	String currentPageAttr = "currentPage";
		httpSession.setAttribute(currentPageAttr,firstPage);
	    	Object obj = orangery;
	    	httpSession.setAttribute(requestAttribute, obj);
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspFile);
	    	dispatcher.include(request, response);
	}

}
