package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pasien")
    private Pasien pasien;

    private String jam;

    @ManyToOne
    @JoinColumn(name = "id_dokter")
    private Dokter dokter;

    public Appointment() {
    }

    public Appointment(Pasien pasien, Dokter dokter, String jam) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.jam = jam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", id_pasien=" + (pasien != null ? pasien.getId() : null) +
                ", idDokter=" + (dokter != null ? dokter.getId() : null) +
                ", jam='" + jam + '\'' +
                '}';
    }
}