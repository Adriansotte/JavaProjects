package tarea1;

import java.util.Scanner;

public class Ejercicio5 {
	/**
	 * Implementa un programa Java que PREGUNTE al usuario por dos
	 * números enteros (x, y) y muestre por pantalla la suma, resta,
	 * multiplicación, división y resto de ambos, con el siguiente formato:
	 * x + y = … x – y = … x * y = … x / y = …
	 */
	public static void main(String[] args) {
		
		/**
		 * Pre: ---
		 * Post: 
		 */
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduzca entero");
		int x = entrada.nextInt();
		System.out.print("Introduzca otro entero");
		int y = entrada.nextInt();
		int suma = x + y;
		int resta = x - y;
		int multiplicacion = x * y;
		int division = x / y;
		double resto = x % y;
		System.out.println("Suma=" + suma);
		System.out.println("Resta=" + resta);
		System.out.println("Multiplicacion=" + multiplicacion);
		System.out.println("Division=" + division);
		System.out.println("Dresto=" + resto);
	}

}
