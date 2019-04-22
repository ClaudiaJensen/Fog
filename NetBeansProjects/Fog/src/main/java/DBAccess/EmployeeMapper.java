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
    public static void createUser( Employee employee ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO employee (email, password, role, firstname, lastname) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, employee.getEmail() );
            ps.setString( 2, employee.getPassword() );
            ps.setString( 3, employee.getRole() );
            ps.setString(4, employee.getFirstName());
            ps.setString(5, employee.getLastName());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            employee.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static Employee login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM employee "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                Employee employee = new Employee( email, password, role );
                employee.setId( id );
                return employee;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static Employee getUser(String firstname, String password) throws LoginSampleException, ClassNotFoundException
      {
        Employee user = null;
        try
          {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM employee WHERE firstname = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, firstname);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id_employee");
            user = new Employee(firstname, password, id);
          } catch (SQLException ex)
          {
            throw new LoginSampleException("Brugeren findes ikke");
          }
        return user;
      }

}
