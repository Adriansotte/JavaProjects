package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que muestre los elementos comunes de dos arrays de
 * Strings.
 */
public class Ejercicio13 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame varios strings");
		String x = entrada.nextLine();
		System.out.println("Dame varios strings");
		String y = entrada.nextLine();
		String[] tabla1 = x.split(" ");
		String[] tabla2 = y.split(" ");
		comunes(tabla1, tabla2);
	}
	public static void comunes(String[] tabla1, String[] tabla2) {
		System.out.print("Se repiten: ");
		int cont = 0;
		for(int i = 0; i < tabla1.length; i++) {
			for(int j = 0; j < tabla1.length; j++) {
				if(tabla1[i].equals(tabla2[j])) {
					System.out.print(tabla1[i] + " ");
					cont++;
					break;
				}
			}
		} if(cont == 0) {
			System.out.println("No hay palabras coincidientes.");
		}
	}
}
