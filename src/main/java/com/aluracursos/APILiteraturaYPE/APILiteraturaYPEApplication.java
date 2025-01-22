package com.aluracursos.APILiteraturaYPE;

import com.aluracursos.APILiteraturaYPE.controller.MenuController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class APILiteraturaYPEApplication implements CommandLineRunner {
	private final MenuController menuController;

	public APILiteraturaYPEApplication(MenuController menuController) {
		this.menuController = menuController;
	}

	public static void main(String[] args) {
		SpringApplication.run(APILiteraturaYPEApplication.class, args);
	}

	@Override
	public void run(String... args) {
		menuController.mostrarMenu();
	}
}
