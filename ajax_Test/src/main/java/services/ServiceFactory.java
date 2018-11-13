package services;

import services.serviceImpl.UserServiceImpl;

public interface ServiceFactory<Service> {

    UserServiceImpl getUserService();
}
