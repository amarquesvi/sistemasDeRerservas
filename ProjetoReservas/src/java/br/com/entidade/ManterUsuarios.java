/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Usuario;
import java.sql.PreparedStatement;
import jakarta.resource.cci.ResultSet;


public class ManterUsuarios extends DAO {
    public void inserir (Usuario u) throws Exception {
       
        try { 
       abrirBanco();
    String query = "INSERT INTO usuarios (id,nome,email,celular,senha) "
            + "values(null,?,?,?,?)";
    pst=con.prepareStatement(query);
    pst.setString(1, u.getNome());
    pst.setString(2,u.getEmail());
    pst.setString(3, u.getCelular());
    pst.setString(4, u.getSenha());
    pst.execute();
    System.out.println("Registro inserido com sucesso!");
   
        } catch (Exception e ) {
        System.out.println("Erro ao inserir registro: " + e.getMessage());        
}
         finally {
        fecharBanco();
    }
    }
}

