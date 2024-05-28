<%@page import="br.com.controle.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Obtendo o objeto Usuario da sessão
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String mensagem = (String) request.getAttribute("mensagem");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Dados do Usuário</title>
</head>
<body>
    <div class="container profile-container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card profile-card">
                    <h5 class="card-header text-center">Dados do Usuário</h5>
                    <div class="card-body">
                        <% if (usuario != null) { %>
                            <p><strong>Código:</strong> <%= usuario.getId() %></p>
                            <p><strong>Nome:</strong> <%= usuario.getNome() %></p>
                            <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
                            <p><strong>Celular:</strong> <%= usuario.getCelular() %></p>
                        <% } else { %>
                            <div class="alert alert-warning text-center" role="alert">
                                <%= mensagem != null ? mensagem : "Usuário não encontrado" %>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Adicionando Bootstrap JS e dependências -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>