package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que encuentre todos los pares de elementos enteros
 * de un array que suman el valor escrito por el usuario.
 */
public class Ejercicio16 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe un numero y sacaremos las posibles combinaciones de numeros "
				+ "que dan como resultado dicho numero.");
		int numero = entrada.nextInt();
		int[] tabla = new int[numero];
		for(int i = 0; i < tabla.length; i++) {
			tabla[i] = i + 1;
		}
		combinar(numero, tabla);
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void combinar(int numero, int[] tabla) {
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla.length; j++) {
				if(i + j == numero) {
					System.out.println("Combinacion: " + i + " + " + j);
				}
			}
		}
	}
}
