<%-- 
    Document   : paginaMinhasReservas
    Created on : 4 de mai. de 2024, 17:19:37
    Author     : vihma
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.controle.Reserva"%>
<%@page import="br.com.controle.Usuario"%>
<%@page import="br.com.entidade.ManterReservas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Minhas Reservas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    
    <body>
        <div class="container">
            <h2 class="text-center">Minhas Reservas</h2>
            <div class="table-responsive">
                <%
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    if (usuario == null) {
                        out.println("<p class='text-center text-warning'>Usuário não autenticado.</p>");
                    } else {
                        ManterReservas manterReservas = new ManterReservas();
                        List<Reserva> listaReservas = manterReservas.buscarReservasPorUsuario(usuario.getId());

                        if (listaReservas.isEmpty()) {
                            out.println("<p class='text-center text-warning'>Não há reservas feitas.</p>");
                        } else {
                %>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Local</th>
                            <th>Data</th>
                            <th>Hora</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Reserva reserva : listaReservas) {
                        %>
                        <tr>
                            <td class="text-center"><%= reserva.getId_reserva() %></td>
                            <td class="text-center"><%= reserva.getLocal_reserva() %></td>
                            <td class="text-center"><%= reserva.getData_reserva() %></td>
                            <td class="text-center"><%= reserva.getHora_reserva() %></td>
                            <td class="text-center">
                                <a href="alterarReserva?id=<%= reserva.getId_reserva() %>" data-toggle="tooltip" title="Alterar">
                                    <span class="glyphicon glyphicon-pencil text-primary"> </span>
                                </a>
                                <a href="excluirReserva?id=<%= reserva.getId_reserva() %>" onclick="return confirm('Confirma exclusão da reserva <%= reserva.getLocal_reserva() %>?')" data-toggle="tooltip" title="Excluir">
                                    <span class="glyphicon glyphicon-trash text-danger"> </span>
                                </a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <%
                        }
                    }
                %>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>