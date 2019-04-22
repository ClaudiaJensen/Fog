/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudia
 */
public class ProductMapper
{

    public void writeIntoLine(int idProduct, int orderId, int amount, double lengthUsed) throws LoginSampleException, ClassNotFoundException, SQLException
    {
        try
        {
            Connection con = Connector.connection();
            String sql = "INSERT INTO product_line(idproduct,idorder,amount,length_used) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProduct);
            ps.setInt(2, orderId);
            ps.setInt(3, amount);
            ps.setDouble(4, lengthUsed);
            ps.execute();
        } catch (SQLException e)
        {
            throw new LoginSampleException("Could not write into line");
        }
    }
    
    public Product getProduct(int id) throws LoginSampleException, ClassNotFoundException {
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM product WHERE id_product = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            return getAllProducts(pre.executeQuery()).get(0);
        } catch (SQLException e) {
            throw new LoginSampleException("Could not get product");
        }
    }
    
    private List<Product> getAllProducts(ResultSet res) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (res.next()) {

            int id = res.getInt("id_product");
            String title = res.getString("title");
            String description = res.getString("description");
            int length = res.getInt("length");
            int price = res.getInt("price");

            products.add(new Product(title, description, 0, id, price, length, 0));
        }
        return products;
    }
}
