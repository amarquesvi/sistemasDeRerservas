package br.com.bean;

import br.com.controle.Usuario;
import br.com.entidade.ManterUsuarios;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

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
                // Usuário válido, obter o objeto Usuario e configurá-lo na sessão
                Usuario usuario = mU.obterUsuarioPorEmail(email);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("id", usuario.getId()); // Adiciona o ID do usuário na sessão
                logger.log(Level.INFO, "Usuário {0} logado com sucesso. ID: {1}", new Object[]{email, usuario.getId()});

                // Redireciona para a página principal
                response.sendRedirect("paginaPrincipal.jsp");
            } else {
                // Senha inválida, redireciona de volta para a página de login com uma mensagem de erro
                request.setAttribute("erroLogin", "E-mail ou senha inválidos");
                request.getRequestDispatcher("paginaLogin.jsp").forward(request, response);
                logger.log(Level.WARNING, "Tentativa de login inválida para o e-mail: {0}", email);
            }
        } catch (Exception ex) {
            // Em caso de exceção, redireciona com uma mensagem de erro
            request.setAttribute("erroLogin", "Erro ao validar o login: " + ex.getMessage());
            request.getRequestDispatcher("paginaLogin.jsp").forward(request, response);
            logger.log(Level.SEVERE, "Erro ao validar o login para o e-mail: " + email, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet responsável pelo login dos usuários.";
    }
}
