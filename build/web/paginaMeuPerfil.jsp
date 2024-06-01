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
                            <!-- Botão para abrir o formulário de atualização -->
                            <button type="button" class="btn btn-primary" onclick="showUpdateForm()">Atualizar Dados</button>
                            <!-- Formulário de atualização (inicialmente oculto) -->
                            <form action="atualizarUsuario.do" method="post" id="updateForm" style="display: none;">
                                <div class="form-group">
                                    <label for="nome">Novo Nome:</label>
                                    <input type="text" class="form-control" id="nome" name="nome">
                                </div>
                                <div class="form-group">
                                    <label for="email">Novo Email:</label>
                                    <input type="email" class="form-control" id="email" name="email">
                                </div>
                                <div class="form-group">
                                    <label for="celular">Novo Celular:</label>
                                    <input type="text" class="form-control" id="celular" name="celular">
                                </div>
                                <button type="submit" class="btn btn-primary">Salvar</button>
                            </form>
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

        <script>
            // Função para exibir o formulário de atualização
            function showUpdateForm() {
                document.getElementById("updateForm").style.display = "block";
            }
        </script>
    </body>

</body>
</html>