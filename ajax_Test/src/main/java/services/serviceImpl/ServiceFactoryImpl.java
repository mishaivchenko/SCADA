package services.serviceImpl;

import services.Service;
import services.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory<Service> {
    private static final ServiceFactoryImpl serviceFactory = new ServiceFactoryImpl();

    private Service useService = new UserServiceImpl();

    public static ServiceFactoryImpl getServiceFactory() {
        return serviceFactory;
    }


    @Override
    public UserServiceImpl getUserService() {
        return (UserServiceImpl) this.useService;
    }

}
