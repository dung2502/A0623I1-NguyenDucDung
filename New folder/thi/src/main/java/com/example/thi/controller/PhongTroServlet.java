package com.example.thi.controller;

import com.example.thi.model.phongTro;
import com.example.thi.sercvice.IPhong_TroBO;
import com.example.thi.sercvice.Sercvice.Phong_TroBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PhongTroServlet", value = "/phongTro")
public class PhongTroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IPhong_TroBO phongTroBO;

    public void init() {
        phongTroBO = new Phong_TroBO();
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
                    ShowCreate(req, resp);
                    break;
                case "delete" :
                    deletePhong(req, resp);
                    break;
                default:
                    DanhSachPhongTro(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void DanhSachPhongTro(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        List<phongTro> danhSach = phongTroBO.selectAllObj();
        req.setAttribute("danhSachPhong", danhSach);
        RequestDispatcher dispatcher = req.getRequestDispatcher("phongTro/list.jsp");
        dispatcher.forward(req, resp);
    }
    private void deletePhong(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        phongTroBO.removeObj(id);
        List<phongTro> danhSach = phongTroBO.selectAllObj();
        req.setAttribute("danhSachPhong", danhSach);
        RequestDispatcher dispatcher = req.getRequestDispatcher("phongTro/list.jsp");
        dispatcher.forward(req, resp);
    }
    private void ShowCreate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("phongTro/create.jsp");
        req.setAttribute("danhSachPhong", phongTroBO.selectAllObj());
        dispatcher.forward(req, resp);
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
                    break;
                default:
                    DanhSachPhongTro(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
