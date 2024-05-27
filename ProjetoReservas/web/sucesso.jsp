<%-- 
    Document   : sucesso
    Created on : 4 de abr. de 2024, 16:35:39
    Author     : vihma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
         String n = (String)request.getAttribute("ok");
        %>
        <div>
            <div class="alert alert-success" role="alert">
             <p> "<%=n%>" foi cadastrado com sucesso  !! </p>
           </div>
        </div>
    </body>
</html>
