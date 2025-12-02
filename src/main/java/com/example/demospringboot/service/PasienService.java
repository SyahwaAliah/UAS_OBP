package com.example.demospringboot.service;


import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.entity.Tiket;
import com.example.demospringboot.repository.PasienRepository;
import com.example.demospringboot.repository.TiketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PasienService {

    @Autowired
    private PasienRepository pasienRepository;

    @Autowired
    private TiketRepository tiketRepository;

    public Pasien createPasienWithTiket(String namaPasien) {
        Tiket tiket = new Tiket();
        tiket.setNoTiket((int)(tiketRepository.count() + 1));
        tiketRepository.save(tiket);

        Pasien pasien = new Pasien();
        pasien.setNama(namaPasien);
        pasien.setTiket(tiket);

        return pasienRepository.save(pasien);
    }

    public List<Pasien> getAllPasien() {
        return pasienRepository.findAll();
    }

    

}