package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Dokter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokterRepository extends JpaRepository<Dokter, Long> {

}