package com.aluracursos.APILiteraturaYPE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ApiLiteraturaYpeApplicationTests {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/libreria_ype"; // Nota: el nombre en minúsculas
		String user = "postgres";
		String password = "021009";

		try (Connection con = DriverManager.getConnection(url, user, password);
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT version()")) {

			if (rs.next()) {
				System.out.println("Conexión exitosa! Versión: " + rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("Error al conectar con la base de datos:");
			e.printStackTrace();
		}
	}
}
