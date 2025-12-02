package com.example.demospringboot.service;

import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObatService {

    @Autowired
    private ObatRepository obatRepository;

    public List<Obat> findAll() {
        return obatRepository.findAll();
    }

    public Obat findById(Integer id) {
        return obatRepository.findById(id).orElse(null);
    }

    public Obat save(Obat obat) {
        return obatRepository.save(obat);
    }

    public void delete(Integer id) {
        obatRepository.deleteById(id);
    }

}