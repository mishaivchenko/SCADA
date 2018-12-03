package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "localeChange", urlPatterns = "/changeLocal")
public class LocaleChange extends HttpServlet {
    String strlocale;
    String strBundle;
    //private ResourceBundle.Control utf8Control = new Utf8Control();
    private Locale locale;
    private ResourceBundle resourceBundle;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        String localeFromRequest = req.getParameter("lang");
        if (localeFromRequest != null) {
            Locale locale = new Locale(localeFromRequest);
            req.getSession().setAttribute("LOCALE", locale);
        }
        resp.sendRedirect("/Login");
    }
}

