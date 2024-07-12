package tarea2;

import java.util.Scanner;

public class Ejercicio7 {
	/**
	 *  Escribe un programa Java que pregunte al usuario por un número entero y muestre por pantalla su tabla de multiplicar
	 */
	public static void main(String[] args)  {
		/**
		 * Pre; ---
		 * Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		int x = entrada.nextInt();
		int tabla = 0;
		int numeral = 0;
		System.out.println("Su tabla de multiplicar es:");
		while(tabla <= 10) {
			System.out.println(numeral + ". " + tabla + " * " + x + " = " + (x * tabla));
			tabla = tabla + 1;
			numeral = numeral + 1;
		}
		
	}

}
