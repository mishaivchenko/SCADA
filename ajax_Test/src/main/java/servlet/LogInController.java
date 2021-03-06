package servlet;

import Entity.User;
import services.serviceImpl.ServiceFactoryImpl;
import utill.PasswordEncryption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "loginController", urlPatterns = {"/Login"})
public class LogInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(this.getServletContext().getAttribute("JSON")!=null){
            resp.sendRedirect("View_Result.jsp");
        } else {
            req.getRequestDispatcher("ChooseParametersList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (this.getServletContext().getAttribute("User") == null) {
            Locale locale = (Locale) req.getSession().getAttribute("LOCALE");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
           // User userFromDb = ServiceFactoryImpl.getServiceFactory().getUserService().getUserByName(username);
            //System.out.println(userFromDb);
                if(username.equals("admin")&&password.equals("admin")){
            /*   if (userFromDb != null && PasswordEncryption.checkPassword(password, userFromDb.getPassword())) {*/
                    User userFromDb = new User(1,"admin","admin","admin","admin","admin@gmail.com", User.Role.ADMIN, User.UserStatus.NONBLOCKING);
                req.getSession().setAttribute("User", userFromDb);
                this.getServletContext().setAttribute("User", userFromDb);
                req.setAttribute("Welcome", "Welcome to " + userFromDb.getUserRole() + " page");

                req.getRequestDispatcher("ChooseParametersList.jsp").forward(req, resp);

            } else {
                // ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);
                //req.getSession().setAttribute("errorLoginPassMessage", messages.getString("wrongLoginOrPassword"));
               // resp.sendRedirect("login.jsp");
                req.setAttribute("errorLoginPassMessage","Invalid Data. Please verify your login and password and try again");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);

            }
        } else {
            if(this.getServletContext().getAttribute("JSON")!=null){
                resp.sendRedirect("View_Result.jsp");
            }
        }
 //     resp.sendRedirect("/ChooseParametersList.jsp");
    }
}
