package com.example.thitest.Repository;

import com.example.thitest.DTO.RoomDTO;
import com.example.thitest.Model.Room;

import java.util.List;

public interface IRoomDao extends IRepository<Room> {
    @Override
    List<Room> selectAllObj();

    @Override
    Room selectObj(int id);

    @Override
    boolean addObj(Room room);

    @Override
    boolean removeObj(int id);

    @Override
    boolean updateObj(Room room);
    //DTO
    List<RoomDTO> selectAllObjDTO();
    List<RoomDTO> findRoomByRoomId(String room_id);
}
