<%-- 
    Document   : orders
    Created on : Apr 22, 2019, 12:50:37 AM
    Author     : claudia
--%>
<%@page import="FunctionLayer.Customize"%>
<%@page import="FunctionLayer.Calculator"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="FunctionLayer.Customer"%>
<%@page import="FunctionLayer.Order"%>
<%
    Order selectedOrder = (Order) request.getAttribute("order");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/menu.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>order Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Orders</h1>
            <h5 class="contact"> Tlf: nummer 
                <br>  Mail: Carport@ITsupport.dk</h5> 
        </div>

        <div class="topnav">
            <a href="login.jsp">Log ind</a>
            <a href="register.jsp">Opret bruger</a>
            <a href="index.jsp">Køb carport</a>
        </div>
    <div class="col-lg-6">
        <div class="card">
            <div class="card-header">
                <div>
                    <h3>Contents of Order </h3>
                </div>
            </div>
        </div>
        <div class="card-footer bg-light text-dark" style="padding: 0px">
            <% Calculator calc = LogicFacade.getCalculator(selectedOrder);
                calc.calculate();

                double productPrice = calc.getTotalPrice();
                double price = selectedOrder.getPrice();
            %>
            <table class="table" style="width: 100%; margin-bottom: 0px">
                <tbody>
                    <tr class="text-primary">
                        <td><p >Total Product Price</p></td>
                        <td><p style="float: right"><%= productPrice%> DKK</p></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>


