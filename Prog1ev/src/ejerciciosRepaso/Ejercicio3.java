package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que pregunte al usuario por dos Strings, y compruebe
 * si el primero de ellos contiene al segundo.
 */
public class Ejercicio3 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame dos Strings: ");
		String x = entrada.nextLine();
		String y = entrada.nextLine();
		comparar(x, y);
	}
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void comparar(String x, String y) {
		for(int i = 0; i <= y.length() - x.length(); i++) {
			if(x.equalsIgnoreCase(y.substring(i, i + x.length()))) {
				System.out.println("El primer String esta contenido en el segundo String.");
				break;
			} if(i == y.length() - x.length()) {
				System.out.println("No esta contenido.");
			}
		} 
	}
}
