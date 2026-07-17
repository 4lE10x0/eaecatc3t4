package com.crud.act3.controllers;

import com.crud.act3.models.Alumno;
import com.crud.act3.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRestController {

    @Autowired
    private AlumnoService alumnoService;

    // LEER TODOS (GET) - Responde con una lista JSON
    @GetMapping
    public List<Alumno> listarAlumnos() {
        return alumnoService.obtenerTodos();
    }

    // LEER UNO POR ID (GET) - Responde con un objeto JSON
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.obtenerPorId(id);
        return alumno.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREAR (POST) - Espera un JSON en el cuerpo de la petición
    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.guardarAlumno(alumno);
    }

    // ACTUALIZAR (PUT) - Espera un JSON en el cuerpo
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetalles) {
        Optional<Alumno> alumnoExistente = alumnoService.obtenerPorId(id);
        
        if (alumnoExistente.isPresent()) {
            alumnoDetalles.setId(id); // Aseguramos que actualice el registro correcto
            Alumno alumnoActualizado = alumnoService.guardarAlumno(alumnoDetalles);
            return ResponseEntity.ok(alumnoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        Optional<Alumno> alumnoExistente = alumnoService.obtenerPorId(id);
        
        if (alumnoExistente.isPresent()) {
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}