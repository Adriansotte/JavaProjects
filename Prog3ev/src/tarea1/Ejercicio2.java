package tarea1;

import java.util.Scanner;

/**
 * Implementa un programa Java que dado un número natural N, 
 * devuelva su factorial de forma recursiva.
 */
public class Ejercicio2 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.println("Dame un numero: ");
		int x = n.nextInt();
		System.out.println(factorial(x));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int factorial(int x) {
		if(x == 0) {
			return 1;
		} else {
			return x * (factorial(x - 1));
		}
	}
}
