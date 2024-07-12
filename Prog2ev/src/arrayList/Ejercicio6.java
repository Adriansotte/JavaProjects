package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que copie/clone un ArrayList en otro.
 */
public class Ejercicio6 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<String>();
		ArrayList<String> tabla2 = new ArrayList<String>();
		tabla.add("Perro");
		tabla.add("Gato");
		tabla.add("Conejo");
		tabla.add("Ciervo");
		for(int i = 0; i < tabla.size(); i++) {
			tabla2.add(tabla.get(i));
		} System.out.println(tabla + " " + tabla2);
	}
}
