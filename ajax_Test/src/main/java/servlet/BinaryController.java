package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

@WebServlet(name = "show_words", urlPatterns = {"/show_words"})
public class BinaryController extends HttpServlet {
    private Gson builder = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("I'm alive");
        if (req.getSession().getAttribute("map") != null) {

            try {
                List words = (List) req.getSession().getAttribute("words");
                String JSON_words = builder.toJson(words);
                System.out.println(words);
                resp.setContentType("text/plain");
                resp.getWriter().write(JSON_words);
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
