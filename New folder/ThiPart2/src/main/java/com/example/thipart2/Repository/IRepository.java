package com.example.thipart2.Repository;

import com.example.thipart2.DTO.ProductDTO;
import com.example.thipart2.Model.Product;

import java.util.List;

public interface IRepository {

    Product selectObject(int id);

    boolean addObj(Product o);

    boolean removeObj(int id);

    boolean updateObj(Product e);
    //DTO
    List<ProductDTO> selectAllObjDTO();
    List<ProductDTO> findElement(String id);
}

