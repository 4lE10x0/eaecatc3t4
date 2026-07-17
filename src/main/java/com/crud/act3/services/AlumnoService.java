package com.crud.act3.services;

import com.crud.act3.models.Alumno;
import com.crud.act3.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    //Crear o Actualizar
    public Alumno guardarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    // Leer todos
    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    // Leer por ID
    public Optional<Alumno> obtenerPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    // Eliminar
    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}
