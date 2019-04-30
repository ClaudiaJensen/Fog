/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudia
 */
public class Calculator
{

    private Order order;
    private Customize customize;
    private List<Product> products;
    private final double WIDTH;
    private final double LENGTH;

    public Calculator(Order order) throws LoginSampleException
    {
        this.WIDTH = customize.getWidth();
        this.LENGTH = customize.getLength();
        this.order = order;
        this.customize = order.getCustomize();
        this.products = new ArrayList<>();
    }

    public void calculate()
    {
        List<Product> toRemove = new ArrayList<>();

        for (int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getAmount() < 1)
            {
                toRemove.add(products.get(i));
            }
        }

        products.removeAll(toRemove);

    }

    public double getTotalPrice() throws LoginSampleException, ClassNotFoundException
    {
        double price = 0.0;
        for (Product prod : products)
        {
            Product product = LogicFacade.getProduct(prod.getId());
            product.setAmount(prod.getAmount());
            price += product.totalPrice();
        }
        return price;
    }
}
