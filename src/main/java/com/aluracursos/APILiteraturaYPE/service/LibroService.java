package com.aluracursos.APILiteraturaYPE.service;

import com.aluracursos.APILiteraturaYPE.model.Libro;
import com.aluracursos.APILiteraturaYPE.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro buscarPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> listarPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public void guardarLibro(Libro libro) {
        if (libroRepository.findByTitulo(libro.getTitulo()) != null) {
            throw new IllegalArgumentException("No se puede registrar el mismo libro más de una vez");
        }
        libroRepository.save(libro);
    }
}