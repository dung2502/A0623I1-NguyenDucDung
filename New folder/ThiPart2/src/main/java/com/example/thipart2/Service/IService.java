package com.example.thipart2.Service;

import com.example.thipart2.DTO.ProductDTO;
import com.example.thipart2.Model.Product;

import java.util.List;

public interface IService {

    Product selectObject(int id);

    boolean addObj(Product e);

    boolean removeObj(int id);

    boolean updateObj(Product e);
    //DTO
    List<ProductDTO> selectAllObjDTO();
    List<ProductDTO> findElement(String id);
}
