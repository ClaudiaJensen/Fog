<%-- 
    Document   : orders
    Created on : Apr 22, 2019, 12:50:37 AM
    Author     : claudia
--%>

<%@page import="DBAccess.OrderMapper"%>
<%@page import="FunctionLayer.Customer"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%
    int num = Integer.parseInt(request.getParameter("order"));
    List<Order> orderList = LogicFacade.getOrders();
%>




<table class="table table-xstriped" style="margin: 0px">
    <thead>
        <tr>
            <th>Order Number</th>
            <th>Email</th>
            <th>Date</th>
            <th>Name</th>
            <th>Phonenumber</th>
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
            <td><%= cust.getPhonenumber()%></td>
        </tr>
    </tbody>
    <% }%>
</table>

