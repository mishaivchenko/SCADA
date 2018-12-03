package servlet;

import utill.ResultSaver;
import utill.ResultSaverToFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveResultController", urlPatterns = "/saveResult")
public class SaveResultsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultSaver resultSaver = new ResultSaverToFile();
        resultSaver.save();
        req.setAttribute("result","results successfully added to file");
        req.getRequestDispatcher("/saveResults.jsp").forward(req,resp);
    }

}
