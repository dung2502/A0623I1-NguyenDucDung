package com.example.ttt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", value = "/convert")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        float euro = Float.parseFloat(request.getParameter("euro"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float rate_usd = 24000;
        float rate_euro = 26800;
        float vnd_usd = rate_usd * usd;
        float vnd_euro = rate_euro * euro;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Rate: " + euro + "</h1>");
        writer.println("<h1>USD: " + usd + "</h1>");
        writer.println("<h1>VND: " + vnd_euro + "</h1>");
        writer.println("<h1>VND: " + vnd_usd + "</h1>");
        writer.println("</html>");
    }
}