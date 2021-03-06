/**

 * Clase MAIN con MEN� interactivo -- y capaz de guardar/cargar ficheros de un "catalogo" al cliente

 * @author: JD Hernandez Farricius
 * @version: 12/03/2021
 */
package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * Funcionamiento principal del programa desde men� switch, el cliente puede
	 * introducir en X metodos Auto crea ya un catalogo arraylist
	 */
	public static void main(String[] args) {

		ArrayList<Libro> catalogo = new ArrayList<Libro>(10); // Crea el cat�logo como lista

		// MEN� DE OPCIONES.

		while (true) {
			int opcion = menu();
			switch (opcion) {
			case 1:
				alta(catalogo);
				break;

			case 2:
				listadoLibros(catalogo);
				break;

			case 3:
				bajaLibros(catalogo);
				break;

			case 4:
				busquedaLibros(catalogo);
				break;

			case 5:
				ordenacion(catalogo);
				break;

			case 6:
				try {
					guardarFichero(catalogo);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 7:
				cargarFichero(catalogo);
				break;

			case 8:
				deleteCatalogo(catalogo);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * @return opcion personalizada que escriba el usuario
	 */
	private static int menu() {
		int opcion = 0;

		do {
			System.out.print("\n");
			System.out.println("Men� Opciones:");
			System.out.println("1. Alta de Libro");
			System.out.println("2. Lista de Libros");
			System.out.println("3. Baja de Libros");
			System.out.println("4. B�squeda de Libros");
			System.out.println("5. Ordenacion de Libros");
			System.out.println("6. Guardar hacia fichero");
			System.out.println("7. Cargar desde fichero");
			System.out.println("8. Limpiar cat�logo");

			System.out.print(">>> Introduzca la opcion: ");

			opcion = leerOpcion(8); // param. int max

		} while (opcion <= 0);

		return opcion;
	}

	/**
	 * @param max Si la opci�n es demasiado alta o nula no seguir�
	 * @return
	 */
	private static int leerOpcion(int max) {
		int opcion = -1;
		try {
			Scanner teclado = new Scanner(System.in);
			opcion = teclado.nextInt();
			if (opcion > max)
				opcion = -1;
		} catch (InputMismatchException e) {
			System.out.println("Opci�n incorrecta");
		}

		return opcion;
	}

	/**
	 * M�todo q permite darle una entrada (elem) al arrayList principal, pregunta un
	 * patr�n por consola y lo validar� para a�adir
	 * 
	 * @param catalogo
	 */
	private static void alta(ArrayList<Libro> catalogo) {
		// Leer de la entrada
		String datosLibro = obtenerDatosLibro(); // titulo:isbn:genero:autor:paginas (PATR�N)

		// Procesar la entrada y crear el libro con los datos de la entrada
		Libro libro = procesaEntrada(datosLibro);

		catalogo.add(libro);
	}

	/**
	 * @return datos Si han sido correctamente VALIDADOS o no.
	 */
	private static String obtenerDatosLibro() {
		String datos = null;

		boolean validado = false;
		while (!validado) {
			System.out.println("Introduce los datos de un libro...");
			System.out.println("Usa el formato \"titulo:isbn:genero:autor:paginas\"");
			try {
				datos = leerCadena();
				if (true) // Se a�ade supuestamente ya que es v�lido el libro
					validado = true;
			} catch (InputMismatchException e) {
				System.out.println("Datos de entrada no v�lidos");
			}
		}

		return datos;
	}

	/**
	 * @param entrada
	 * @return libro ya construido correctamente, m�t constructor pre-usado.
	 */
	private static Libro procesaEntrada(String entrada) {
		Libro libro = null;

		String[] datos = entrada.split(":");

		String titulo = datos[0];
		String isbn = datos[1];
		Genero genero = Genero.getGenero(datos[2]);
		String autor = datos[3];
		Integer paginas = Integer.parseInt(datos[4]);

		libro = new Libro(titulo, isbn, genero, autor, paginas);

		return libro;
	}

	/**
	 * @return La opcion del men� escrita a consola.
	 */
	private static String leerCadena() {
		String opcion = null;
		Scanner teclado = new Scanner(System.in);
		opcion = teclado.nextLine();
		return opcion;
	}

	/**
	 * Este m�todo es una impresi�n directa por consola, bucle que muestra TODoS
	 * nuestros libros creados/cargados.
	 * 
	 * @param catalogo
	 */
	private static void listadoLibros(ArrayList<Libro> catalogo) {
		System.out.println("---");
		// String letras = catalogo.toString();
		for (int i = 0; i < catalogo.size(); i++) {
			System.out.println("*****");
			System.out.println("Libro en posici�n n�: " + (i)); // i starts 0
			System.out.println("T�tulo: " + catalogo.get(i).getTitulo());
			System.out.println("ISBN: " + catalogo.get(i).getIsbn());
			System.out.println("G�nero: " + catalogo.get(i).getGenero());
			System.out.println("Autor: " + catalogo.get(i).getAutor());
			System.out.println("N� P�g.: " + catalogo.get(i).getPaginas());
			System.out.println("*****");
		}
	}
//		ALTERNATIVE FOR-EACH --- M�s breve
//		for (Libro l : catalogo) {
//			System.out.println(l);
//		}

	/**
	 * Elimina un libro a una opci�n, requiere su posicionamiento a introducir.
	 * 
	 * @param catalogo
	 */
	private static void bajaLibros(ArrayList<Libro> catalogo) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Qu� libro borrar? Introduzca su posici�n del cat�logo");
		int opcion = teclado.nextInt();
		System.out.println("T�tulo del libro borrado: " + catalogo.get(opcion).getTitulo());
		catalogo.remove(opcion);
	}

	/**
	 * B�squeda por ISBN de un libro espec�fico, muestra sus datos si es valido.
	 * 
	 * @param catalogo
	 */
	private static void busquedaLibros(ArrayList<Libro> catalogo) {

		// Pregunta al usuario el ISBN escribiendo
		String isbn_deseado = "empty";
		Scanner teclado = new Scanner(System.in);
		System.out.print("-B�squeda r�pida-, introduzca el ISBN: ");
		isbn_deseado = teclado.nextLine();

		// Usa el m�todo .indexOf de List para ver si est� el Libro con el ISBN
		// introducido
		Libro l = new Libro();
		l.setIsbn(isbn_deseado);

		int posicion = 0;
		posicion = catalogo.indexOf(l);

		// Si no est� muestra un mensaje diciendo que el libro no est� en la lista
		if (posicion < 0) {
			System.out.println("El libro no existe");
		}

		// Si est� muestra todos los datos del libro
		else {
			System.out.println("\n El libro es: " + (catalogo.get(posicion)));
		}
	}

	/**
	 * Orden ascendente natural, eleccion por titulo (String) o paginas (Integer).
	 * Requiere compareTo y compare.
	 * 
	 * @param catalogo
	 */
	private static void ordenacion(ArrayList<Libro> catalogo) {

		// Pide al usuario si desea ordenar por t�tulo o por N�mero de P�ginas
		System.out.println("� Desea ordenar por t�tulo (T) o p�ginas (P) ?");
		Scanner teclado = new Scanner(System.in);
		String respuesta = teclado.next();

		// Para ordenar por t�tulo A-Z se debe usar el m�todo sort Collections od.
		// natural

		if (respuesta.equalsIgnoreCase("T")) {

			Collections.sort(catalogo);

			for (Libro l : catalogo) {
				System.out.println(" ");
				System.out.println(l);
			}
		}

		// Para ordenar por n� de P�ginas, usamos el m�todo sort de Collections que
		// recibe un comparator

		if (respuesta.equalsIgnoreCase("P")) {

//			Comparator<Libro> comparadorA = (uno, dos) -> uno.getPaginas().compareTo(dos.getPaginas());
//			catalogo.sort(comparadorA); LAMBDA NO SE PUEDE AUN

			Collections.sort(catalogo, new Libro());

			for (Libro l : catalogo) {
				System.out.println("jajajja");
				System.out.println(l.getPaginas());
				// System.out.println(l);
			}
		}
	}

	/**
	 * Guarda en un archivo plano texto los datos escritos, l�nea a l�nea. Es decir
	 * Un libro individual por l�nea y salto. \n
	 * 
	 * @param catalogo
	 * @throws IOException
	 */
	private static void guardarFichero(ArrayList<Libro> catalogo) throws IOException {
		try {
			Scanner teclado = new Scanner(System.in);
			String nombreFichero = teclado.next();

			FileWriter Escritor = new FileWriter(nombreFichero);

			// titulo,isbn,genero,autor,num_paginas --- DEBO HACER UN SALTO DE L�NEA,
			// UNKNOWN
			for (Libro l : catalogo) {
				Escritor.write(l.getTitulo() + "," + l.getIsbn() + "," + l.getGenero() + "," + l.getAutor() + ","
						+ l.getPaginas());
				Escritor.write("\n");
			}
			Escritor.close();

			System.out.println("Archivo rellenado! Se ha creado " + nombreFichero);

		} catch (IOException e) {
			System.out.println("ERROR, NO PERMITIDO");
			e.printStackTrace();
		}
	}

	/**
	 * Carga un archivo plano de texto, asignando a cada l�nea correspondiente UN
	 * elem. libro en el ArrayList
	 * 
	 * @param catalogo
	 */
	private static void cargarFichero(ArrayList<Libro> catalogo) {

		Libro libro = null;

		try {

			System.out.println("Introduzca el nombre del archivo a leer");
			Scanner teclado = new Scanner(System.in);
			String answer = teclado.next(); // Archivo blas, cambiar a input del usuario
			validatorDos(answer);

			if (validatorDos(answer) != true) {
				System.out.println("�No introduzca caracteres especiales!"); // Mejorar...
			}

			File myObj = new File(answer);//
			Scanner myReader = new Scanner(myObj);//

			System.out.println("�El FICHERO HA SIDO CARGADO!");

			while (myReader.hasNextLine()) {

				// System.out.println(myObj);

				String line = myReader.nextLine();
				String[] datos = line.split(",");

				String titulo = datos[0];
				String isbn = datos[1];
				Genero genero = Genero.getGenero(datos[2]);
				String autor = datos[3];
				Integer paginas = Integer.parseInt(datos[4]);

				libro = new Libro(titulo, isbn, genero, autor, paginas);
				catalogo.add(libro);

				// No mostrar nada m�s, usar el m�todo (2) de mostrarCatalogo...

			}

			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error del programa, vuelva al men�.");
			e.printStackTrace();
		}
	}

	/**
	 * BORRA TOTALMENTE el catalogo del ArrayList, deja vac�o
	 * 
	 * @param catalogo
	 */
	private static void deleteCatalogo(ArrayList<Libro> catalogo) {
		catalogo.clear();
		System.out.println(">>> Cat�logo REINICIADO!!! ");
	}

	// Peque�a validaci�n con RegEx.
	/**
	 * @param valideHere
	 * @return
	 */
	private static boolean validatorUno(String valideHere) {

		return valideHere.matches(" ^[\\w-]:[\\w-]:(NOVELA|POESIA|FICCION):[\\w-]:[0-9]+([\\.,][0-9]+)?$] ");

	}

	// Peque�a validaci�n con RegEx. --- Validaci�n de la entrada por lectura en
	// archivo.
	/**
	 * @param valideHere
	 * @return
	 */
	private static boolean validatorDos(String valideHere) {
		return valideHere.matches(" ^[^<>:;,?\"*|/]+$ ");
	}
}