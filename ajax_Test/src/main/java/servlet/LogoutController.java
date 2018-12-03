package servlet;

import Entity.Holder;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",
        urlPatterns = "/Logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            session.removeAttribute("User");
            clearHolder();
            //  session.invalidate();
            this.getServletContext().removeAttribute("User");
        }

        resp.sendRedirect("/login.jsp");
    }

    private void clearHolder() {
        Holder.getInfo().clear();
        Holder.getMap().clear();
        Holder.getWords().clear();
        Holder.getInfo().clear();
    }
}
