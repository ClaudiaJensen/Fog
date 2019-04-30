/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customize;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claudia
 */
public class Carport extends Command
{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        try
        {
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));
            String drawing = SVG.carporSVG(length, width, height);
            Customize carport = FunctionLayer.LogicFacade.makeCarport(length, width, height, drawing);
            request.setAttribute("carport", carport);

        } catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Only numbers!");
        }

        return "carport";
    }

}
