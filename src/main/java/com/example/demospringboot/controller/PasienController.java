package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.entity.Tiket;
import com.example.demospringboot.entity.User;
import com.example.demospringboot.service.PasienService;
import com.example.demospringboot.service.DokterService;
import com.example.demospringboot.repository.PasienRepository;
import com.example.demospringboot.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PasienController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DokterService dokterService;

    @Autowired
    private PasienRepository pasienRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/pasien")
    public String pasienHome(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/auth?mode=login";
        }

        if (user.getRoleType() == null ||
                !user.getRoleType().trim().equalsIgnoreCase("pasien")) {
            return "redirect:/auth?mode=login";
        }

        Pasien pasien = pasienRepository.findByEmail(user.getEmail()).orElse(null);
        if (pasien == null) {
            return "redirect:/auth?mode=login&error=Data pasien belum terdaftar";
        }

        model.addAttribute("pasienInfo", pasien);
        model.addAttribute("pasien", pasien);
        model.addAttribute("dokterList", dokterService.findAll());
        model.addAttribute("userInfo", user);

        Tiket tiket = pasien.getTiket();
        model.addAttribute("tiket", tiket);

        return "pasien";
    }

    @PostMapping("/pasien/update")
    public String updatePasien(@RequestParam String nama,
                               @RequestParam String tanggalLahir,
                               @RequestParam String umur,
                               @RequestParam String diagnosa,
                               @RequestParam String riwayat,
                               HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/auth?mode=login";
        }

        Pasien pasien = pasienRepository.findByEmail(user.getEmail()).orElse(null);
        if (pasien == null) {
            return "redirect:/auth?mode=login";
        }

        pasien.setNama(nama);
        pasien.setTanggalLahir(tanggalLahir);
        pasien.setUmur(umur);
        pasien.setDiagnosa(diagnosa);
        pasien.setRiwayat(riwayat);

        pasienRepository.save(pasien);

        return "redirect:/pasien";
    }

    @PostMapping("/pasien/register")
    public String registerPasien(@RequestParam String namaPasien) {
        pasienService.createPasienWithTiket(namaPasien);
        return "redirect:/pasien";
    }

    @PostMapping("/pasien/updateUser")
    public String updateUser(@RequestParam String nama,
                             @RequestParam String tanggalLahir,
                             HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/auth?mode=login";
        }

        user.setNama(nama);
        user.setTanggalLahir(tanggalLahir);
        userRepository.save(user);

        return "redirect:/pasien";
    }
}
