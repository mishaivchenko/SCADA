package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "update_char", urlPatterns = {"/update_char"})
public class update_char {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        Integer progress = 0;
        if ((session != null) && session.getAttribute("Progress") != null)


        response.setContentType("text/plain");
        response.getWriter().write(String.valueOf(progress));
    }
}
