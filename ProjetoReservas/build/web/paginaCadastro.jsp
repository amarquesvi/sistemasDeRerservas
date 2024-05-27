<%-- 
    Document   : paginaCadastro
    Created on : 4 de abr. de 2024, 15:54:37
    Author     : vihma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Cadastro</title>
        <link rel="stylesheet" href="Styles/cadastro.css" />

    </head>
    <form name="form" action="/ProjetoReservas/cadastro.do" method="post">
        
        
        <div class="container">
            <div class="title">
                <h1>Cadastre-se</h1> 
            </div>
            <div class="input-group">
                <div class="input-container">
                    <label for="name">Nome</label>
                    <input id="name" type="text" name="name" placeholder="Digite seu nome" required>
                </div>
                <div class="input-container">
                    <label for="email">E-mail</label>
                    <input id="email" type="email" name="email" placeholder="Digite seu e-mail" required>
                </div>
                <div class="input-container">
                    <label for="number">Celular</label>
                    <input id="number" type="tel" name="number" placeholder="(xx) xxxx-xxxx" required>
                </div>
                <div class="input-container">
                    <label for="password">Senha</label>
                    <input id="password" type="password" name="password" placeholder="Digite sua senha" required>
                </div>
                <div class="continue-button">
                    <button type="submit">Cadastrar</button>
                </div>
            </div>
        </div>
   </form>
</body>
</html>

        
        
        
        
        
        
    