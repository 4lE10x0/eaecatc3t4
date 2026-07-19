package com.crud.act3.controllers;

import com.crud.act3.models.Escuela;
import com.crud.act3.repositories.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class EscuelaController {

    @Autowired
    private EscuelaRepository escuelaRepository;

    @GetMapping
    public String listarEscuelas(Model model) {
        model.addAttribute("escuelas", escuelaRepository.findAll());
        return "escuelas/index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("escuela", new Escuela());
        return "escuelas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Escuela escuela) {
        escuelaRepository.save(escuela);
        return "redirect:/escuelas";
    }
}