package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que actualice el valor de un elemento específico
 * de un ArrayList de datos String.
 */
public class Ejercicio4 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<String>();
		tabla.add("Peroo");
		tabla.add("Gatos");
		tabla.add("Canas");
		tabla.add("Comida");
		tabla.set(2, "Cambio");
		System.out.println(tabla);
	}
}
