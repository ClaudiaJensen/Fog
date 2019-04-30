<%-- 
    Document   : login
    Created on : 10-Dec-2018, 02:40:37
    Author     : Patrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/menu.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Log Ind</h1>
            <h5 class="contact"> Tlf: nummer 
                <br>  Mail: Carport@ITsupport.dk</h5> 
        </div>

        <div class="topnav">
            <a href="login.jsp">Log Ind</a>
            <a href="register.jsp">Opret Bruger</a>
            <a href="index.jsp">Køb carport</a>
        </div>
    <center>
        <br>
        <form action="FrontController" method="post" autocomplete="off">
            <td>
                Email<br>
                <input type="text" name="email" value="">
            </td><br>
            <td>
                Password<br>
                <input type="password" name="password" value="">
            </td><br>
            <input type="submit" value="Login">
            <input type="hidden" name="command" value="login">
        </form>
        <br>
    </center>
</body>
</html>
