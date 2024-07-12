package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que, dado un array de Strings, determine si sus
 * elementos se leen igual de principio a final y a la inversa.
 */
public class Ejercicio19 {
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame una serie de Strings: ");
		String palabra = entrada.nextLine();
		String[] tabla = palabra.split(" ");
		comprobar(tabla);
	}
	/**
	 * Pre:
	 * Post:
	 */
	public static void comprobar(String[] tabla) {
		for(int i = 0; i < tabla.length; i++) {
			if(!tabla[i].equals(tabla[tabla.length  - 1 - i])) {
				System.out.println("No se lee igual.");
				break;
			} else if(i == tabla.length - 1) {
				System.out.println("Se lee igual en ambas direcciones.");
			}
		} 
	}
}
