package com.example.demospringboot.service;

import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.repository.DokterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DokterService {

    @Autowired
    private DokterRepository dokterRepository;

    public Dokter save(Dokter dokter) {
        return dokterRepository.save(dokter);
    }

    public Dokter findById(Long id) {
        return dokterRepository.findById(id).orElse(null);
    }

    public List<Dokter> findAll() {
        return dokterRepository.findAll();
    }

    public void delete(Long id) {
        dokterRepository.deleteById(id);
    }
}
