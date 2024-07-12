package practica1;

import java.util.Comparator;

/**
 * <h2>Clase que se utiliza para comparar cada jugador segun las
 * expulsiones que ha tenido.<h2> 
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class MaxExpulsiones implements Comparator<Jugador> {
	
	/**
	 * Pre: ---
	 * Post: sobreescribe el metodo compare para que ordene el
	 * 	 	 ArrayList segun las expulsiones de cada jugador.
	 */
	@Override
	public int compare(Jugador o1, Jugador o2) {
		if(o1.getExpulsiones() > o2.getExpulsiones()) {
			return -1;
		} else if(o1.getExpulsiones() == o2.getExpulsiones()) {
			return 0;
		} else {
			return 1;
		}
	}

}
