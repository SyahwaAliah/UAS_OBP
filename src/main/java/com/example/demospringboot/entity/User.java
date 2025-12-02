package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role_type")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String nama;
    private String tanggalLahir;
    private String kontak;
    private String notifikasi;

    @Column(name="role_type", insertable = false, updatable = false)
    private String roleType;

    public User() {}
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getNotifikasi() {
        return notifikasi;
    }

    public void setNotifikasi(String notifikasi) {
        this.notifikasi = notifikasi;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    
    public String getRoleType() {
        return roleType;
    }
}