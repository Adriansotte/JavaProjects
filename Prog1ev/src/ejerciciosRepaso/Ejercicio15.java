package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que encuentre los elementos duplicados de un array
 * de enteros.
 */
public class Ejercicio15 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escribe varios numeros separados por un espacio: ");
		String letras = entrada.nextLine();
		String[] tabla1 = letras.split(" ");
		int[] ent = new int[tabla1.length];
 		for(int i = 0; i < tabla1.length; i++) {
			ent[i] = Integer.parseInt(tabla1[i]);
		}
 		duplicados(ent);
	}
	/**
	 * Pre:
	 * Post:
	 */
	public static void duplicados(int[] ent) {
		for(int i = 0; i < ent.length; i++) {
			for(int j = 1 + i; j < ent.length; j++) {
				if(ent[i] == ent[j]) {
					System.out.println("El numero: " + ent[i] + " esta repetido.");
					break;
				}
			}
		}
	}
}
