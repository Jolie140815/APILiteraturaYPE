package com.aluracursos.APILiteraturaYPE.service;

import com.aluracursos.APILiteraturaYPE.model.Autor;
import com.aluracursos.APILiteraturaYPE.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarVivosPorAnio(int anio) {
        return autorRepository.findByAnioFallecimientoNullAndAnioNacimientoLessThanEqual(anio);
    }
}
