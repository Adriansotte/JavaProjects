package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que pregunte al usuario por dos Strings y los
 * compare lexicográficamente. Dos Strings son lexicográficamente iguales si
 * tienen la misma longitud y contienen los mismos caracteres en las mismas
 * posiciones.
 */
public class Ejercicio1 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame un caracter a comparar");
		String i = entrada.next();
		System.out.println("Dame un caracter a comparar");
		String j = entrada.next();
		comparar(i, j);
	}
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void comparar(String i, String j) {
		if(!i.equalsIgnoreCase(j) ) {
			System.out.println("Los datos introducidos no son iguales.");
		} else {
			System.out.println("Los datos son iguales.");
		}
	}
}
