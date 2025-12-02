package com.example.demospringboot.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "dokter")
@DiscriminatorValue("dokter")
@PrimaryKeyJoinColumn(name = "id")
public class Dokter extends User {

    private String spesialis;
    private String kontakDokter;

    public String getSpesialis() {
        return spesialis;
    }

    @OneToMany(mappedBy = "dokter", cascade = CascadeType.ALL)
    private List<Appointment> appointment;

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getKontakDokter() {
        return kontakDokter;
    }

    public void setKontakDokter(String kontakDokter) {
        this.kontakDokter = kontakDokter;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }
}