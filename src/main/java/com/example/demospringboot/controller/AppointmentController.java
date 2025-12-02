package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Appointment;
import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.entity.Tiket;
import com.example.demospringboot.repository.AppointmentRepository;
import com.example.demospringboot.repository.DokterRepository;
import com.example.demospringboot.repository.PasienRepository;
import com.example.demospringboot.repository.TiketRepository;
import com.example.demospringboot.service.AppointmentService;
import com.example.demospringboot.service.DokterService;
import com.example.demospringboot.service.ObatService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private DokterRepository dokterRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TiketRepository tiketRepository;

    @Autowired
    private PasienRepository pasienRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ObatService obatService;

    @Autowired
    private DokterService dokterService;

    @GetMapping("/schedule")
    public String showForm(Model model, HttpSession session) {
        Pasien pasien = (Pasien) session.getAttribute("loggedUser");
        if (pasien == null)
            return "redirect:/login";

        model.addAttribute("pasienInfo", pasien);
        model.addAttribute("userInfo", pasien);
        model.addAttribute("dokterList", dokterRepository.findAll());
        return "MenuPasien";
    }

    @PostMapping("/Appointment/Schedule")
    public String schedule(
            @RequestParam Long dokterId,
            @RequestParam String jam,
            HttpSession session) {

        Pasien pasien = (Pasien) session.getAttribute("loggedUser");
        if (pasien == null) {
            return "redirect:/login";
        }

        if (pasien.getTiket() == null) {
            Tiket tiket = new Tiket();
            tiket.setNoTiket((int) (tiketRepository.count() + 1));
            tiketRepository.save(tiket);
            tiket.setPasien(pasien);
            tiketRepository.save(tiket);
            pasien.setTiket(tiket);
            pasienRepository.save(pasien);
        }

        Dokter dokter = dokterRepository.findById(dokterId).orElse(null);
        if (dokter == null) {
            return "redirect:/schedule?error=dokterNotFound";
        }

        List<Appointment> existingList = appointmentRepository.findByPasien_Id(pasien.getId());
        Appointment appointment;

        if (existingList.isEmpty()) {
            appointment = new Appointment();
            appointment.setPasien(pasien);
        } else {
            appointment = existingList.get(0);
        }

        appointment.setDokter(dokter);
        appointment.setJam(jam);
        appointmentRepository.save(appointment);

        return "redirect:/MenuPasien";
    }

    @GetMapping("/dokter/{id}")
    public List<Appointment> getAppointments(@PathVariable Long id) {
        return appointmentService.getByDokterId(id);
    }

    @GetMapping("/appointment")
    public String appointment(Model model) {
        model.addAttribute("appointmentList", appointmentRepository.findAll());
        return "appointment";
    }

    @GetMapping("/MenuPasien")
    public String menuPasien(HttpSession session, Model model) {

        Pasien pasien = (Pasien) session.getAttribute("loggedUser");

        if (pasien == null) {
            return "redirect:/login";
        }

        model.addAttribute("pasienInfo", pasien);

        List<Appointment> allAppointments = appointmentRepository.findAll();

        List<Appointment> appointmentList = allAppointments.stream()
                .filter(a -> a.getPasien() != null
                        && a.getPasien().getId().equals(pasien.getId()))
                .toList();

        model.addAttribute("appointmentList", appointmentList);

        boolean hasAppointment = !appointmentList.isEmpty();
        model.addAttribute("hasAppointment", hasAppointment);

        List<Obat> obatList = obatService.findAll();
        model.addAttribute("ObatList", obatList);

        List<Dokter> dokterList = dokterService.findAll();
        model.addAttribute("DokterList", dokterList);

        return "MenuPasien";
    }

    @PostMapping("/MenuPasien/PilihDokter")
    public String pilihDokter(
            @RequestParam Long dokterId,
            HttpSession session,
            Model model) {

        Pasien pasien = (Pasien) session.getAttribute("loggedUser");
        if (pasien == null) {
            return "redirect:/login";
        }

        Dokter dokter = dokterService.findById(dokterId);
        if (dokter == null) {
            model.addAttribute("notif", "Dokter tidak ditemukan");
            return "MenuPasien";
        }

        session.setAttribute("selectedDokter", dokter);

        return "redirect:/transaksi";
    }
}
