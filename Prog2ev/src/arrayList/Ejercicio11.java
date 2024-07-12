package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que ordene alfabéticamente los elementos de un
 * ArrayList de datos String.
 */
public class Ejercicio11 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<>();
		tabla.add("zaca");
		tabla.add("melena");
		tabla.add("ana");
		tabla.sort(null);
		System.out.println(tabla);
	}
}
