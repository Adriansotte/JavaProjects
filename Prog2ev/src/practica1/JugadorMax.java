package practica1;

import java.util.Comparator;

/**
 * <h2>Clase que se utiliza para comparar los jugadores segun
 * los goles que han metido.<h2> 
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class JugadorMax implements Comparator<Jugador>{
	
	/**
	 * Pre: ---
	 * Post: sobreescribe el metodo compare para que ordene el
	 * 		 ArrayList por el numero de goles de cada jugador.
	 */
	@Override
	public int compare(Jugador o1, Jugador o2) {
		if(o1.getGoles() > o2.getGoles()) {
			return -1;
		} else if(o1.getGoles() == o2.getGoles()) {
			return 0;
		} else {
			return 1;
		}
	}
}
