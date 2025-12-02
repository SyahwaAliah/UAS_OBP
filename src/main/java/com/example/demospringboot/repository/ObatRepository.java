package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Obat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatRepository extends JpaRepository<Obat, Integer> {
}