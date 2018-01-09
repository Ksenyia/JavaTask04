package by.tr.web.service;

import by.tr.web.service.impl.ServiceImpl;

public final class ServiceSingleton {
	private static final ServiceSingleton instance = new ServiceSingleton();

	private final Service service = new ServiceImpl();
	
	private ServiceSingleton() {}

	public Service getService() {

		return service;
	}

	public static ServiceSingleton getInstance() {
		return instance;
	}

}
