package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que inserte un elemento en la primera posición de
 * un ArrayList de datos String.
 */
public class Ejercicio2 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<String>();
		tabla.add("uUtimo");
		for(int i = 0; i < 4; i++) {
			tabla.add(0, "Hola");
		} System.out.println(tabla);
	}
}
