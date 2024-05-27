/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.bean;

import br.com.controle.Usuario;
import br.com.entidade.DAO;
import br.com.entidade.ManterUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 *
 * @author vihma
 */
public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
             processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      

     // Obtendo parâmetros de email e senha do formulário de login
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");

    // Criando um objeto ManterUsuarios para acessar o método validarSenha
    ManterUsuarios mU = new ManterUsuarios();

    try {
        // Verificando se a senha é válida no banco de dados
        boolean senhaValida = mU.validarSenha(email, senha);

        // Redirecionando com base no resultado da validação
        if (senhaValida) {
            
             // Usuário válido, obter o ID do usuário e configurá-lo na sessão
            int idUsuario = mU.obterIdUsuario(email); 
            HttpSession session = request.getSession();
            session.setAttribute("id", idUsuario);

            // Usuário válido, redireciona para a página principal
            response.sendRedirect("paginaPrincipal.jsp");
            return;
        } else {
            // Senha inválida, redireciona de volta para a página de login com uma mensagem de erro
            request.setAttribute("erroLogin", "E-mail ou senha inválidos");
            request.getRequestDispatcher("paginaLogin.jsp").forward(request, response);
            return;
        }
    } catch (Exception ex) {
        // Em caso de exceção, redireciona com uma mensagem de erro
        request.setAttribute("erroLogin", "Erro ao validar o login: " + ex.getMessage());
        request.getRequestDispatcher("paginaLogin.jsp").forward(request, response);
        
    }
}
         
    

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
