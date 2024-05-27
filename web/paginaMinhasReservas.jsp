<%-- 
    Document   : paginaMinhasReservas
    Created on : 4 de mai. de 2024, 17:19:37
    Author     : vihma
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.controle.Reserva"%>
<%@page import="br.com.controle.Usuario"%>
<%@page import="br.com.entidade.ManterUsuarios"%>
<%@page import="br.com.entidade.ManterReservas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
      <div class="row">
    <div class="col-md-offset-2 col-md-8">
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th colspan="6" class="h2 text-center">Lista de Usuários</th>
                    </tr>
                </thead>
                <br/>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Celular</th>
                    <th colspan="2">Ações</th>
                </tr>
                <%
                    String pcodigo = "";
                    String pnome = "";
                    String pemail = "";
                    String pcelular = "";
                    UsuarioDAO dao = new UsuarioDAO(); 
                    Usuario usuario = new Usuario();
                    int idUsuarioLogado = (int) session.getAttribute("idUsuarioLogado"); // Supondo que o ID do usuário logado está na sessão
                    ArrayList<Usuario> listaUsuario = dao.obterDadosUsuario(idUsuarioLogado); // Recebendo a lista gerada no DAO e colocando na lista que será impressa na tela
                    for (int i = 0; i < listaUsuario.size(); i++) {                
                        usuario = listaUsuario.get(i);
                        pcodigo = String.valueOf(usuario.getId());
                        pnome = usuario.getNome();
                        pemail = usuario.getEmail();
                        pcelular = usuario.getCelular();
                %>
                <tr>
                    <td class="text-center"><%=pcodigo%></td>
                    <td class="text-center"><%=pnome%></td> 
                    <td class="text-center"><%=pemail%></td> 
                    <td class="text-center"><%=pcelular%></td>
                    <td class="text-center">
                        <a href="alterar?id=<%=pcodigo%>" data-toggle="tooltip" title="Alterar">
                            <span class="glyphicon glyphicon-pencil text-primary"> </span> </a>
                        <a href="excluir?id=<%=pcodigo%>" onclick="return confirm('Confirma exclusão do registro <%=vnome%>?')" data-toggle="tooltip" title="Excluir">
                            <span class="glyphicon glyphicon-trash text-danger"> </span> </a>
                    </td>
                </tr>
                <% } // Fechando FOR %>
            </table>
        </div>
    </div>
    </body>
 
   
</html>
