package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDokterId(Long dokterId);
    List<Appointment> findByPasien_Id(Long Id);
}
