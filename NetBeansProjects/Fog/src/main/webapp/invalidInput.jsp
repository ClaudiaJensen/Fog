<%-- 
    Document   : InvalidInput
    Created on : Apr 28, 2019, 6:06:12 PM
    Author     : claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
    <center>
        <h1>Teknisk fejl, noget gik galt</h1>
        <br>
        <h3><% out.print(request.getAttribute("error"));%></h3>
        <form>
            <input type="button" value="Prøv igen" onclick="history.back()"> 
        </form>
    </center>
</body>
</html>
