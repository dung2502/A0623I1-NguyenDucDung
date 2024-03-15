package com.example.thipart2.Controller;

import com.example.thipart2.DTO.ProductDTO;
import com.example.thipart2.Model.Product;
import com.example.thipart2.Service.IService;
import com.example.thipart2.Service.ServiceImpl.ElementBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/elementManager")
public class ElementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService elementBO;
    public void init() {
        elementBO = new ElementBO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    ShowCreateProduct(req,resp);
                    break;
                case "edit":
                    showEditProduct(req, resp);
                    break;
                case "delete" :
                    delete_product(req, resp);
                    break;
                default:
                    ListProduct(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ListProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        List<ProductDTO> productList = elementBO.selectAllObjDTO();
        req.setAttribute("ListRoom", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/list.jsp");
        dispatcher.forward(req, resp);
    }
    private void delete_product(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        elementBO.removeObj(id);
        List<ProductDTO> productList = elementBO.selectAllObjDTO();
        req.setAttribute("ListRoom", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/list.jsp");
        dispatcher.forward(req, resp);
    }
    private void ShowCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/create.jsp");
        req.setAttribute("ListRoom1", elementBO.selectAllObjDTO());
        dispatcher.forward(req, resp);
    }

    private void showEditProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingStudent = elementBO.selectObject(id);
        System.out.println(existingStudent);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/edit.jsp");
        req.setAttribute("product", existingStudent);
        req.setAttribute("ListRoom1", elementBO.selectObject(id));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    createProduct(req, resp);
                    break;
                case "search":
                    searchProduct(req, resp);
                    break;
                case "edit":
                    updateProduct(req, resp);
                    break;
                default:
                    ListProduct(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String productName = req.getParameter("product_name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        int category = Integer.parseInt(req.getParameter("category_code"));
        Product product = new Product(productName, price, quantity, color, category);
        elementBO.addObj(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/create.jsp");
        req.setAttribute("ListRoom1", elementBO.selectAllObjDTO());
        dispatcher.forward(req,resp);
    }
    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) {
        String search = req.getParameter("search");
        List<ProductDTO> roomDTOList = elementBO.findElement(search);
        req.setAttribute("ListRoom", roomDTOList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/list.jsp");
        try {
            dispatcher.forward(req, resp);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String productName = req.getParameter("product_name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        int category = Integer.parseInt(req.getParameter("category_code"));
        Product product = new Product(productName, price, quantity, color, category);
        RequestDispatcher dispatcher =req.getRequestDispatcher("room/edit.jsp");
        req.setAttribute("product", product);
        req.setAttribute("ListRoom1", elementBO.selectAllObjDTO());
        dispatcher.forward(req, resp);
    }
}
