package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que muestre por pantalla el valor de un elemento
 * específico (debes indicar el índice) de un ArrayList de datos String.
 */
public class Ejercicio3 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<String>();
		tabla.add("hola");
		tabla.add("adiosa");
		tabla.add("perro");
		tabla.add("caracoles");
		System.out.println(tabla.get(3));
	}
}
