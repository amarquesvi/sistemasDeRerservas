/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controle;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author vihma
 */
public class Reserva {
   
    private int id_reserva;
    private int id_usuario; // Referência ao usuário que fez a reserva
    private String local_reserva;
    private Date data_reserva;
    private Time hora_reserva;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLocal_reserva() {
        return local_reserva;
    }

    public void setLocal_reserva(String local_reserva) {
        this.local_reserva = local_reserva;
    }

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Time getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(Time hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

   
}