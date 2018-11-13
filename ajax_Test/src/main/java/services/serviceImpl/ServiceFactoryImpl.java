package services.serviceImpl;

import Entity.User;
import services.Service;
import services.ServiceFactory;

import javax.swing.text.html.parser.Entity;

public class ServiceFactoryImpl implements ServiceFactory<Service> {
    private static final ServiceFactoryImpl serviceFactory = new ServiceFactoryImpl();

    private Service useService = new UserServiceImpl();

    public static ServiceFactoryImpl getServiceFactory(){
        return serviceFactory;
    }


    @Override
    public UserServiceImpl getUserService() {
        return (UserServiceImpl) this.useService;
    }

}
