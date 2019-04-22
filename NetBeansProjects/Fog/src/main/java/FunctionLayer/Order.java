/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.Calendar;

/**
 *
 * @author claudia
 */
public class Order
{
    private int orderid;
    private Calendar date;
    private Customer customer;
    private double price;
    private Customize customize;

    public Order(int orderid, Calendar date, Customer customer,Customize customize, double price)
    {
        this.orderid = orderid;
        this.date = date;
        this.customer = customer;
        this.customize = customize;
        this.price = price;
    }

    public int getOrderid()
    {
        return orderid;
    }

    public void setOrderid(int orderid)
    {
        this.orderid = orderid;
    }

    public Calendar getDate()
    {
        return date;
    }

    public void setDate(Calendar date)
    {
        this.date = date;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Customize getCustomize()
    {
        return customize;
    }

    public void setCustomize(Customize customize)
    {
        this.customize = customize;
    }
  
}
