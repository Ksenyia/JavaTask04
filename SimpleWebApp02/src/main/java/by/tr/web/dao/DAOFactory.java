package by.tr.web.dao;

import by.tr.web.dao.impl.DAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final DAO dao = new DAOImpl();
	
	private DAOFactory() {}

	public DAO getDAO() {
		return dao;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
