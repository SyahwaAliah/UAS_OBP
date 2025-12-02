package com.example.demospringboot.service;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.repository.UserRepository;
import com.example.demospringboot.repository.PasienRepository;
import com.example.demospringboot.repository.DokterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasienRepository pasienRepository;

    @Autowired
    private DokterRepository dokterRepository;

    public User signIn(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null)
            return null;
        if (!user.getPassword().equals(password))
            return null;
        return user;
    }

    @Transactional
    public User register(String email, String password, String role) {

        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email sudah terdaftar.");
        }

        if (role.equalsIgnoreCase("PASIEN")) {
            Pasien p = new Pasien();
            p.setEmail(email);
            p.setPassword(password);
            return pasienRepository.save(p);
        }

        if (role.equalsIgnoreCase("DOKTER")) {
            Dokter d = new Dokter();
            d.setEmail(email);
            d.setPassword(password);
            return dokterRepository.save(d);
        }

        throw new RuntimeException("Role tidak valid.");
    }

}