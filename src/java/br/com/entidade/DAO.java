/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;


import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
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
    Connection con; // criaçao do obj de conexão
    PreparedStatement pst; // criação do obj de preparação do ambiente
    ResultSet rs; // criação do obj que recebe o resultado 
    
    
public void abrirBanco() throws SQLException { // criando método para preparar o ambiente 
    try {
        
       
       Class.forName("com.mysql.cj.jdbc.Driver"); //classe para utilização do arquivo com configurções do serivdor mysql
       String url ="jdbc:mysql://localhost:3306/projeto?useSSL=false&requireSSL=false";
       String user = "root"; //usuario do banco de dados 
       String senha = ""; // minha senha do banco de dados 
       
      
       con=DriverManager.getConnection(url, user,senha);//metodo que usa os parametros para conectar com o banco
       System.out.println("Conectado ao banco de dados.");
        
    } catch (ClassNotFoundException ex) { //tratamento de erro de drive
        System.out.println("Classe não escontrada, adicione o driver nas bibliotecas.");
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null,ex);
    } catch (SQLException e){ //tratamento de erro de SQL
        System.out.println(e);  
    }
  }  

public void fecharBanco() throws Exception{//criando metodo que fechao conexão com o banco
       if (pst!= null) { //limpando os dados de conexão   
            pst.close();//fechando o ambiente de conexão
            System.out.println("Execuçao da Query fechada\n");
    }   con.close();
                LOGGER.info("Conexão com o banco de dados fechada.");
            } }
  



