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


/**
 *
 * @author vihma
 */
public class CadastrosServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
          // criei as variáveis p receber os dados do formulário
           String pnome= request.getParameter("nome");
           String pemail= request.getParameter("email");
           String pcelular= request.getParameter("number");
           String psenha= request.getParameter("password");
           
           // criei um obj 
           Usuario u = new Usuario();
           
           u.setNome(pnome);
           u.setEmail(pemail);
           u.setCelular(pcelular);
           u.setSenha(psenha);
            
           //criando obj pois ele que possui o inserir 
           ManterUsuarios mu = new ManterUsuarios();
          
           mu.inserir(u);
           
           request.setAttribute("ok", u.getNome());
           RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("sucesso.jsp");
           rd.forward(request, response);
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastrosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
