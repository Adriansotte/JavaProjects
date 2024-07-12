package tarea11;

import java.util.Arrays;

/**
 * Implementa un programa Java que encuentre el segundo elemento más pequeño, y
 * el segundo elemento mayor de un Array de enteros de longitud 20.
 */
public class Ejercicio1 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] tabla = {1,6,3,4,8,9,6,5,7,2,10,51,84,91,81,63,51,92,5};
		Arrays.sort(tabla);
		System.out.println(tabla[1] + " - " + tabla[tabla.length - 2]);
	}

}
