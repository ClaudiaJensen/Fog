/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

/**
 *
 * @author claudia
 */
public class SVG
{
    public static String carporSVG(int length, int width, int height)
    {
        //Draws the outer walls of the carport.
        StringBuilder sb = new StringBuilder();
        int viewBoxWidth = width+20;
        int viewBoxlength = length+20;
        
        sb.append("<svg width=700 height=400 viewBox=\"0 0 ").append(viewBoxWidth).append(" ").append(viewBoxlength).append("\">");
        sb.append("<rect x=\"10\" y=\"10\" width=\"").append(width).append("\"height=\"").append(length).append("\" style=\"stroke:#000000; stroke-width:5px; fill:white\"/>");

        //Posts
        int startX = 120;
        int endX = width - 120;
        int endY = length - 45;
        int startRaft = 10;
        if (width < 600)
        {
            sb.append("<rect x=\"").append(startX).append("\" y=\"45\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
            sb.append("<rect x=\"").append(endX).append("\" y=\"45\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
            sb.append("<rect x=\"").append(startX).append("\" y=\"").append(endY).append("\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
            sb.append("<rect x=\"").append(endX).append("\" y=\"").append(endY).append("\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");

        } else
        {
            sb.append("<rect x=\"").append(startX).append("\" y=\"45\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
            sb.append("<rect x=\"").append(endX).append("\" y=\"45\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");

            sb.append("<rect x=\"50%\" y=\"45\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
            sb.append("<rect x=\"50%\" y=\"").append(endY).append("\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");

            sb.append("<rect x=\"").append(startX).append("\" y=\"").append(endY).append("\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
            sb.append("<rect x=\"").append(endX).append("\" y=\"").append(endY).append("\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:white\"/>");
        }
        
        //Straps
        {
            sb.append("<rect x=\"10\" y=\"45\" width=\"").append(width).append("\" height=\"10\"\n style=\"stroke:#000000; opacity: 0.5; fill:white\"/>");
            sb.append("<rect x=\"10\" y=\"").append(endY).append("\" width=\"").append(width).append("\" height=\"10\"\n style=\"stroke:#000000; opacity: 0.5; fill:white\"/>");
        }

        //Rafters
        while (startRaft < width)
        {
            sb.append("<rect x=\"").append(startRaft).append("\" y=\"10\" width=\"5\" height=\"").append(length).append("\" style=\"stroke:#000000; fill:white\"/>");
            startRaft = startRaft + 55;

        }
        
        //Cross band
        sb.append("<line x1=\"").append(startX).append("\" y1=\"45\" x2=\"").append(endX).append("\" y2=\"").append(endY).append("\" stroke=\"black\" stroke-dasharray=\"5\"/>");
        sb.append("<line x1=\"").append(startX).append("\" y1=\"").append(endY).append("\" x2=\"").append(endX).append("\" y2=\"45\" stroke=\"black\" stroke-dasharray=\"5\"/>");
        sb.append("</svg");

        return sb.toString();
    }
}
