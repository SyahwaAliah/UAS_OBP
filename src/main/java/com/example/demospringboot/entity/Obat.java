package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "obat")
public class Obat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_obat")
    private Integer idObat;

    @Column(name = "nama_obat")
    private String namaObat;

    @Column(name = "pemakaian_obat")
    private String pemakaianObat;

    @Column(name = "harga_obat")
    private Float hargaObat;

    public Obat() {}

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getPemakaianObat() {
        return pemakaianObat;
    }

    public void setPemakaianObat(String pemakaianObat) {
        this.pemakaianObat = pemakaianObat;
    }

    public Float getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(Float hargaObat) {
        this.hargaObat = hargaObat;
    }

}