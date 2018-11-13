/*
package servlet;

import entity.User;
import org.apache.log4j.Logger;
import services.serviceImpl.ServiceFactoryImpl;
import utill.PasswordEncryption;
import utill.Validator.validatorImpl.UserValidatorImpl;
import utill.Validator.validatorImpl.ValidatorFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/Registration")
public class RegistrationController extends HttpServlet {
    private final Logger logger = Logger.getLogger(RegistrationController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserValidatorImpl userValidator = ValidatorFactoryImpl.getValidatorFactory().getUserValidatorImpl();
        String username = req.getParameter("username");
        if(userValidator.validate(req)&&ServiceFactoryImpl.getServiceFactory().getUserService().getUserByName(username)==null) {
            User user = getUserParametersFromRequest(req);
            encryptUserPassword(user);
            if (ServiceFactoryImpl.getServiceFactory().getUserService().create(user)) {
                req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
                logger.info("New account created for user " + user.getUserName());

            } else resp.sendRedirect("/jsp/login.jsp");
        } else{
            Locale locale = (Locale) req.getSession().getAttribute("LOCALE");
            ResourceBundle messages =  ResourceBundle.getBundle("i18n.messages", locale);
            req.setAttribute("IncorrectData",messages.getString("wrongData"));
            req.getRequestDispatcher("/jsp/registration.jsp").forward(req,resp);
        }
    }


    private User getUserParametersFromRequest(HttpServletRequest request){
        String name = request.getParameter("name");
        String password =  request.getParameter("password");
        String email = request.getParameter("email");
        String secondName = request.getParameter("secondName");
        String username = request.getParameter("username");
        System.out.println(name + " " + email + " " + password + " " + "secondName");
            return new User(1,name,secondName,username,password,email,User.Role.CLIENT,User.UserStatus.NONBLOCKING);
    }

    private void encryptUserPassword(User user){
      String encryptPassword =  PasswordEncryption.encryptPassword(user.getPassword());
      user.setPassword(encryptPassword);
    }
}
*/
