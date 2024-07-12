package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que solicite al usuario una cadena de
 * caracteres (String) y muestre por pantalla dicha cadena sin el último
 * caracter.
 */
public class Ejercicio3 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println(cadena());
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static String cadena() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca una cadena de caracteres:");
		String n = entrada.nextLine();
		String nada = "Usted no ha escrito nada.";
		if(n.equals("")) {
			return nada;
		}
		String n2 = n.substring(0, n.length()-1);
		return n2;
	}
}
