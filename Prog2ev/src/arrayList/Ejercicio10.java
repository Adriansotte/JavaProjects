package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que unifique dos ArrayLists de datos String en
 * uno solo.
 */
public class Ejercicio10 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<>();
		ArrayList<String> copia = new ArrayList<>();
		tabla.add("uno");
		tabla.add("dos");
		copia.add("uno");
		copia.add("cuatro");
		System.out.println(tabla + " " + copia);
		unificar(tabla, copia);
		System.out.println(tabla.indexOf("uno"));
	}
	/**Pre: ---
	 * Post:
	 */
	public static void unificar(ArrayList<String> tabla, ArrayList<String> copia) {
		for(int i = 0; i < copia.size(); i++) {
			tabla.add(copia.get(i));
		} System.out.println(tabla);
	}
}
