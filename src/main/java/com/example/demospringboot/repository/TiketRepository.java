package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Tiket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiketRepository extends JpaRepository<Tiket, Long> {
}