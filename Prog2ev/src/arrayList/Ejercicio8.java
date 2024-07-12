package arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implementa un programa Java que elimine todos los elementos entre la posición
 * N y M de un ArrayList de datos String.
 */
public class Ejercicio8 {
	/**
	 * Pre: --- Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<>();
		ArrayList<String> tabla1 = new ArrayList<>();
		tabla.add("0Perro");
		tabla1.add("0Perro");
		tabla.add("1Gato");
		tabla.add("2Conejo");
		tabla.add("3Ciervo");
		tabla.add("4Perico");
		tabla1.add("4Perico");
		tabla.add("5Cana");
		tabla.add("6Correo");
		tabla = tabla1;
		System.out.println(tabla);

	}
}
