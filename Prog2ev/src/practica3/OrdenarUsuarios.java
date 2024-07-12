package practica3;

import java.util.Comparator;
/**
 * Clase que se utiliza para ordenar a los usuarios de mayor a menor
 * segun su numero total de usos. 
 */
public class OrdenarUsuarios implements Comparator<UsuarioBici>{
	
	/**
	 * Pre:---
	 * Post: metodo que ordena los usuarios del ArrayList de mayor a menor
	 * 		 segun sus viajes totales.
	 */
	@Override
	public int compare(UsuarioBici o1, UsuarioBici o2) {
		if(o1.calcularTotal() > o2.calcularTotal()) {
			return -1;
		} else if(o1.calcularTotal() == o2.calcularTotal()) {
			return 0;
		} else {
			return 1;
		}
	}

}
