package com.example.demospringboot.service;

import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.entity.Transaksi;
import com.example.demospringboot.repository.TransaksiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {

    private final TransaksiRepository transaksiRepository;

    public TransaksiService(TransaksiRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    public Optional<Transaksi> getTransaksiById(Long id) {
        return transaksiRepository.findById(id);
    }


    public List<Transaksi> getAllTransaksi() {
        return transaksiRepository.findAll();
    }

    public Obat getObatByTransaksi(Long transaksiId) {
        return transaksiRepository.findById(transaksiId)
                .map(Transaksi::getObat)
                .orElse(null);
    }

    public void deleteTransaksi(Long id) {
        transaksiRepository.deleteById(id);
    }

    public Transaksi saveTransaksi(Transaksi transaksi) {
        return transaksiRepository.save(transaksi);
    }
}
