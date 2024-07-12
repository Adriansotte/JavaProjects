package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que solicite al usuario una cadena de
 * caracteres (String) y muestre por pantalla el número de veces que
 * aparece la sub-cadena “aaa” dentro de dicho String.
 * Ej: usuario introduce “aabaabaababababaa” –&gt; el resultado debe ser:
 * “Número de veces que aparece aa: 4”
 */
public class Ejercicio5 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca una cadena de caracteres que contengan la letra a:");
		String n = entrada.nextLine();
		cadena(n);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void cadena(String n) {
		int contador = 0;
		for(int i = 0; i <= n.length()-2; i++) {
			if(n.substring(i, i+2).equals("aa")) {
				contador++;
			}
		} System.out.println("Numero de veces que aparece aa:" + contador);	
	}
}
