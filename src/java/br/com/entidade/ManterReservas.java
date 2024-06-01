package br.com.entidade;

import br.com.controle.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManterReservas extends DAO {

    private static final Logger logger = Logger.getLogger(ManterReservas.class.getName());

    public void inserir(Reserva reserva) throws SQLException, Exception {
        PreparedStatement pst = null;
        try {
            abrirBanco();
            logger.log(Level.INFO, "Conexão com o banco de dados estabelecida.");

            String query = "INSERT INTO reservas (id_usuario, local_reserva, data_reserva, hora_reserva) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            logger.log(Level.INFO, "PreparedStatement criado com sucesso.");

            pst.setInt(1, reserva.getId_usuario());
            pst.setString(2, reserva.getLocal_reserva());
            pst.setString(3, reserva.getData_reserva());
            pst.setString(4, reserva.getHora_reserva());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                logger.log(Level.INFO, "Reserva inserida com sucesso! ID do usuário: {0}", reserva.getId_usuario());
            } else {
                logger.log(Level.WARNING, "Nenhuma linha afetada ao inserir a reserva.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao inserir reserva: ", e);
            throw e;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                    logger.log(Level.INFO, "PreparedStatement fechado com sucesso.");
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Erro ao fechar PreparedStatement: ", e);
                }
            }
            fecharBanco();
        }
    }

    public List<Reserva> buscarReservasPorUsuario(int id_usuario) throws SQLException, Exception {
        List<Reserva> reservas = new ArrayList<>();

        try {
            abrirBanco();
            String query = "SELECT id_reserva, id_usuario, local_reserva, data_reserva, hora_reserva FROM reservas WHERE id_usuario = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, id_usuario);
            rs = pst.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId_reserva(rs.getInt("id_reserva"));
                reserva.setId_usuario(rs.getInt("id_usuario"));
                reserva.setLocal_reserva(rs.getString("local_reserva"));
                reserva.setData_reserva(rs.getString("data_reserva"));
                reserva.setHora_reserva(rs.getString("hora_reserva"));
                reservas.add(reserva);
                logger.log(Level.INFO, "Reserva encontrada: {0}", reserva);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar reservas: ", e);
            throw e;
        } finally {
            fecharBanco();
        }

        logger.log(Level.INFO, "Reservas encontradas: {0}", reservas.size());
        return reservas;
    }
}
