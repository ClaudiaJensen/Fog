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
public class Customize
{
    private int length;
    private int height;
    private int width;
    private String SVGdrawing;
    
    public static final int padding = 30;
    public static final int beam = 5;

    public Customize(int length, int height, int width)
    {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public String getSVGdrawing()
    {
        return SVGdrawing;
    }

    public void setSVGdrawing(String SVGdrawing)
    {
        this.SVGdrawing = SVGdrawing;
    }
    
    
    
    
}
