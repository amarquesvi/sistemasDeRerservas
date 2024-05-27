<%-- 
    Document   : paginaLogin
    Created on : 4 de abr. de 2024, 15:53:57
    Author     : vihma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

                    <a>Esqueici minha senha</a>     
                </div>

                <button type="submit" class="submit-button">Entrar</button>
                <p> 
                 
                </p> 

                <div class="register-link">
                    <p>Não está cadastrado?<a href="paginaCadastro.jsp">Cadastrar</a></p>  

                </div>

                <div>    <%-- Verifica se o formulário foi submetido e se há uma mensagem de erro no request --%>
<c:if test="${not empty param.email or not empty param.senha}">
    <c:if test="${not empty requestScope.erroLogin}">
        <div class="erro">${requestScope.erroLogin}</div>
    </c:if>
</c:if>   </div>

        </div>
  
               
        </form>
       
    </body>
</html>

