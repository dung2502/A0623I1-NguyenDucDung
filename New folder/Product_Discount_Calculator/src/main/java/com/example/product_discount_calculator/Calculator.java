package com.example.product_discount_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        double List_Price = Float.parseFloat(request.getParameter("list_price"));
        double Discount_Percent = Float.parseFloat(request.getParameter("discount_percent"));
        double Discount_Amount = List_Price * Discount_Percent * 0.01;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Discount Amount = " + Discount_Amount + "</h1>");
        writer.println("</html>");
    }
}