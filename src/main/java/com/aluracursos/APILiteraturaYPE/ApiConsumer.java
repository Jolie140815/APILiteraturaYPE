package com.aluracursos.APILiteraturaYPE;

import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class ApiConsumer {

    private static final String API_URL = "https://gutendex.com/books/?page=2";

    public static void main(String[] args) {
        // Crear una instancia de RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Realizar la solicitud GET a la API
        String jsonResponse = restTemplate.getForObject(API_URL, String.class);

        try {
            // Crear un ObjectMapper para formatear el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            // Mostrar el JSON formateado en la consola
            String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(prettyJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
