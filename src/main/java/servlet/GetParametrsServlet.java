package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

@WebServlet(name = "param", urlPatterns = {"/param"})
public class GetParametrsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List list = null;
    Map map;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session = request.getSession();

        System.out.println(session.getMaxInactiveInterval());
        list = Arrays.asList(request.getParameterValues("a"));
        String ip = (String) request.getAttribute("ip");
        request.setAttribute("list", list);
        map = ChooseRegisters(list);
        session.setAttribute("map",map);
        response.sendRedirect("View_Result.jsp");
        System.out.println(list);


        if (ip == null){
            session.setAttribute("error_ip","Не корректный ip адресс");
        }



    }

    protected void doGet(HttpServletResponse response, HttpServletRequest request) {
    }



    public HashMap ChooseRegisters(List list) {
        Map map = new HashMap();
        map.put("3205", "Motor_Torque");
        map.put("3204", "Motor_Current");
        map.put("3208", "Motor_voltage");
        map.put("3211", "Motor_power");
        map.put("9630", "Motor_thermal state");
        map.put("7393", "Fault_counter");
        map.put("7270", "DC_bus_voltage");

      Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){

            Map.Entry entry = (Map.Entry) iterator.next();
            if(map.containsKey(entry.getKey())!=list.contains(entry.getKey())) {
                iterator.remove();

            }
        }
        return (HashMap) map;
    }
}