package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Transaksi;
import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping("/transaksi")
    public String transaksiPage(@RequestParam(name = "id", required = false) Long id,
                                Model model) {

        List<Transaksi> semuaTransaksi = transaksiService.getAllTransaksi();
        model.addAttribute("listTransaksi", semuaTransaksi);

        Transaksi transaksi = null;
        if (id != null) {
            transaksi = transaksiService.getTransaksiById(id).orElse(null);
        } else if (!semuaTransaksi.isEmpty()) {
            transaksi = semuaTransaksi.get(semuaTransaksi.size() - 1);
        }

        model.addAttribute("transaksi", transaksi);

        Obat obat = null;
        if (transaksi != null) {
            obat = transaksiService.getObatByTransaksi(transaksi.getId_transaksi());
        }
        model.addAttribute("obat", obat);

        return "transaksi";
    }

    @PostMapping("/transaksi/check")
    public String checkObat(@RequestParam Long id,
                            @RequestParam String status) {

        if ("sesuai".equalsIgnoreCase(status)) {
            return "redirect:/transaksi/print?id=" + id;
        }

        return "redirect:/MenuPasien";
    }

    @GetMapping("/transaksi/print")
    public String printTransaksi(@RequestParam Long id, Model model) {

        Transaksi transaksi = transaksiService.getTransaksiById(id).orElse(null);
        if (transaksi == null) {
            return "redirect:/transaksi";
        }

        model.addAttribute("transaksi", transaksi);

        Obat obat = transaksiService.getObatByTransaksi(transaksi.getId_transaksi());
        model.addAttribute("obat", obat);

        return "transaksi-print";
    }
}
