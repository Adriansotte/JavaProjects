package tarea3;

import java.util.Scanner;

public class Ejercicio2 {
	/**
	 * Implementa un programa Java que lea un número real (decimales) e
	 * indique si es positivo o negativo. El proceso se repetirá hasta que se
	 * introduzca un 0.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:--
		 * Post
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduza un numero:");
		double x = 1;
		while(x < 0 != x > 0) {
			x = entrada.nextDouble();
			if(x < 0) {
				System.out.println("El numero introducido es negativo.");
			} else if(x > 0) {
				System.out.println("El numero introducido es positivo");
			} else if(x == 0) {
				System.out.println("Se acabo.");
				break;
			}
		}
	}
}
