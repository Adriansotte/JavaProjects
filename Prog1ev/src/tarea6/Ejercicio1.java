package tarea6;

import java.util.Scanner;

/**
 * Implementa un programa Java que le solicite al usuario un número entero
 * positivo y escriba dicho número con letra por pantalla. Únicamente debe
 * mostrar los nombres de los números del 0 al 9, el resto los mostrará con
 * el nombre “Otros”.
 */
public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		mostrar();
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe un numero del 0 al 9 por pantalla:");
		int n = entrada.nextInt();
		if(n == 0) {
			System.out.println("Cero.");
		} else if(n == 1) {
			System.out.println("Uno.");
		} else if(n == 2) {
			System.out.println("Dos.");
		} else if(n == 3) {
			System.out.println("Tres.");
		} else if(n == 4) {
			System.out.println("Cuatro.");
		} else if(n == 5) {
			System.out.println("Cinco.");
		} else if(n == 6) {
			System.out.println("Seis.");
		} else if(n == 7) {
			System.out.println("Siete.");
		} else if(n == 8) {
			System.out.println("Ocho.");
		} else if(n == 9) {
			System.out.println("Nueve.");
		} else {
			System.out.println("Otro.");
		}
	}
}
