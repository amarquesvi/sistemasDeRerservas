package br.com.entidade;

import br.com.controle.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManterUsuarios extends DAO {

    private static final Logger logger = Logger.getLogger(ManterUsuarios.class.getName());

    public void inserir(Usuario u) throws Exception {
        try {
            abrirBanco();
            String query = "INSERT INTO usuarios (nome, email, celular, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getCelular());
            pst.setString(4, u.getSenha());
            pst.execute();
            logger.log(Level.INFO, "Registro inserido com sucesso! Email: {0}", u.getEmail());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao inserir registro: ", e);
        } finally {
            if (con != null) {
                con.close();
                logger.log(Level.INFO, "Conexão fechada.");
            }
        }
    }

    public boolean validarSenha(String email, String senha) throws Exception {
        try {
            abrirBanco();
            String query = "SELECT senha FROM usuarios WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String senhaArmazenada = rs.getString("senha");
                if (senha != null && senha.equals(senhaArmazenada)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao executar a consulta: ", e);
        } finally {
            fecharBanco();
        }
        return false;
    }

    public int obterIdUsuario(String email) throws SQLException, Exception {
        int idUsuario = -1;
        try {
            abrirBanco();
            String query = "SELECT id FROM usuarios WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("id");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao obter o ID do usuário: ", e);
            throw e;
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
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("celular"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao obter dados do usuário por ID: ", e);
            throw e;
        } finally {
            fecharBanco();
        }
        return usuario;
    }

    public Usuario obterUsuarioPorEmail(String email) throws SQLException, Exception {
        Usuario usuario = null;
        try {
            abrirBanco();
            String query = "SELECT id, nome, email, celular FROM usuarios WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("celular"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao obter usuário por email: ", e);
            throw e;
        } finally {
            fecharBanco();
        }
        return usuario;
    }
}
