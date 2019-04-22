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
public class Product
{
    private String tile;
    private String description;
    private int amount; 
    private int id;
    private int price;
    private int length; 
    private int lengthUsed;

    public Product(String tile, String description, int amount, int id, int price, int length, int lengthUsed)
    {
        this.tile = tile;
        this.description = description;
        this.amount = amount;
        this.id = id;
        this.price = price;
        this.length = length;
        this.lengthUsed = lengthUsed;
    }

    public String getTile()
    {
        return tile;
    }

    public void setTile(String tile)
    {
        this.tile = tile;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getLengthUsed()
    {
        return lengthUsed;
    }

    public void setLengthUsed(int lengthUsed)
    {
        this.lengthUsed = lengthUsed;
    }
    
    public int totalPrice()
    {
        return price * amount;
    }   
}
