package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que indique si dos Strings son rotación entre ellos.
 * 1º String: Hola 2º String: aloH ¡SON ROTACIÓN!
 */
public class Ejercicio7 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame dos Strings: ");
		String x = entrada.next().toLowerCase();
		String y = entrada.next().toLowerCase();
		rotacion(x, y);
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void rotacion(String x, String y) {
		if(x.length() == y.length()) {
			String xinver = "";
			for(int i = x.length() -1 ; i >= 0; i--) {
				xinver += x.charAt(i);
			} 
			if(xinver.equals(y)) {
				System.out.println("Estan en rotacion");
			} else {
				System.out.println("No estan en rotacion.");
			}
		} else {
			System.out.println("No estan en rotacion.");
		}
	}
}
