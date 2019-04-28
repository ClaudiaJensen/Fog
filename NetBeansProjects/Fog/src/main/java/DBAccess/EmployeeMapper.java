/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author claudia
 */
public class EmployeeMapper
{
//    public static void createUser( Employee employee ) throws LoginSampleException {
//        try {
//            Connection con = Connector.connection();
//            String SQL = "INSERT INTO employee (email, password, firstname, lastname) VALUES (?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
//            ps.setString( 1, employee.getEmail() );
//            ps.setString( 2, employee.getPassword() );
//            //ps.setString( 3, employee.getRole() );
//            ps.setString(4, employee.getFirstName());
//            ps.setString(5, employee.getLastName());
//            ps.executeUpdate();
//            ResultSet ids = ps.getGeneratedKeys();
//            ids.next();
//            int id = ids.getInt( 1 );
//            employee.setId( id );
//        } catch ( SQLException | ClassNotFoundException ex ) {
//            throw new LoginSampleException( ex.getMessage() );
//        }
    public static Employee createUser(Employee user) throws LoginSampleException, ClassNotFoundException
      {
        try
          {
            String SQL = "INSERT INTO employee (email, password) VALUES (?, ?)";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
          } catch (SQLException ex)
          {
            throw new LoginSampleException(ex.getMessage());
          }
        return user;
      }

    public static Employee login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id_employee FROM employee "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "id_employee" );
                Employee employee = new Employee( email, password);
                employee.setId( id );
                return employee;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static Employee getUser(String email, String password) throws LoginSampleException, ClassNotFoundException
      {
        Employee user = null;
        try
          {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM employee WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id_employee");
            user = new Employee(email, password, id);
          } catch (SQLException ex)
          {
            throw new LoginSampleException("Brugeren findes ikke");
          }
        return user;
      }

}
