package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Pasien;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PasienRepository extends JpaRepository<Pasien, Long> {
        Optional<Pasien> findByEmail(String email);
        Pasien findById(Integer id);

        // @Query("SELECT COALESCE(MAX(p.tiket.noTiket), 0) FROM Pasien p")
        // int findLastNoTiket();
        // @query itu untuk mendefinisikan JPQL query manual
        // MAX(p.tiket.noTiket) untuk ambil nomor tiket terakhir
        // coalesce(...,0) kalau belum ada pasien hasilnya 00
}