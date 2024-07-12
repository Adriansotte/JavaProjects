package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que solicite al usuario una cadena de
 * caracteres (String) y muestre por pantalla la longitud de esta.
 */
public class Ejercicio4 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println(longitud());
	}
	
	/**
	 * Pre:---
	 * Post
	 */
	public static int longitud() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca una cadena de caracteres:");
		String n = entrada.nextLine();
		int n1 = n.length();
		return n1;
	}
}
