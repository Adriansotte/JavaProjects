package tarea3;

import java.util.Scanner;

public class Ejercicio1 {
	/**
	 * Implementa un programa Java que lea un número real (decimales) y
	 * muestre su cuadrado. Repetir el proceso hasta que se introduzca un número negativo.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		double x = 1;
		while(x > 0) {
			System.out.println("Dame un numero: ");
			x =entrada.nextDouble();
			if (x < 0) {
				System.out.println("Se para el programa.");
				break;
			}
			System.out.println("√" + x + "= "  + x * x);
			
		}
	}
	
}