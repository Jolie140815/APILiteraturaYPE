package com.aluracursos.APILiteraturaYPE.repository;

import com.aluracursos.APILiteraturaYPE.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);
    Libro findByTitulo(String titulo);
}
