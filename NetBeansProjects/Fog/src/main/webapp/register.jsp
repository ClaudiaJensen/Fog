<%-- 
    Document   : register
    Created on : Apr 28, 2019, 6:30:57 PM
    Author     : claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/menu.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Opret Bruger</h1>
            <h5 class="contact"> Tlf: nummer 
                <br>  Mail: Carport@ITsupport.dk</h5> 
        </div>

        <div class="topnav">
            <a href="login.jsp">Log ind</a>
            <a href="register.jsp">Opret bruger</a>
            <a href="index.jsp">Køb carport</a>
        </div>
    <center>
        <h2>Indtast email og password</h2>
        <form action="FrontController" method="post" autocomplete="off">
            <td>
                Email<br>
                <input type="text" name="email" value="">
            </td><br>
            <td>
                Password<br>
                <input type="password" name="password" value="">
            </td><br>
            <input type="submit" value="Opret bruger">
            <input type="hidden" name="command" value="register">
        </form>
    </center>
</body>
</html>

