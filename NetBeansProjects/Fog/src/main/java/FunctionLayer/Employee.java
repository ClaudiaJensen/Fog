package FunctionLayer;

/**
 * The purpose of Employee is to...
 * @author kasper
 */
public class Employee {
    
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    //private String role;
    private String firstName;
    private String lastName;

    public Employee()
    {
    }

    public Employee(String email, String password, String firstName, String lastName)
    {
        this.email = email;
        this.password = password;
        //this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
    
     public Employee(String email, String password, int id)
    {
        this.email = email;
        this.password = password;
        this.id = id;
    }
   
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}