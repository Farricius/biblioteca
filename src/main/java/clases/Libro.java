package clases;

import java.util.Comparator;

public class Libro implements Comparable<Libro>, Comparator<Libro> {

	// Comparable corresponde a compareTo (Básico), Comparator corresponde a Compare
	// (Avanzado, 2 objetos).

	private String titulo;
	private String isbn;
	private Genero genero;
	private String autor;
	private Integer paginas;

	// DECLARAC. MÉTODO CONSTRUCTOR

	public Libro() {

	}

	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.genero = genero;
		this.autor = autor;
		this.paginas = paginas;
	}

	/**
	 * @return the titulo
	 */
	public final String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public final void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the isbn
	 */
	public final String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public final void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the genero
	 */
	public final Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public final void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * @return the autor
	 */
	public final String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public final void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the paginas
	 */
	public final Integer getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas the paginas to set
	 */
	public final void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public boolean equals(Object o) {

		Libro l = (Libro) o;
		boolean b = false;

		if (this == o) {
			b = true;

		} else {
			if (this.isbn.equalsIgnoreCase(l.isbn)) {
				b = true;
			}
		}
		return b;
	}

	@Override
	public String toString() {
		String retorno;
		retorno = "Titulo: " + titulo + "\n";
		retorno = retorno + "isbn: " + isbn + "\n";
		retorno = retorno + "Genero: " + genero + "\n";
		retorno = retorno + "Autor: " + autor + "\n";
		retorno = retorno + "Paginas: " + paginas;
		return retorno;
	}

	@Override
	public int compareTo(Libro libroOrdenar) {
		return titulo.compareToIgnoreCase(libroOrdenar.getTitulo());
		// return libroOrdenar.getTitulo().compareToIgnoreCase(this.titulo); al reves

	}

	@Override
	public int compare(Libro o1, Libro o2) {

		return new Integer(o1.getPaginas()).compareTo(new Integer(o2.getPaginas()));
		// return new Integer(o2.getPaginas()).compareTo(new Integer(o1.getPaginas()));
		// al reves

	}
}

//	ORDENACIÓN POR PÁGINAS (COMPARE)
//	 @Override 
//	public int compareTo (Libro wapo) {
//		return this.paginas - wapo.getPaginas(); //Si swapeamos orden, saldría un orden descendente.
//		return wapo.getPaginas() - this.paginas();
//	}

// COMPARATOR here:
// POSITIVO: OBJ1.X > OBJ2.X
// CERO: OBJ1.X = OBJ2.X
// NEGATIVO: OBJ1.X < OBJ2.X

//	@Override
//	public int compare(Libro item1, Libro item2) { //item o1, item o2 sometidos a casting es válido ok tambien,* pref. decirlo en el implements.
//		return item1.getPaginas().compareTo(item2.getPaginas());
//	}
//}
//	

//	@Override
//	public int compare(Libro item1, Libro item2) { 
//		int rpta = 0;
//		if ( item1.getPaginas() > item2.getPaginas() ) {
//			rpta = 1;
//		} else if  ( item1.getPaginas() < item2.getPaginas() ) {
//			rpta = -1;	
//		}else {
//			rpta = 0;
//		} 
//		return rpta;
//	}
//}

//	public static Comparator<Libro> xd = new Comparator<Libro>() {
//	
//		public int compare(Libro m1, Libro m2) {
//			if(m1.getPaginas() == m1.getPaginas()){
//				return 0;
//			}
//			if (m1.getPaginas() > m2.getPaginas())
//				return -1;
//			else
//				return 1;
//		}
//	};
//}

//		if () {
//			return -1;
//		} else if () {
//			return 0;
//		} else {
//			return 1;
//		}
//	}
//}

//@Override
//    public int compare(Libro per1, Libro per2) {
//        int rpta = 0;
//        if (per1.getPaginas() > per2.getPaginas()) {
//            rpta = 1;
//        } else if (per1.getPaginas() < per2.getPaginas()) {
//            rpta = -1;
//        } else {
//            rpta = 0;
//
//            if (rpta == 0) {
//                if (per1.getTitulo().compareToIgnoreCase(per2.getTitulo()) > 0) {
//                    rpta = 1;
//                } else if (per1.getTitulo().compareToIgnoreCase(per2.getTitulo()) < 0) {
//                    rpta = -1;
//                } else {
//                    rpta = 0;
//                }
//            }
//
//        }
//        return rpta;
//    }
//if (a instanceof int[] && b instanceof int[]) { // +Sysos con prueba
//
//	// Transform.
//	int[] vectorA = (int[]) a;

//Por filas y columnas
//public class RecorrerMatrizPorFilasYColumnas {
//	public static void main(String[] args) {
//		int[][] matriz = new int[50][100]; // Matriz de números enteros que supondremos llena.
//						   // 50 filas y 100 columnas.
//	
//		for (int i = 0; i < 50; i++)		// El primer índice recorre las filas.
//			for (int j = 0; j < 100; j++){	// El segundo índice recorre las columnas.
//				// Procesamos cada elemento de la matriz.
//				System.out.println(matriz[i][j]);
//			}
//	}
//}
//Por columnas y filas
//public class RecorrerMatrizPorColumnasYFilas {
//	public static void main(String[] args) {
//		int[][] matriz = new int[50][100]; // Matriz de números enteros que supondremos llena.
//						   // 50 filas y 100 columnas.
//	
//		for (int i = 0; i < 100; i++)		// El primer índice recorre las columnas.
//			for (int j = 0; j < 50; j++){	// El segundo índice recorre las filas.
//				// Procesamos cada elemento de la matriz.
//				System.out.println(matriz[j][i]);	// ¡Índices cambiados de orden!
//			}
//	}
//}
//Por filas y columnas al revés
//public class RecorrerMatrizPorFilasYColumnasAlReves {
//	public static void main(String[] args) {
//		int[][] matriz = new int[50][100]; // Matriz de números enteros que supondremos llena.
//						   // 50 filas y 100 columnas.
//	
//		for (int i = 49; i > 0; i--)		// El primer índice recorre las filas.
//			for (int j = 99; j > 0; j--){	// El segundo índice recorre las columnas.
//				// Procesamos cada elemento de la matriz.
//				System.out.println(matriz[i][j]);
//			}
//	}
//}
//System.out.println(factorial(5));
//}
//public static double factorial(int n){
//if (n==0)
//    return 1;
//else
//  return n*(factorial(n-1));
//}
//}