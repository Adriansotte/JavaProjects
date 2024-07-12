package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que encuentre los elementos duplicados de un array
 * de Strings.
 */
public class Ejercicio14 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escribe varias palabras separadas con un espacio: ");
		String palabras = entrada.nextLine().toLowerCase();
		String[] tabla = palabras.split(" ");
		comparar(tabla);
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void comparar(String[] tabla) {
		if(tabla.length > 1) {
			for(int i = 0; i < tabla.length; i++) {
				for(int j = i + 1; j < tabla.length; j++) {
					if(tabla[i].equalsIgnoreCase(tabla[j])) {
						System.out.println("El elemento: " + tabla[i] + " esta repetido.");
						break;
					}
				}
			}
		} else {
			System.out.println("Solo hay un caracter.");
		}
	}
}
