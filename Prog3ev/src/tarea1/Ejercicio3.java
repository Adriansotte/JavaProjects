package tarea1;

import java.util.Scanner;

/**
 * Implementa un programa Java que dada una tabla de números enteros, 
 * muestre por pantalla sus valores de forma recursiva.
 */
public class Ejercicio3 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] numeros = new int[] {3, 5, 6, 10, 23};
		recorrerTabla(0, numeros);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int recorrerTabla(int numero, int[] n) {
		System.out.println(n[numero]);
		if(numero == n.length - 1) {
			return 1;
		} else {
			return recorrerTabla(numero + 1, n );
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrarRecursivo(int[] t) {
		mostrarRecursivo(t, 0);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	private static void mostrarRecursivo(int[] t, int i) {
		if(i < t.length) {
			System.out.println(t[i]);
		}
	}
}
