package com.example.thitest.Controller;

import com.example.thitest.DTO.RoomDTO;
import com.example.thitest.Model.Room;
import com.example.thitest.Service.IService;
import com.example.thitest.Service.ServiceImpl.RoomBO;

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

@WebServlet(name = "RoomServlet", value = "/roomsManager")
public class RoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService roomBO;

    public void init() {
        roomBO = new RoomBO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    ShowCreateRoom(req, resp);
                    break;
                case "delete":
                    delete_room(req, resp);
                    break;
                default:
                    ListRoom(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ListRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<RoomDTO> roomList = roomBO.selectAllObjDTO();
        req.setAttribute("ListRoom", roomList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void delete_room(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        roomBO.removeObj(id);
        List<RoomDTO> roomList = roomBO.selectAllObjDTO();
        req.setAttribute("ListRoom", roomList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void ShowCreateRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/create.jsp");
        req.setAttribute("ListRoom1", roomBO.selectAllObj());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createRoom(req, resp);
                    break;
                case "search":
                    searchRoom(req, resp);
                    break;
                default:
                    ListRoom(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createRoom(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String room_id = req.getParameter("room_id");
        String person_name = req.getParameter("person_name");
        String phone_number = req.getParameter("phone_number");
        Date rental_start_date = Date.valueOf(req.getParameter("rental_start_date"));
        int payment_code = Integer.parseInt(req.getParameter("payment_code"));
        String note = req.getParameter("note");
        Room room = new Room(room_id, person_name, phone_number, rental_start_date, payment_code, note);
        roomBO.addObj(room);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/create.jsp");
        req.setAttribute("ListRoom1", roomBO.selectAllObj());
        dispatcher.forward(req, resp);
    }

    private void searchRoom(HttpServletRequest req, HttpServletResponse resp) {
        String room_id = req.getParameter("room_id");
        List<RoomDTO> roomDTOList = roomBO.findRoomByRoomId(room_id);
        req.setAttribute("ListRoom", roomDTOList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("room/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
