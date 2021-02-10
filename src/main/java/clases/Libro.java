package clases;

public class Libro {

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
}
//@Override
//public boolean equals(Object obj) {
//   if (!(obj instanceof Song))
//        return false;
//    if (obj == this)
//        return true;
//
//    Song s= (Song) obj;
//    return s.getTitle().equals(this.title);
//	}
//}

//if (a instanceof int[] && b instanceof int[]) { // +Sysos con prueba
//
//	// Transform.
//	int[] vectorA = (int[]) a;
