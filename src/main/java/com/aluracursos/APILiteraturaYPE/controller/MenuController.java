package com.aluracursos.APILiteraturaYPE.controller;

import com.aluracursos.APILiteraturaYPE.model.Libro;
import com.aluracursos.APILiteraturaYPE.service.LibroService;
import com.aluracursos.APILiteraturaYPE.service.AutorService;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class MenuController {
    private final LibroService libroService;
    private final AutorService autorService;

    public MenuController(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("""
                    Elija la opción a través de su número:
                    1- Buscar libro por título
                    2- Listar libros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos en un determinado año
                    5- Listar libros por idioma
                    0- Salir""");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> buscarLibro(scanner);
                case 2 -> listarLibros();
                case 3 -> listarAutores();
                case 4 -> listarAutoresVivos(scanner);
                case 5 -> listarLibrosPorIdioma(scanner);
                case 0 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void buscarLibro(Scanner scanner) {
        System.out.println("Ingrese el libro que desea buscar:");
        String titulo = scanner.nextLine();
        Libro libro = libroService.buscarPorTitulo(titulo);
        if (libro != null) {
            System.out.printf("""
                    LIBRO
                    Titulo: %s
                    Autor: %s
                    Idioma: %s
                    Numero de descargas: %d%n""", libro.getTitulo(), libro.getAutor().getNombre(), libro.getIdioma(), libro.getNumeroDescargas());
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void listarLibros() {
        libroService.listarLibros().forEach(libro ->
                System.out.printf("Titulo: %s, Autor: %s%n", libro.getTitulo(), libro.getAutor().getNombre()));
    }

    private void listarAutores() {
        autorService.listarAutores().forEach(autor ->
                System.out.printf("Autor: %s, Fecha de nacimiento: %d, Fecha de fallecimiento: %d%n", autor.getNombre(), autor.getAnioNacimiento(), autor.getAnioFallecimiento()));
    }

    private void listarAutoresVivos(Scanner scanner) {
        System.out.println("Ingrese el año del autor que desea mostrar:");
        int anio = scanner.nextInt();
        autorService.listarVivosPorAnio(anio).forEach(autor ->
                System.out.printf("Autor: %s, Fecha de nacimiento: %d%n", autor.getNombre(), autor.getAnioNacimiento()));
    }

    private void listarLibrosPorIdioma(Scanner scanner) {
        System.out.println("Ingrese el idioma para buscar el libro (es, en, fr, pt):");
        String idioma = scanner.nextLine();
        libroService.listarPorIdioma(idioma).forEach(libro ->
                System.out.printf("Titulo: %s, Autor: %s, Idioma: %s, Numero de descargas: %d%n", libro.getTitulo(), libro.getAutor().getNombre(), libro.getIdioma(), libro.getNumeroDescargas()));
    }
}