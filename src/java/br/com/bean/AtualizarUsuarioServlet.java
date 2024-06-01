/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.bean;

import br.com.controle.Usuario;
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
public class AtualizarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtualizarUsuarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AtualizarUsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obter os novos dados do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");

        // Obter o usuário da sessão
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getId();

        // Atualizar os dados no banco de dados
        ManterUsuarios dao = new ManterUsuarios();
        try {
            dao.atualizarUsuario(idUsuario, nome, email, celular);

            // Atualizar os dados do usuário na sessão
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setCelular(celular);
            session.setAttribute("usuario", usuario);

            // Redirecionar de volta para a página do perfil
            response.sendRedirect("paginaMeuPerfil.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Lidar com erros de atualização (redirecionar para uma página de erro, mostrar mensagem de erro, etc.)
            request.setAttribute("mensagem", "Erro ao atualizar os dados do usuário: " + e.getMessage());
            request.getRequestDispatcher("paginaMeuPerfil.jsp").forward(request, response);
        }

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
