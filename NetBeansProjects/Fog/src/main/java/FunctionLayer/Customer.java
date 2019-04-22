/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author claudia
 */
public class Customer
{
    private String firstname;
    private String lastName;
    private String email;
    private int phonenumber;

    public Customer(String firstname, String lastName, String email, int phonenumber)
    {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber)
    {
        this.phonenumber = phonenumber;
    }
}
