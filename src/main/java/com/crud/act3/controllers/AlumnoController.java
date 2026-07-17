package com.crud.act3.controllers;

import com.crud.act3.models.Alumno;
import com.crud.act3.services.AlumnoService;
import com.crud.act3.repositories.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private EscuelaRepository escuelaRepository;

    // Muestra la vista index.html con la lista de alumnos
    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoService.obtenerTodos());
        return "alumnos/index";
    }

    // Muestra el formulario vacío para crear
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrear(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("escuelas", escuelaRepository.findAll());
        return "alumnos/form";
    }

    // Muestra el formulario con los datos de un alumno existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        Alumno alumno = alumnoService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de alumno inválido:" + id));
        model.addAttribute("alumno", alumno);
        model.addAttribute("escuelas", escuelaRepository.findAll());
        return "alumnos/form";
    }

    // Recibe los datos del formulario y los guarda
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.guardarAlumno(alumno);
        return "redirect:/alumnos"; // Redirige a la lista
    }

    // Elimina un registro y redirige
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return "redirect:/alumnos";
    }
}