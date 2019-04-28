package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
//        String email = request.getParameter( "email" );
//        String password1 = request.getParameter( "password1" );
//        String password2 = request.getParameter( "password2" );
//        if ( password1.equals( password2 ) ) {
//            Employee user = LogicFacade.createUser( email, password1 );
//            HttpSession session = request.getSession();
//            session.setAttribute( "user", user );
//            session.setAttribute( "email", user.getEmail() );
//            return "orders";
//        } else {
//            throw new LoginSampleException( "the two passwords did not match" );
//        }
//    }

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Employee user = new Employee(email, password);
        try
        {
            user = FunctionLayer.LogicFacade.createUser(user);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession ses = request.getSession();
        ses.setAttribute("user", user);
        return "orders";

    }
}
