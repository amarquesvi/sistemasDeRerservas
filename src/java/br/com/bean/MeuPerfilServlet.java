/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.bean;

import br.com.controle.Usuario;
import br.com.entidade.ManterUsuarios;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author vihma
 */
public class MeuPerfilServlet extends HttpServlet {

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
            out.println("<title>Servlet MeuPerfilServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MeuPerfilServlet at " + request.getContextPath() + "</h1>");
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
    
    
     private static final Logger LOGGER = Logger.getLogger(MeuPerfilServlet.class.getName());
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("id");

        LOGGER.log(Level.INFO, "ID do usuário da sessão: {0}", idUsuario);

        if (idUsuario != null && idUsuario > 0) {
            try {
                ManterUsuarios manterUsuarios = new ManterUsuarios();
                Usuario usuario = manterUsuarios.obterDadosporId(idUsuario);

                if (usuario != null) {
                    LOGGER.log(Level.INFO, "Usuário encontrado: {0}", usuario);
                    request.setAttribute("usuario", usuario);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("paginaMeuPerfil.jsp");
                    dispatcher.forward(request, response);
                } else {
                    LOGGER.log(Level.WARNING, "Usuário com ID {0} não encontrado.", idUsuario);
                    response.sendRedirect("paginaLogin.jsp?erro=3");
                }
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Erro ao obter o usuário: {0}", ex.getMessage());
                ex.printStackTrace();
                response.sendRedirect("paginaLogin.jsp?erro=4");
            }
        } else {
            LOGGER.log(Level.WARNING, "ID do usuário não encontrado na sessão.");
            response.sendRedirect("paginaLogin.jsp?erro=5");
        }
        
        
        
        
        
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que exibe os dados do perfil do usuário logado";
    }// </editor-fold>

}
