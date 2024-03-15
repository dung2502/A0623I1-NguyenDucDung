package com.example.thitest.Repository.RepositoryImpl;

import com.example.thitest.DTO.RoomDTO;
import com.example.thitest.Model.Room;
import com.example.thitest.Repository.BaseDao;
import com.example.thitest.Repository.IRoomDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao implements IRoomDao {
    private static final String Select_All_Room = "select * from room;";
    private static final String Delete_Room = "delete from room where id = ?";
    private static final String Insert_Room = "insert into room (room_id, person_name, phone_number, rental_start_date, payment_code, " +
            "note) values (?, ?, ?, ?, ?, ?)";
    private static final String Select_All_Room_DTO = " select id, room_id, person_name, phone_number, rental_start_date,payments," +
            " note from room join bill on room.payment_code = bill.payment_code;";
    private static final String Find_Room_By_Name = "   select id, room_id, person_name, phone_number, rental_start_date,payments, note from room join bill on room.payment_code = bill.payment_code where " +
            "room_id like concat('%', ?, '%') or  person_name like concat('%', ?, '%') or payments like concat('%', ?, '%');";

    @Override
    public List<Room> selectAllObj() {
        List<Room> rooms =new ArrayList<>();
        Room room ;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_All_Room);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setRoom_id(resultSet.getString("room_id"));
                room.setPerson_name(resultSet.getString("person_name"));
                room.setPhone_number(resultSet.getString("phone_number"));
                room.setRental_start_date(resultSet.getDate("rental_start_date"));
                room.setPayment_code(resultSet.getInt("payment_code"));
                room.setNote(resultSet.getString("note"));
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.out.println("Bug database showAllObj!");
        }
        return rooms;
    }

    @Override
    public Room selectObj(int id) {

        return null;
    }

    @Override
    public boolean addObj(Room room) {
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Insert_Room);
            preparedStatement.setString(1,room.getRoom_id());
            preparedStatement.setString(2,room.getPerson_name());
            preparedStatement.setString(3, room.getPhone_number());
            preparedStatement.setDate(4,room.getRental_start_date());
            preparedStatement.setInt(5, room.getPayment_code());
            preparedStatement.setString(6,room.getNote());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(" Database addObj!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeObj(int id) {
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Delete_Room);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println("database removeObj!!!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateObj(Room room) {
        return false;
    }

    @Override
    public List<RoomDTO> selectAllObjDTO() {

        List<RoomDTO> rooms =new ArrayList<>();
        RoomDTO room ;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_All_Room_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                room = new RoomDTO();
                room.setId(resultSet.getInt("id"));
                room.setRoom_id(resultSet.getString("room_id"));
                room.setPerson_name(resultSet.getString("person_name"));
                room.setPhone_number(resultSet.getString("phone_number"));
                room.setRental_start_date(resultSet.getDate("rental_start_date"));
                room.setPayments(resultSet.getString("payments"));
                room.setNote(resultSet.getString("note"));
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.out.println("Bug database showAllObjDTO!");
        }
        return rooms;
    }

    @Override
    public List<RoomDTO> findRoomByRoomId(String room_id) {
        List<RoomDTO> roomDTOs = new ArrayList<>();
        RoomDTO roomDTO;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Find_Room_By_Name);
            preparedStatement.setString(1, room_id);
            preparedStatement.setString(2, room_id);
            preparedStatement.setString(3, room_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                roomDTO = new RoomDTO();
                roomDTO.setId(resultSet.getInt("id"));
                roomDTO.setRoom_id(resultSet.getString("room_id"));
                roomDTO.setPerson_name(resultSet.getString("person_name"));
                roomDTO.setPhone_number(resultSet.getString("phone_number"));
                roomDTO.setRental_start_date(resultSet.getDate("rental_start_date"));
                roomDTO.setPayments(resultSet.getString("payments"));
                roomDTO.setNote(resultSet.getString("note"));
                roomDTOs.add(roomDTO);
            }
            return roomDTOs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomDTOs;
    }
}
