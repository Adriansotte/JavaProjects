package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que pregunte al usuario por dos Strings, y devuelva
 * la concatenación de ambos.
 */
public class Ejercicio2 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame un String: ");
		String x = entrada.next();
		System.out.println("Dame otro String: ");
		String y = entrada.next();
		concatenacion(x, y);
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void concatenacion(String x, String y) {
		System.out.println(x + y);
	}
}
