<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
        <title>Página de Login</title>
        <link rel="stylesheet" href="Styles/login.css">
    </head>
    <body>
        <form name="form" action="login.do" method="post">
            <div class="container">
                <h1>Entrar na Plataforma</h1>

                <div class="input-container">
                    <input type="email" name="email" placeholder="Email" required> 
                    <img width="20" height="20" src="https://img.icons8.com/ios-filled/50/FFFFFF/user.png" alt="user"/>
                </div>

                <div class="input-container">
                    <input type="password" name="senha" placeholder="Senha" required>
                    <img width="20" height="20" src="https://img.icons8.com/ios-glyphs/30/FFFFFF/lock--v1.png" alt="lock--v1"/>
                    <a href="paginaRecuperarSenha.jsp">Esqueci minha senha</a>
                </div>

                <button type="submit" class="submit-button">Entrar</button>

                <div class="register-link">
                    <p>Não está cadastrado? <a href="paginaCadastro.jsp">Cadastrar</a></p>  
                </div>

                <c:if test="${not empty erroLogin}">
                    <div class="erro">${erroLogin}</div>
                </c:if>
            </div>
        </form>
    </body>
</html>