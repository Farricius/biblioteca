/**

 * Enum de GENEROS aplicados a nuestro gestor de bibliotecas & libros.

 * @author: JD Hernandez Farricius
 * @version: 12/03/2021
 */

package clases;

public enum Genero {
	NOVELA,
	POESIA,
	FICCION;

	public static Genero getGenero(String genero) {
		Genero seleccionado = null;
    	
    	switch(genero.toUpperCase()) {
    		case "NOVELA":
    			seleccionado = Genero.NOVELA;
    			break;
    		case "FICCION":
    			seleccionado = Genero.FICCION;
    			break;
    		case "POESIA":
    			seleccionado = Genero.POESIA;
    			break;
    	}
    	
    	return seleccionado;
	}
}