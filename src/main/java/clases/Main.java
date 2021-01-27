/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Libro> catalogo = new ArrayList<Libro>();
		
		while (true) {
		int opcion = menu();
		switch (opcion) {
		case 1:
			alta(catalogo);
			//TODO Alta de Libros
			//titulo:isbn:genero:autor:paginas
			//Alta(catalogo);
			break;
		case 2:
			//TODO Lista de libros
			break;
		default:
			break;
			}
		}
	}

	private static int menu() {
		int opcion = 0;

		do {
			System.out.println("Opciones: ");
			System.out.println("1. Alta de libro");
			System.out.println("2. Lista de Libros");
			System.out.println("Introduce la opci�n:");
			opcion = leerOpcion(2);

		} while (opcion <= 0);

		return opcion;
	}

	private static int leerOpcion(int max) {
		int opcion = -1;
		Scanner teclado = new Scanner(System.in);
		try {
			opcion = teclado.nextInt();
			if (opcion > max)
				opcion = -1;
		} catch (InputMismatchException e) {
			System.out.println("Esta opci�n es incorrecta");
		}
		// teclado.close();
		return opcion;
	}
	
	
	private static void alta (ArrayList<Libro> catalogo) {
		//Leer de esta entrada
		System.out.println("Introduce los formatos de un libro");
		System.out.println("Usa el formato \"titulo:genero:autor:paginas\" ");
		//Procesar la entrada
		//Crear el libro con datos de la entrada
		//Meter el libro en el cat�logo
		}
	private static String leerCadenas() {
		String opcionPalabras = null;
		Scanner teclado = new Scanner(System.in);
		try {
			opcionPalabras = teclado.next();
		} catch (InputMismatchException e) {
			System.out.println("Esta opci�n es incorrecta");
		}
		// teclado.close();
		return opcionPalabras;
	}
}