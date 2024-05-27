<%-- 
    Document   : paginaReservar
    Created on : 5 de mai. de 2024, 11:43:36
    Author     : vihma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/reservar.css"/>
        <title>JSP Page</title>
    </head>
   <body>
        
      <div class="container">
    <h1>Reservar </h1>
    <div class="form-container">
        <form id="reservaForm" action="reserva.do" method="post">
            
            <div class="form-group">
                <label for="Reserva">Reserva</label>
              <% 
    // Recuperar o parâmetro de consulta 'local' da URL
    String local = request.getParameter("local");
              %>
<input type="text" id="nome" name="local" value="<%= local %>" readonly>
            </div>
            <div class="form-group">
                <label for="data">Data:</label>
                <input type="date" id="data" name="data">
            </div>
            <div class="form-group">
                <label for="hora">Hora:</label>
                <input type="time" id="hora" name="hora">
            </div>
            <div class="form-group">
                <button type="submit">Confirmar reserva</button>
            </div>
        </form>
    </div>
</div>
    
    <p>${mensagem}</p>
    <p>${codigo}</p>

    </body>
</html>
