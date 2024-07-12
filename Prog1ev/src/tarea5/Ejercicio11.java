package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que solicite al usuario una cadena de
 * caracteres y devuelva dicha cadena, pero al revés.
 */
public class Ejercicio11 {
	
	/**
	 * Pre: ---
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
		System.out.println("Introduzca una cadena de caracteres:");
		String n = entrada.nextLine();
		int i = n.length();
		while(i != 0) {
			String r = n.substring(i-1, i);
			System.out.print(r);
			i--;
		}	
	}
}
