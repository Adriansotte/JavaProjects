package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que dado un String, elimine de este los caracteres
 * “b” y “ac”.
 */
public class Ejercicio5 {
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame un String: ");
		String x = entrada.next();
		System.out.println(x.replaceAll("ac", "").replaceAll("b", ""));
	}
}
