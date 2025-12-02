package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Login;
import com.example.demospringboot.entity.User;

import com.example.demospringboot.service.UserService;
import com.example.demospringboot.service.AppointmentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping({"/auth", "/login", "/regist"})
    public String pageAuth(
            @RequestParam(required = false, defaultValue = "login") String mode,
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String success,
            Model model) {

        if (mode.equals("signup")) {
            model.addAttribute("formSignup", new Login());
        } else {
            model.addAttribute("formLogin", new Login());
        }

        model.addAttribute("mode", mode);
        model.addAttribute("error", error);
        model.addAttribute("success", success);

        return "index";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute("formLogin") Login login, HttpSession session) {
        User user = userService.signIn(login.getEmail(), login.getPassword());
    
        if (user == null) {
            return "redirect:/auth?mode=login&error=Email atau password salah";
        }
    
        session.setAttribute("userId", user.getId());
        session.setAttribute("role", user.getRoleType());
        session.setAttribute("userEmail", user.getEmail()); // <--- simpan email
        
        session.setAttribute("loggedUser", user);

        if (user.getRoleType() != null && user.getRoleType().trim().equalsIgnoreCase("dokter")) {
    session.setAttribute("dokterId", user.getId());
    return "redirect:/doctor";
}

    
        return "redirect:/pasien";
    }
    
@PostMapping("/signup")
public String signup(
        @ModelAttribute("formSignup") Login signup,
        @RequestParam(required = false, defaultValue = "PASIEN") String role) {

    userService.register(
            signup.getEmail(),
            signup.getPassword(),
            role.toUpperCase()
    );

    return "redirect:/auth?mode=login&success=Akun berhasil dibuat!";
}

@GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate(); 
    return "redirect:/Menu";
}

}
