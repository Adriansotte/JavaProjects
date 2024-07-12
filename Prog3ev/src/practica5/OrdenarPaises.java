package practica5;

import java.util.Comparator;

/**
 * Clase que ordena los paises segun el numero su numero de ocurrencias. 
 */
public class OrdenarPaises implements Comparator<Pais>{

	@Override
	/**
	 * Pre:---
	 * Post: metodo que compara dos objetos de tipo pais y devuelve un 
	 * 		 parametro segun su atributo ocurrencias.
	 */
	public int compare(Pais o1, Pais o2) {
		if(o1.getOcurrencias() > o2.getOcurrencias()) {
			return -1;
		} else if(o1.getOcurrencias() == o2.getOcurrencias()) {
			return 0;
		} else {
			return 1;
		}
	}
}
