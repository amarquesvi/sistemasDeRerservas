<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/reservar.css"/>
        <title>Página de Reservas </title>
    </head>
    <body>
        <div class="container">
            <h1>Reservar </h1>
            <div class="form-container">
                <form id="reservaForm" action="${pageContext.request.contextPath}/ReservarServlet" method="post">
                    <div class="form-group">
                        <label for="Reserva">Reserva</label>
                        <input type="text" id="nome" name="local" value="${param.local}" readonly>
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
                <c:if test="${not empty mensagem}">
                    <div class="error-message">${mensagem}</div>
                </c:if>
            </div>
        </div>
    </body>
</html>