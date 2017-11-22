package by.tr.web.service;

import by.tr.web.service.impl.ServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final Service service = new ServiceImpl();
	
	private ServiceFactory() {}

	public Service getService() {

		return service;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}
