package com.example.thipart2.Repository.RepositoryImpl;

import com.example.thipart2.DTO.ProductDTO;
import com.example.thipart2.Model.Product;
import com.example.thipart2.Repository.BaseDao;
import com.example.thipart2.Repository.IRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElementDao implements IRepository {
    private static final String Delete_Element = "delete from Product where id = ?";
    private static final String Select_Product = "select product_name, price, quantity, color, category_code from Product where id = ?";
    private static final String Insert_Element = "insert into Product (product_name, price, quantity, color, category_code) " +
            "values (?, ?, ?, ?, ?)";
    private static final String Select_All_Element_DTO = " select id, product_name, price, quantity, color, ioption " +
            "from Product join category on Product.category_code = category.category_code;";
    private static final String Find_Element_By_Name = " select id, product_name, price, quantity, color, ioption from product join category on product.category_code = category.category_code " +
            "where product_name like concat('%', ?, '%') or  price like concat('%', ?, '%') " +
            "or quantity like concat('%', ?, '%') or color like concat('%', ?, '%') " +
            "or ioption like concat('%', ?, '%');";

    private static final String UPDATE_PRODUCT_SQL =" update prodcut set product_name = ?, price = ?, " +
            "quantity = ?, color = ?, ioption = ? where id = ?";



    @Override
    public Product selectObject(int id) {
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_Product);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setCategory_code(resultSet.getInt("category_code"));
                return product;
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addObj(Product product) {
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Insert_Element);
            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setInt(5, product.getCategory_code());
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
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Delete_Element);
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
    public boolean updateObj(Product product) {

        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory_code());
            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println("Error connecting to database!");
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<ProductDTO> selectAllObjDTO() {
        List<ProductDTO> products =new ArrayList<>();
        ProductDTO product ;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_All_Element_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new ProductDTO();
                product.setId(resultSet.getInt("id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setCategory(resultSet.getString("ioption"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.out.println("Bug database showAllObjDTO!");
        }
        return products;
    }

    @Override
    public List<ProductDTO> findElement(String id) {
        List<ProductDTO> products = new ArrayList<>();
        ProductDTO product;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Find_Element_By_Name);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, id);
            preparedStatement.setString(4, id);
            preparedStatement.setString(5, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new ProductDTO();
                product.setId(resultSet.getInt("id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setCategory(resultSet.getString("ioption"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
