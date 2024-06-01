package br.com.bean;

import br.com.controle.Usuario;
import br.com.controle.Reserva;
import br.com.entidade.ManterReservas;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MinhasReservasServlet", urlPatterns = {"/MinhasReservasServlet"})
public class MinhasReservasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao processar a solicitação", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao processar a solicitação", e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        // Obtém o usuário logado da sessão
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        if (usuario == null) {
            // Se não houver usuário logado, redireciona para a página de login ou exibe uma mensagem de erro
            response.sendRedirect("index.jsp");
            return;
        }

        // Cria uma instância da classe ManterReservas
        ManterReservas manterReservas = new ManterReservas();

        // Obtém as reservas do usuário
        List<Reserva> listaReservas = manterReservas.buscarReservasPorUsuario(usuario.getId());

        // Adiciona a lista de reservas ao request
        request.setAttribute("listaReservas", listaReservas);

        // Encaminha a solicitação para a página JSP
        request.getRequestDispatcher("paginaMinhasReservas.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet que exibe as reservas do usuário logado";
    }
}