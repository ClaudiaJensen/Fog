<%-- 
    Document   : carport
    Created on : May 1, 2019, 1:05:03 AM
    Author     : claudia
--%>

<%@page import="FunctionLayer.Customize"%>
<%@page import="PresentationLayer.Carport"%>
<html>
    <head>
        <link rel="stylesheet" href="CSS/menu.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oversigt</title>
    </head>
    <div class="header">
        <h1>Velkommen</h1>
        <h5 class="contact"> Tlf: 12 34 56 78 
            <br>  Mail: Fog@ITsupport.dk</h5> 
    </div>

    <div class="topnav">
        <a href="login.jsp">Log Ind</a>
        <a href="register.jsp">Opret Bruger</a>
        <a href="index.html">Pre Definerede Carporte</a>
    </div>
    <%
        Customize carport = (Customize) request.getAttribute("carport");
    %>
    <body>
    <center>
        <h1>Oversigt over carport</h1>
        <div id="SVG-drawing">
            <%
                out.print(carport.getSVGdrawing());
            %>
        </div>

        <br>
        <hr>
        <form>
            <input type="button" value="Byg en carport med andre mål" onclick="history.back()">
        </form>

    </center>
</body>
</html>

