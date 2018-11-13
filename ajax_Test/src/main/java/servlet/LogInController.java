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
import java.util.ResourceBundle;

@WebServlet(name = "loginController", urlPatterns = {"/Login"})
public class LogInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/View_Result.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (this.getServletContext().getAttribute("User") == null) {
            System.out.println(this.getServletContext().getAttribute("User") == null);
            Locale locale = (Locale) req.getSession().getAttribute("LOCALE");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User userFromDb = ServiceFactoryImpl.getServiceFactory().getUserService().getUserByName(username);
            System.out.println(userFromDb);
            if (userFromDb != null && PasswordEncryption.checkPassword(password, userFromDb.getPassword())) {
                req.getSession().setAttribute("User", userFromDb);
                this.getServletContext().setAttribute("User", userFromDb);
                req.setAttribute("Welcome", "Welcome to " + userFromDb.getUserRole() + " page");
                req.getRequestDispatcher("ChooseParametersList.jsp").forward(req, resp);
            } else {
                // ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);
                //req.getSession().setAttribute("errorLoginPassMessage", messages.getString("wrongLoginOrPassword"));
                resp.sendRedirect("View_Result.jsp");
            }
        } else {
            resp.sendRedirect("View_Result.jsp");
        }
    }
}
