<%-- 
    Document   : index
    Created on : Apr 30, 2019, 5:06:16 PM
    Author     : claudia
--%>

<%@page import="FunctionLayer.Customize"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/menu.css">
    </head>
    <body>
        <div class="header">
            <h1>Carporte</h1>
            <h5 class="contact"> Tlf: nummer
                <br>  Mail: Carport@ITsupport.dk</h5> 
        </div>

        <div class="topnav">
            <a href="login.jsp">Log ind</a>
            <a href="register.jsp">Opret bruger</a>
            <a href="index.jsp">Køb carport</a>
        </div>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% Order order = (Order) session.getAttribute("order");

            Customize cust = null;

            String length = "", width = "", height = "";

            if (order != null)
            {
                cust = order.getCustomize();
                if (cust != null)
                {
                    length = "" + cust.getLength();
                    width = "" + cust.getWidth();
                    height = "" + cust.getHeight();
                }

            }
        %>
    </head>
<body>
    <script>
        function setMaxShedWidth() {
            var width = document.getElementById("width").value;
            var newWidth = width - 60;
            if (newWidth < 0) {
                newWidth = 0;
            }
            console.log(newWidth);

            document.getElementById("sWidth").max = newWidth;
            setRequiredShed();
        }

        function setMaxShedLength() {
            var length = document.getElementById("length").value;
            var newLength = length - 30;
            if (newLength < 0) {
                newLength = 0;
            }
            console.log(newLength);

            document.getElementById("sLength").max = newLength;
            setRequiredShed();
        }
    </script>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <form name="configure" action="FrontController" method="POST" >

                        <div class="card-header">
                            <h4>Enter Dimentions</h4>
                        </div>
                        <div class="card-body">

                            <input type="hidden" name="command" value="GiveDimentions">
                            <label>
                                <h4>Carport Options</h4>

                                <label>
                                    Length<br>
                                    <input id="length" type="number" class="form-control" name="length"  min="100" placeholder="cm" value="<%= length%>" required>
                                </label>
                                <br>

                                <label>
                                    Width<br>
                                    <input type="number" id="width" onclick="setMaxShedWidth()" class="form-control" name="width" min="100" placeholder="cm" value="<%= width%>" required>
                                </label>
                                <br>

                                <label>
                                    Height<br>
                                    <input type="number" class="form-control" name="height" min="100" max="500" placeholder="cm" value="<%= height%>" required> 
                                </label>
                                <br>
                            </label>
                        </div>
                        <br>
                        <form action="FrontController" method="Post"> 
                            <input type="hidden" name="command" value="carport">
                            <div class="knap">
                                <input type ="submit" value="confirm">
                            </div>

                        </form>
                </div>
                </body>
                </html>
