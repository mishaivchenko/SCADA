package servlet;

import ConnectionToDevice.ParamsReader;
import Entity.Device;
import Entity.Holder;
import Entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.wimpi.modbus.net.TCPMasterConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "show_Registers", urlPatterns = {"/show_Registers"})
public class Show_Registers extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Gson builder = new GsonBuilder().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null && user.getUserRole() == User.Role.ADMIN) {
            TCPMasterConnection con = (TCPMasterConnection) session.getAttribute("connect");
            ParamsReader t_read = new ParamsReader();
            if (con == null) {
                try {
                    t_read.ConnctionTo("127.0.0.1");
                    con = t_read.GetConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (session.getAttribute("map") != null) {
                HashMap map = (HashMap) session.getAttribute("map");
                try {
                    Map<String, List<Device>> allParams = t_read.CheckValues(map, con);
                    Holder.setValues(allParams.get("values"));
                    Holder.setWords(allParams.get("words"));
                    Holder.setInfo(allParams.get("info"));
                    String JSON = builder.toJson(allParams.get("values"));
                    session.setAttribute("connect", con);
                    this.getServletContext().setAttribute("JSON", JSON);
                    response.setContentType("text/plain");
                    response.getWriter().write(JSON);
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
            }
        } else {
            response.setContentType("text/plain");
            response.getWriter().write(String.valueOf(this.getServletContext().getAttribute("JSON")));
        }
    }


}

