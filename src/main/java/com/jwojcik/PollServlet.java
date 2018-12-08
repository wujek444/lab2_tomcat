package com.jwojcik;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author jrwoj
 * createdOn 05.12.2018
 */
public class PollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pl\"><head><meta charset=\"UTF-8\"></head><body>");
        out.println("<h2>Wybrano nastepujace technologie:</h2>");
        out.println("<ul>");

        parameterMap.keySet().forEach(key -> out.println("<li>" + key + "</li>"));

        out.println("</ul>");
        out.println("</body></html>");
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("PollServlet.html");
        view.forward(req, resp);
    }




}
