package com.example.demospringboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Long id_transaksi;

    @ManyToOne
    @JoinColumn(name = "id_appointment") 
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "id_obat") 
    private Obat obat;

    @Column(name = "total_transaksi")
    private int total_transaksi;

    public Long getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Long id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public int getTotal_transaksi() {
        return total_transaksi;
    }

    public void setTotal_transaksi(int total_transaksi) {
        this.total_transaksi = total_transaksi;
    }
}

