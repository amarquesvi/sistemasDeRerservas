package br.com.bean;

import br.com.entidade.ManterUsuarios;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet responsável pelo login dos usuários.
 */
public class LoginServlet extends HttpServlet {

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

            if (senhaValida) {
                // Usuário válido, obter o ID do usuário e configurá-lo na sessão
                int idUsuario = mU.obterIdUsuario(email);
                HttpSession session = request.getSession();
                session.setAttribute("id", idUsuario);

                // Redireciona para a página principal
                response.sendRedirect("paginaPrincipal.jsp");
            } else {
                // Senha inválida, redireciona de volta para a página de login com uma mensagem de erro
                request.setAttribute("erroLogin", "E-mail ou senha inválidos");
                request.getRequestDispatcher("paginaLogin.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            // Em caso de exceção, redireciona com uma mensagem de erro
            request.setAttribute("erroLogin", "Erro ao validar o login: " + ex.getMessage());
            request.getRequestDispatcher("paginaLogin.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet responsável pelo login dos usuários.";
    }
}