<%-- 
    Document   : orders
    Created on : Apr 22, 2019, 12:50:37 AM
    Author     : claudia
--%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="FunctionLayer.Customer"%>
<%@page import="FunctionLayer.Order"%>
<%
    //int num = Integer.parseInt(request.getParameter("order"));
    List<Order> orderList = LogicFacade.getOrders();
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
            <a href="index.html">Vis ordre</a>
        </div>

<table class="table table-xstriped" style="margin: 0px">
    <thead>
        <tr>
            <th>Order Number</th>
            <th>Email</th>
            <th>Date</th>
            <th>Name</th>
        </tr>
    </thead>

    <% for (Order order : orderList) {
            Customer cust = order.getCustomer();
    %>
    <tbody>
        <tr
            class="btn-success"
            <td>
                <form action="FrontController" method="post">
                    <input type="hidden" name="command" value="ShowOrder">
                    <input type="hidden" name="orderId" value="<%= order.getOrderid()%>">
                    <input type="hidden" name="loads" value="<%= orderList.size()%>">
                    <input type="submit" class="btn btn-primary" value="Order <%= order.getOrderid()%>">
                </form>

            </td>
            <td><%= cust.getEmail()%></td>
            <td><%= order%></td>
            <td><%= cust.getLastName() + ", " + cust.getFirstname()%></td>
        </tr>
    </tbody>
    <% }%>
</table>

