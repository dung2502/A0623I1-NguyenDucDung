package com.example.thipart2.Service.ServiceImpl;

import com.example.thipart2.DTO.ProductDTO;
import com.example.thipart2.Model.Product;
import com.example.thipart2.Repository.IRepository;
import com.example.thipart2.Repository.RepositoryImpl.ElementDao;
import com.example.thipart2.Service.IService;

import java.util.List;

public class ElementBO implements IService {
    private IRepository elementDao = new ElementDao();


    @Override
    public Product selectObject(int id) {
        return elementDao.selectObject(id);
    }

    @Override
    public boolean addObj(Product product) {
        return elementDao.addObj(product);
    }


    @Override
    public boolean removeObj(int id) {
        return elementDao.removeObj(id);
    }

    @Override
    public boolean updateObj(Product e) {
        return elementDao.updateObj(e);
    }


    @Override
    public List selectAllObjDTO() {

        return elementDao.selectAllObjDTO();
    }

    @Override
    public List<ProductDTO> findElement(String id) {

        return elementDao.findElement(id);
    }
}
