package practica1;

import java.util.Comparator;

/**
 * <h2>Clase que se utiliza para comparar los equipos segun los puntos de
 * de cada equipo..<h2>
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class CompararEquipos implements Comparator<Equipo>{
	
	/**
	 * Pre: ---
	 * Post: metodo que sobreescribe el metodo compare de forma que compare
	 * 		 segun los puntos del equipo.
	 */
	@Override
	public int compare(Equipo o1, Equipo o2) {
		if(o1.getPuntos() > o2.getPuntos()) {
			return -1;
		} else if(o1.getPuntos() > o2.getPuntos()) {
			return 0;
		} else {
			return 1;
		}
	}
}
