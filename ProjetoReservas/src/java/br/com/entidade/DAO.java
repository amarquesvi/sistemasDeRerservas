/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vihma
 */
public class DAO {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
public void abrirBanco() throws SQLException {
    try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       String url ="jdbc:mysql://localhost:3306/projeto?zeroDateTimeBehavior=CONVERT_TO_NULL";
       String user = "root";
       String senha = "Senha123";
       
       con=DriverManager.getConnection(url, user,senha);
       System.out.println("Conectado ao banco de dados.");
        
    } catch (ClassNotFoundException ex) {
        System.out.println("Classe não escontrada, adicione o driver nas bibliotecas.");
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null,ex);
    } catch (SQLException e){
        System.out.println(e);  
    }
  }  

public void fecharBanco() {
    try {
        if (pst != null) {
            pst.close();
            System.out.println("PreparedStatement fechado.");
        }
        if (con != null) {
            con.close();
            System.out.println("Conexão fechada.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao fechar a conexão: " + e.getMessage());
    }
}
}
