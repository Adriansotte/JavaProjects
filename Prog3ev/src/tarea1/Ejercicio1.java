package tarea1;

import java.util.Scanner;

/**
 * Implementa un programa Java que sume los números naturales hasta N (introducido por el usuario) de forma recursiva.
 */
public class Ejercicio1 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int numero = n.nextInt();
		System.out.println(suma(numero));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int suma(int numero) {
		if(numero == 0) {
			return 0;
		} else {
			return numero + (suma(numero - 1));
		}
	}
}
