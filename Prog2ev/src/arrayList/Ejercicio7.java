package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que revierta la posición de todos los elementos
 * de un ArrayList de datos String.
 */
public class Ejercicio7 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<>();
		tabla.add("Perro");
		tabla.add("Gato");
		tabla.add("Conejo");
		tabla.add("Ciervo");
		System.out.println(tabla);
		for(int i = 0; i < tabla.size() / 2; i++) {
			String aux = tabla.get(i);
			tabla.set(i, tabla.get(tabla.size() - 1 - i));
			tabla.set(tabla.size() - 1 - i, aux);
		}
		System.out.println(tabla);
	}
}
