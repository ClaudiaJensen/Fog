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
    //int num = Integer.parseInt(request.getParameter("order"));
    Order selectedOrder = (Order) request.getAttribute("order");
    int loads = 0;
    if (request.getParameter("loads") != null)
    {
        loads = Integer.parseInt(request.getParameter("loads"));
    }
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
    </table>
    <div class="col-lg-6">
        <div class="card">
            <div class="card-header">
                <div>
                    <h3>Contents of Order </h3>
                </div>
            </div>
            <div style="height: 300px; width: 50%; margin: auto; ">
                <%@include file="../WEB-INF/svg.jsp" %>
            </div>
        </div>
        <div class="card-footer bg-light text-dark" style="padding: 0px">
            <% Calculator calc = LogicFacade.getCalculator(selectedOrder);
                calc.calculate();

                double productPrice = calc.getTotalPrice();
                double price = selectedOrder.getPrice();
                double diff = price - productPrice;
            %>
            <table class="table" style="width: 100%; margin-bottom: 0px">
                <tbody>
                    <tr class="text-primary">
                        <td><p >Total Product Price</p></td>
                        <td><p style="float: right"><%= productPrice%> DKK</p></td>
                    </tr>
                    <tr class="text-secondary">
                        <td><p>
                                <% if (diff < 0)
                                    {
                                        out.print("-");
                                    } else
                                    {
                                        out.print("+");
                                    }%>
                            </p></td>
                        <td><p style="float: right"><%= Math.abs(diff)%> DKK</p></td>
                    </tr>
                    <tr>
                        <th><p>Total price</p></th>
                        <th><p style="float:right"><%= price%> DKK</p></th>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div style="float: left; padding: 5px">
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="ConfirmOrder">
            <input type="hidden" name="orderId" value="<%= selectedOrder.getOrderid()%>">
            <input type="hidden" name="loads" value="<%= loads%>">
            <input type="submit" class="btn btn-success" value="Confirm">
        </form>
    </div>
    <div style="float: left; padding: 5px">
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="EditOrderPage">
            <input type="hidden" name="orderToEdit" value="<%= selectedOrder.getOrderid()%>">
            <input type="submit" class="btn btn-primary" value="Edit">
        </form>
    </div>
    <div style="float: left; padding: 5px">
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="DeleteOrder">
            <input type="hidden" name="orderToDelete" value="<%= selectedOrder.getOrderid()%>">
            <input type="hidden" name="loads" value="<%= loads%>">
            <input type="submit" class="btn btn-danger" value="Delete">
        </form>
    </div>
</div>

</div>

</div>

</body>
</html>


