<%-- 
    Document   : confirm
    Created on : Apr 30, 2019, 11:16:33 PM
    Author     : claudia
--%>

<%@page import="FunctionLayer.Customer"%>
<%@page import="FunctionLayer.Customize"%>
<%@page import="FunctionLayer.Order"%>
<%
    Order orderOverview = (Order) request.getSession().getAttribute("order");
    Customize custSelected = orderOverview.getCustomize();
    Customer customerSelected = orderOverview.getCustomer();
    
%>

div class="card">
    <div class="card-header">
        <div style="float: right">
            <a class="text-muted" style="">Est. Price:</a> <span class="badge badge-success"><%= orderOverview.getPrice()%> DKK</span>
        </div>