/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Employee;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author claudia
 */
public class DataFacade
{

    public static List<Order> getAllOrders() throws LoginSampleException
    {
        return new OrderMapper().getOrders(-1);
    }

    public static Order getOrder(int orderId) throws LoginSampleException
    {
        return new OrderMapper().getOrders(orderId).get(0);
    }

    public static void makeOrder(Order order) throws LoginSampleException, ClassNotFoundException
    {
        new OrderMapper().makeOrder(order);
    }

    public static void removeOrder(int orderId) throws LoginSampleException, ClassNotFoundException
    {
        new OrderMapper().removeOrder(orderId);
    }
    
    public static void CreateEmployee(Employee employee) throws LoginSampleException {
        new EmployeeMapper().createUser(employee);
    }

    
    public static void writeLine(Product prod, int orderId) throws LoginSampleException, ClassNotFoundException, SQLException {
        new ProductMapper().writeIntoLine(prod.getId(), orderId, prod.getAmount(), prod.getLengthUsed());
    }
    
    public static Product getProduct(int id) throws LoginSampleException, ClassNotFoundException {
        return new ProductMapper().getProduct(id);
    }
}
