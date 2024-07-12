package practica4;

import java.util.Comparator;

/**
 * Clase que se utiliza para ordenar ArrayList de objetos Alumno
 * numericamente segun su nip.
 */
public class AlumnosNumericamente implements Comparator<Alumno>{
	
	/**
	 * Pre:---
	 * Post: metodo que ordena segun el nip los dos objetos recibidos.
	 */
	@Override
	public int compare(Alumno o1, Alumno o2) {
		if(o1.getNip() < o2.getNip()) {
			return -1;
		} else if(o1.getNip() == o2.getNip()) {
			return 0;
		} else {
			return 1;
		}
	}
}