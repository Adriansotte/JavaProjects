package practica4;

import java.util.Comparator;

/**
 * Clase que se utiliza para ordenar ArrayList de objetos Alumno
 * alfabeticamente segun el nombre.
 */
public class AlumnosAlfabeticamente implements Comparator<Alumno>{
	
	/**
	 * Pre:---
	 * Post: metodo que ordena segun el nombre los dos objetos recibidos.
	 */
	@Override
	public int compare(Alumno o1, Alumno o2) {
		if(o1.getNombre().compareTo(o2.getNombre()) < 0 ) {
			return -1;
		} else if(o1.getNombre().compareTo(o2.getNombre()) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}