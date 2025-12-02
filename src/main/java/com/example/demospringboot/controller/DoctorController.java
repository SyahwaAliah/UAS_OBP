package com.example.demospringboot.controller;

import com.example.demospringboot.service.AppointmentService;
import com.example.demospringboot.service.DokterService;
import com.example.demospringboot.service.ObatService;
import com.example.demospringboot.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DokterService dokterService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ObatService obatService;

    @GetMapping
    public String halamanDokter(HttpSession session, Model model) {

        Long dokterId = (Long) session.getAttribute("dokterId");

        if (dokterId == null) {
            return "redirect:/login";
        }

        model.addAttribute("appointmentList", appointmentService.getByDokterId(dokterId));
        model.addAttribute("dataObat", obatService.findAll());
        model.addAttribute("dataDokter", dokterService.findById(dokterId));

       
        return "doctor";
    }
}
