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

@WebServlet(name = "PerfilServlet", urlPatterns = {"/MeuPerfilServlet"})
public class MeuPerfilServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtendo o idUsuario da sessão
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("id");
        
        // Criar instância do ManterUsuarios
        ManterUsuarios dao = new ManterUsuarios();

        try {
            // Obter dados do usuário pelo id
            Usuario usuario = dao.obterDadosporId(idUsuario);

            if (usuario != null) {
                // Armazenar o objeto Usuario na sessão
                session.setAttribute("usuario", usuario);
            } else {
                request.setAttribute("mensagem", "Usuário não encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Erro ao obter os dados do usuário: " + e.getMessage());
        }

        // Redirecionar para a página JSP
        request.getRequestDispatcher("paginaMeuPerfil.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "MeuPerfilServlet";
    }
}
