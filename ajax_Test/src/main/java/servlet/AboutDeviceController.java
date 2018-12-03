package servlet;

import Entity.Holder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

@WebServlet(name = "show_info", urlPatterns = {"/show_info"})
public class AboutDeviceController extends HttpServlet {
    private Gson builder = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List info = Holder.getInfo();
            if (info != null) {
                String JSON_info = builder.toJson(info);
                resp.setContentType("text/plain");
                resp.getWriter().write(JSON_info);
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
    }
}

