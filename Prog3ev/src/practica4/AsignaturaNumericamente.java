package practica4;

import java.util.Comparator;

/**
 * Clase que se utiliza para ordenar ArrayList de objetos Asignatura
 * numericamente segun su codigo de asignatura.
 */
public class AsignaturaNumericamente implements Comparator<Asignatura>{
	
	/**
	 * Pre:---
	 * Post: metodo que ordena segun el codAsig los dos objetos recibidos.
	 */
	@Override
	public int compare(Asignatura o1, Asignatura o2) {
		if(o1.getCodAsig() < o2.getCodAsig()) {
			return -1;
		} else if(o1.getCodAsig() == o2.getCodAsig()) {
			return 0;
		} else {
			return 1;
		}
	}
}