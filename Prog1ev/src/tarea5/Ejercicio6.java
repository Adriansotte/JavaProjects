package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que solicite al usuario una cadena de
 * caracteres (String) y muestre por pantalla dicha cadena, pero con el
 * primer y último carácter cambiados de posición.
 */
public class Ejercicio6 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		cadena();
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void cadena() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una cadena de caracteres:");
		String n = entrada.nextLine();
		String n1 = cadena(n);
		System.out.println(n1);
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static String cadena(String cadena) {
			if(cadena.length() > 2) {
				return cadena.substring(cadena.length() - 1, cadena.length()) +
						cadena.substring(1, cadena.length() - 1) + 
						cadena.substring(0, 1);
			} else if(cadena.length() < 2) {
				return cadena;
			} else {
				return cadena.substring(1, 2) + cadena.substring(0, 1);
			}
	}
}
