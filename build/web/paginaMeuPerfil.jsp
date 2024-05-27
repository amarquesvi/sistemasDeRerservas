<%-- 
    Document   : paginaMeuPerfil
    Created on : 24 de mai. de 2024, 15:04:07
    Author     : vihma
--%>


<%@page import="br.com.controle.Usuario"%>
<%@page import="br.com.entidade.ManterUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Obtendo o objeto Usuario da sessão
    HttpSession session = request.getSession();
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Dados do Usuário</title>
</head>
<body>
     <div class="container profile-container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card profile-card">
                    <h5 class="card-header text-center">Dados do Usuário</h5>
                    <div class="card-body">
                        <%
                            // Verificando se o objeto Usuario está presente na sessão
                            if (usuario != null) {
                        %>
                        <!-- Exibindo os dados do usuário -->
                        <p><strong>Código:</strong> <%= usuario.getId() %></p>
                        <p><strong>Nome:</strong> <%= usuario.getNome() %></p>
                        <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
                        <p><strong>Celular:</strong> <%= usuario.getCelular() %></p>
                        <% } else { %>
                        <!-- Caso o usuário não seja encontrado -->
                        <div class="alert alert-warning text-center" role="alert">
                            Usuário não encontrado
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
