package practica1;

import java.util.Comparator;

/**
 * <h2>Clase que compara los equipos segun los goles que metan.<h2> 
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class MaxGolEquipo implements Comparator<Equipo>{
	
	/**
	 * Pre: ---
	 * Post: sobreescribe el metodo compare de manera que ordene
	 * 		 el ArrayList por los goles de cada equipo.
	 */
	@Override
	public int compare(Equipo o1, Equipo o2) {
		if(o1.getGoles() > o2.getGoles()) {
			return -1;
		} else if(o1.getGoles() == o2.getGoles()) {
			return 0;
		} else {
			return 1;
		}
	}
}
