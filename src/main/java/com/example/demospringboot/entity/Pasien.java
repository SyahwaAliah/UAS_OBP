package com.example.demospringboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pasien")
@DiscriminatorValue("pasien")
@PrimaryKeyJoinColumn(name = "id")
public class Pasien extends User {

    private String umur;
    private String diagnosa;
    private String riwayat;

    @OneToOne(mappedBy = "pasien", cascade = CascadeType.ALL)
    private Tiket tiket;

    @OneToMany(mappedBy = "pasien", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();
    // mappedBy utk merujuk nama atribut di entuty lain yg mereferensikan entity ini

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(String riwayat) {
        this.riwayat = riwayat;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}