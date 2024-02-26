package com.example.thitest.Service.ServiceImpl;

import com.example.thitest.Model.Room;
import com.example.thitest.Repository.IRoomDao;
import com.example.thitest.Repository.RepositoryImpl.RoomDao;
import com.example.thitest.Service.IService;

import java.util.List;

public class RoomBO implements IService {
    private IRoomDao roomDao = new RoomDao();
    @Override
    public List<Room> selectAllObj() {
        return roomDao.selectAllObj();
    }

    @Override
    public Room selectObj(int id) {
        return null;
    }

    @Override
    public boolean addObj(Room e) {
        return false;
    }

    @Override
    public boolean removeObj(int id) {
        return false;
    }

    @Override
    public boolean updateObj(Room e) {
        return false;
    }
}
