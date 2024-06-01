package br.com.bean;

import br.com.controle.Reserva;
import br.com.entidade.ManterReservas;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ReservarServlet", urlPatterns = {"/ReservarServlet"})
public class ReservarServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ReservarServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar os parâmetros do formulário
        String local = request.getParameter("local");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");

        // Recuperar o ID do usuário da sessão
        HttpSession session = request.getSession();
        int idUsuario = (int) session.getAttribute("id");

        // Criar um objeto de reserva
        Reserva reserva = new Reserva();
        reserva.setId_usuario(idUsuario);
        reserva.setLocal_reserva(local);
        reserva.setData_reserva(data);
        reserva.setHora_reserva(hora);

        // Inserir a reserva no banco de dados
        ManterReservas manterReservas = new ManterReservas();
        try {
            manterReservas.inserir(reserva);
            // Define uma mensagem de sucesso para exibir na página
            request.setAttribute("mensagem", "Reserva realizada com sucesso!");
            logger.log(Level.INFO, "Reserva realizada com sucesso para o usuário ID: {0}", idUsuario);
        } catch (SQLException ex) {
            // Em caso de erro, define uma mensagem de erro para exibir na página
            request.setAttribute("mensagem", "Erro ao realizar reserva: " + ex.getMessage());
            logger.log(Level.SEVERE, "Erro ao realizar reserva para o usuário ID: " + idUsuario, ex);
        } catch (Exception ex) {
            // Em caso de exceção, define uma mensagem de erro para exibir na página
            request.setAttribute("mensagem", "Erro ao realizar reserva: " + ex.getMessage());
            logger.log(Level.SEVERE, "Erro ao realizar reserva para o usuário ID: " + idUsuario, ex);
        }

        // Encaminha a requisição de volta para a página de reserva
        request.getRequestDispatcher("paginaPrincipal.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para realizar uma reserva.";
    }
}