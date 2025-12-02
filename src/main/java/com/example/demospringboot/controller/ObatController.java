package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.entity.Appointment;
import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.entity.Transaksi;
import com.example.demospringboot.repository.PasienRepository;
import com.example.demospringboot.repository.UserRepository;
import com.example.demospringboot.service.PasienService;
import com.example.demospringboot.service.ObatService;
import com.example.demospringboot.service.TransaksiService;
import com.example.demospringboot.service.AppointmentService;
import com.example.demospringboot.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class ObatController {

    @Autowired
    private ObatService obatService;

    @Autowired
    private PasienService pasienService;

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private PasienRepository pasienRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/obat")
    public String menuObat(Model model) {

        List<Obat> listObat = obatService.findAll();
        List<Pasien> listPasien = pasienService.getAllPasien();

        model.addAttribute("listPasien", listPasien);
        model.addAttribute("listObat", listObat);

        return "obat";
    }

    @PostMapping("/transaksi/save")
    public String simpanTransaksi(
            @RequestParam("id_pasien") Long idPasien,
            @RequestParam("id_obat") Integer idObat
    ) {

        Pasien pasien = pasienRepository.findById(idPasien).orElse(null);
        if (pasien == null) {
            return "redirect:/obat?error=pasienNotFound";
        }

        Obat obat = obatService.findById(idObat);
        if (obat == null) {
            return "redirect:/obat?error=obatNotFound";
        }

        List<Appointment> apptList = appointmentRepository.findByPasien_Id(idPasien);
        Appointment appointment = null;

        if (!apptList.isEmpty()) {
            appointment = apptList.get(apptList.size() - 1);
        }

        Transaksi transaksi = new Transaksi();
        transaksi.setAppointment(appointment);
        transaksi.setObat(obat);
        transaksi.setTotal_transaksi(obat.getHargaObat().intValue());

        transaksiService.saveTransaksi(transaksi);

        return "redirect:/doctor";
    }
}
