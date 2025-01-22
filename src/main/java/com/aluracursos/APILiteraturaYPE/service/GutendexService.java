package com.aluracursos.APILiteraturaYPE.service;

import com.aluracursos.APILiteraturaYPE.model.Libro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books/";

    public List<Libro> obtenerLibrosDeAPI() {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("page", 2)
                .toUriString();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return parsearLibros(response);
    }

    private List<Libro> parsearLibros(Map<String, Object> response) {
        // Lógica para convertir el JSON de respuesta a una lista de libros
        // Puedes usar ObjectMapper si lo prefieres
        return List.of(); // Reemplazar con la lista real de libros
    }
}

