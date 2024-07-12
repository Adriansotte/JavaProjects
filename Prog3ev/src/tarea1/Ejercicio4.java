package tarea1;

import java.util.Scanner;

/**
 * Implementa un programa Java que dada una tabla de números enteros y un número N,
 * devuelva true sí o sólo sí N se encuentra dentro de la tabla dada.
 */
public class Ejercicio4 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args ) {
		System.out.print("Dame un numero: ");
		Scanner n = new Scanner(System.in);
		int numero = n.nextInt();
		int[] numeros = new int[] {3, 5, 6, 10, 23};
		comprobarNumero(numeros, numero);
		
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void comprobarNumero(int[] numeros, int numero) {
		System.out.println(comprobarNumero(numeros, numero, 0));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	private static boolean comprobarNumero(int[] numeros, int numero, int i) {
		if(i < numeros.length) {
			if(numero == numeros[i]) return true;
			else return comprobarNumero(numeros, numero, i + 1);							
		} return false; 
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	private static boolean solucionAlvaro(int[] numeros, int numero, int i) {
		if(i == numeros.length) return false;
		else if(numeros[i] == numero) return true;
		else return solucionAlvaro(numeros, numero, i + 1);
	}
}
