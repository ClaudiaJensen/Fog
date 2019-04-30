package FunctionLayer;

import DBAccess.DataFacade;
import DBAccess.EmployeeMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade
{

    public static Employee login(String email, String password) throws LoginSampleException
    {
        return EmployeeMapper.login(email, password);
    }

//    public static Employee createUser( String email, String password ) throws LoginSampleException {
//        Employee user = new Employee(email, password);
//        EmployeeMapper.createUser();
//        return user;
//    }
    
    public static Employee createUser(Employee employee) throws LoginSampleException, ClassNotFoundException
    {
        return DBAccess.EmployeeMapper.createUser(employee);
    }
    

    public static List<Order> getOrders() throws LoginSampleException
    {
        return DataFacade.getAllOrders();
    }

    public static Order getOrder(int orderId) throws LoginSampleException
    {
        if (orderId < 0)
        {
            throw new LoginSampleException("orderid can't be negative");
        }
        return DataFacade.getOrder(orderId);
    }

    public static void makeOrder(Order order) throws LoginSampleException, ClassNotFoundException
    {
        DataFacade.makeOrder(order);
    }

    public static void removeOrder(int orderId) throws LoginSampleException, ClassNotFoundException
    {
        DataFacade.removeOrder(orderId);
    }
    
    public static Employee getUser(String firstName, String password) throws LoginSampleException, ClassNotFoundException
      {
        return DBAccess.EmployeeMapper.getUser(firstName, password);
      }
    
    public static Product getProduct(int id) throws LoginSampleException, ClassNotFoundException {
        return DataFacade.getProduct(id);
    }
    
    public static Calculator getCalculator(Order order) throws LoginSampleException {
        return new Calculator(order);
    }
    
    public static Customize makeCarport(int length, int width, int height, String drawing) throws LoginSampleException
      {
        Customize carport = new Customize(length, width, height);
        carport.setSVGdrawing(drawing);
        return carport;
      }
}
