/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.LoginSampleException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author claudia
 */
public class CreateNewEmployee extends Command
{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
      {
        String firstName = request.getParameter("firstname");
        String password = request.getParameter("password");
        Employee user = new Employee();
        try
        {
            user = FunctionLayer.LogicFacade.getUser(firstName, password);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CreateNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "user";
      }

    }

