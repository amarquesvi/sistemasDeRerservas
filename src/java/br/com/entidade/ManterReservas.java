/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;
import br.com.controle.Reserva;
import com.sun.istack.logging.Logger;
import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author vihma
 */
public class ManterReservas extends DAO  {
    
    
public void inserir(Reserva reserva) throws SQLException, Exception {
    
    
    try {
        abrirBanco(); // Abre a conexão com o banco de dados
        
        String query = "INSERT INTO reservas (id_usuario, local_reserva, data_reserva, hora_reserva) VALUES (?, ?, ?, ?)";
        pst = con.prepareStatement(query);
        pst.setInt(1, reserva.getId_usuario()); // Define o ID do usuário na reserva
        pst.setString(2, reserva.getLocal_reserva());
        pst.setDate(3, reserva.getData_reserva());
        pst.setTime(4, reserva.getHora_reserva());

        pst.executeUpdate();
        
        System.out.println("Reserva inserida com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro ao inserir reserva: " + e.getMessage());
        throw e; // Lança a exceção para que seja tratada no nível superior
    } finally {
        // Fecha o PreparedStatement apenas se não for nulo
        if (pst != null) {
            pst.close();
        }
        fecharBanco(); // Fecha a conexão com o banco de dados
    }
}


 

 public List<Reserva> buscarReservasPorUsuario(int id_usuario) throws SQLException, Exception {
        List<Reserva> reservas = new ArrayList<>();
         LOGGER.info("Buscando reservas para o usuário com ID: " + id_usuario);

    try {
        abrirBanco();
        String query = "SELECT id_reserva, id_usuario, local_reserva, data_reserva, hora_reserva * FROM reservas WHERE id_usuario = ?";
        pst = con.prepareStatement(query);
        pst.setInt(1, id_usuario);
        rs = pst.executeQuery();

        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setId_reserva(rs.getInt("id_reserva"));
            reserva.setId_usuario(rs.getInt("id_usuario"));
            reserva.setLocal_reserva(rs.getString("local_reserva"));
            reserva.setData_reserva(rs.getDate("data_reserva"));
            reserva.setHora_reserva(rs.getTime("hora_reserva"));
            reservas.add(reserva);
            System.out.println("Reserva encontrada: " + reserva);  // Log detalhado de cada reserva
        }

    } catch (SQLException e) {
        LOGGER.severe("Erro ao buscar reservas: " + e.getMessage());
        throw e;
    } finally {
        fecharBanco();
    }

    LOGGER.info("Reservas encontradas: " + reservas.size());
    return reservas;
} 
}
