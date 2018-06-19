package servlet;

import ConnectionToDevice.Test_Read;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.wimpi.modbus.net.TCPMasterConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "show_Registers", urlPatterns = {"/show_Registers"})
public class Show_Registers extends HttpServlet {
    Test_Read T_read = null;
    Gson builder = new GsonBuilder().create();
    TCPMasterConnection con;

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SocketTimeoutException {
        HttpSession session = request.getSession();
        con = (TCPMasterConnection) session.getAttribute("connect");
        T_read = new Test_Read();
        if (con == null) {
            try {
                T_read.ConnctionTo("127.0.0.1");
                 con = T_read.GetConnection();
                System.out.println(con.isConnected() + " " + "new connect");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something wrong");
            }
        }


            if ((session != null) && session.getAttribute("map") != null) {
                HashMap<String,String > map = (HashMap) session.getAttribute("map");

                try {
                    List complete_list = (List) T_read.CheckValues(map, con, request);
                    String JSON = builder.toJson(complete_list);
                    session.setAttribute("connect",con);
                    response.setContentType("text/plain");
                    response.getWriter().write(String.valueOf(JSON));

                } catch (SocketTimeoutException e) {

                 //   HashMap Complete_map = T_read.CheckValues(map, T_read.GetConnection(), request);
                    List complete_list = (List) T_read.CheckValues(map, T_read.GetConnection(), request);
                    String JSON = builder.toJson(complete_list);
                    session.setAttribute("JSON",JSON);

                    response.setContentType("text/plain");
                    response.getWriter().write(JSON);
                }
            }

        }
    }

