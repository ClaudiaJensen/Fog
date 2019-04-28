/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Customer;
import FunctionLayer.Customize;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author claudia
 */
public class OrderMapper
{

    public List<Order> getOrders(int orderid) throws LoginSampleException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELCET * FROM order where order=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet res = ps.executeQuery();
            List<Order> list = addOrder(res);
            return list;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public List<Order> addOrder(ResultSet res) throws LoginSampleException, ClassNotFoundException
    {
        try
        {
            Connection con = Connector.connection();
            List<Order> orderList = new ArrayList<>();
            while (res.next())
            {
                int idorder = res.getInt("id_order");
                Calendar date = Calendar.getInstance();
                Timestamp ts = res.getTimestamp("date");
                date.setTime((Date) ts);
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String email = res.getString("email");
                int length = res.getInt("length");
                int width = res.getInt("width");
                int height = res.getInt("height");
                double price = res.getDouble("price");

                Customer customer = new Customer(firstname, lastname, email);
                Customize customize = new Customize(length, height, width);
                Order order = new Order(idorder, date, customer, customize, price);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException ex)
        {
            throw new LoginSampleException("Could not find order");
        }

    }
    
    public void removeOrder(int orderId) throws LoginSampleException, ClassNotFoundException {
        String sql = "DELETE FROM .order WHERE id_order = ?";
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.execute();
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public void makeOrder(Order order) throws LoginSampleException, ClassNotFoundException {
        String sql = "INSERT INTO order(firstname, lastname, email, length, width, height, shed, price)"
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getCustomer().getFirstname());
            ps.setString(2, order.getCustomer().getLastName());
            ps.setString(3, order.getCustomer().getEmail());
            ps.setInt(4, order.getCustomize().getLegth());
            ps.setInt(5, order.getCustomize().getWidth());
            ps.setInt(6, order.getCustomize().getHeight());
            ps.setDouble(7, order.getPrice());
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();
            res.next();
            order.setOrderid(res.getInt(1));

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
