package servlet;

import settingsreader.PropertiesReader;
import settingsreader.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "param", urlPatterns = {"/param"})
public class GetParametrsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<String> list = Arrays.asList(request.getParameterValues("gridRadios"));
        String ip = (String) request.getAttribute("ip");
        request.setAttribute("list", list);
        HashMap map = ChooseRegisters(list);
        session.setAttribute("map", map);
        response.sendRedirect("View_Result.jsp");

    }

    private HashMap ChooseRegisters(List<String> list) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("params/altivar.properties");
        Reader propertiesReader = new PropertiesReader(inputStream, list);
        return (HashMap) propertiesReader.read();
    }
}