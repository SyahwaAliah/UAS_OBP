package com.example.demospringboot.service;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.entity.Tiket;
import com.example.demospringboot.entity.Appointment;
import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.repository.AppointmentRepository;
import com.example.demospringboot.repository.DokterRepository;

import com.example.demospringboot.repository.TiketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private DokterRepository dokterRepository;

    @Autowired
    private TiketRepository tiketRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment schedule(Pasien pasien, Long dokterId, String jam) {

        Tiket t = new Tiket();
        t.setNoTiket((int) (tiketRepository.count() + 1));
        tiketRepository.save(t);

        Dokter d = dokterRepository.findById(dokterId)
                .orElseThrow(() -> new RuntimeException("Dokter tidak ditemukan"));

        Appointment a = new Appointment();
        a.setPasien(pasien);
        a.setDokter(d);
        a.setJam(jam);

        return appointmentRepository.save(a);
    }

    public List<Appointment> getByDokterId(Long dokterId) {
        return appointmentRepository.findByDokterId(dokterId);
    }

}