package com.example.thitest.Service;

import com.example.thitest.DTO.RoomDTO;
import com.example.thitest.Model.Room;

import java.util.List;

public interface IService {
    List<Room> selectAllObj();

    Room selectObj(int id);

    boolean addObj(Room e);

    boolean removeObj(int id);

    boolean updateObj(Room e);
    //DTO
    List<RoomDTO> selectAllObjDTO();
    List<RoomDTO> findRoomByRoomId(String room_id);



}
