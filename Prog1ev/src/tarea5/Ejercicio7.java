package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que detecte si el número entero
 * introducido por el usuario es un “Número Feo”. Los números feos son
 * aquellos enteros positivos cuyos únicos factores primos son 2, 3 o 5. Por
 * convención el 1 está incluido. Los primeros 10 números feos son los
 * siguientes: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12.
 */
public class Ejercicio7 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe numeros y el programa dira si son buenos o feos:");
		detectar(entrada);
	}
	
	/**
	 * Pre:---
	 * Post
	 */
	public static void detectar(Scanner entrada) {
		while(true) {
			int i = entrada.nextInt();
			if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i == 1) {			
				System.out.println("Numero feo");
			} else {
				System.out.println("Numero buenorro");
			}
		}
	}
}
