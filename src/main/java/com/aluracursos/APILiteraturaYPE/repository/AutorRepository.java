package com.aluracursos.APILiteraturaYPE.repository;

import com.aluracursos.APILiteraturaYPE.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnioFallecimientoNullAndAnioNacimientoLessThanEqual(int anio);
}
