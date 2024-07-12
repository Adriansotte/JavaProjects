package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java elimine el elemento en la posición 3 de un
 * ArrayList de datos String.
 */
public class Ejercicio5 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<String>();
		tabla.add("Perro");
		tabla.add("Gato");
		tabla.add("Conejo");
		tabla.add("Ciervo");
		tabla.remove(3);
		System.out.println(tabla);
	}
}
