/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Usuario;
import jakarta.resource.cci.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterUsuarios extends DAO {
    
    
public void inserir(Usuario u) throws Exception {         
        try {
            // Abrindo a conexão com o banco de dados e atribuindo à variável con
            abrirBanco();
            
            String query = "INSERT INTO usuarios (nome, email, celular, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getCelular());
            pst.setString(4, u.getSenha());
           
           
            pst.execute();
            System.out.println("Registro inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        } finally {
            // Fechando a conexão com o banco de dados
            if (con != null) {
                con.close();
                System.out.println("Conexão fechada.");
            }
        }
    }
    
 public boolean validarSenha(String email, String senha) throws Exception {
    try {
        abrirBanco();
        String query = "SELECT senha FROM usuarios WHERE email = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, email);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            String senhaArmazenada = rs.getString("senha");
            // Verifica se a senha fornecida não é nula e corresponde à senha armazenada no banco de dados
            if (senha != null && senha.equals(senhaArmazenada)) {
                return true; // Senha válida
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao executar a consulta: " + e.getMessage());
    } finally {
        fecharBanco();
    }
    
    return false; // Senha inválida
}

   
    

public int obterIdUsuario(String email) throws SQLException, Exception {
    int idUsuario = -1; // Valor padrão para indicar que o ID não foi encontrado

    try {
        abrirBanco();
        String query = "SELECT id FROM usuarios WHERE email = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, email);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            idUsuario = rs.getInt("id");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao obter o ID do usuário: " + e.getMessage());
        throw e; // Lançar a exceção para tratamento superior
    } finally {
        fecharBanco();
    }

    return idUsuario;
}

public Usuario obterDadosporId(int id) throws SQLException, Exception {
        Usuario usuario = null;
        try {
            abrirBanco();
            String query = "SELECT id, nome, email, celular FROM usuarios WHERE id = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("celular"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            fecharBanco();
        }
        return usuario;
    }

}