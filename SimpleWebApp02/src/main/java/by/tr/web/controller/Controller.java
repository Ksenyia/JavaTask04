package by.tr.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.tr.web.dao.impl.DAOImpl;
import by.tr.web.entity.flower.Flower;
import by.tr.web.service.Service;
import by.tr.web.service.impl.ServiceImpl;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Controller.class);
	private List<Flower> orangery;
	private HttpSession session;

	public final int perPage = 5;

    public Controller() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
        int recordsPerPage = 5;
		String encoding = "utf-8";
		String contentType = "text/html";
		String requestTagName = "command";
		String requestTagValue = "parsering";
		String submitName = "parser";
		String requestAttribute = "naming";
		String jspFile = "/information.jsp";
		log.info("Log Work!");
		request.setCharacterEncoding(encoding);
		response.setContentType(contentType);
		HttpSession session = request.getSession();
		String parser = request.getParameter(submitName);
    	Service service = new ServiceImpl();
        try {
        	List<Flower> orangery = service.parse(parser);
    		int noOfRecords = orangery.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
    		Object obj = orangery.subList(page-1, page+5);
    		session.setAttribute(requestAttribute, obj);
            request.setAttribute("noOfPages", noOfPages);
            session.setAttribute("currentPage", page);
            Enumeration<String> sessionParams = session.getAttributeNames();
            while(sessionParams.hasMoreElements()){ 
	            session.setAttribute("currentPage", page);
	            obj = orangery.subList(page-1, page+5);
	            session.setAttribute(requestAttribute, obj);
	            request.getRequestDispatcher(jspFile).include(request, response);
	            page++;
            }
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
	}

}
