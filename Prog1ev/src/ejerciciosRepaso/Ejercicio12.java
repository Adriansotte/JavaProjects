package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que muestre los elementos comunes de dos arrays de
 * enteros.
 */
public class Ejercicio12 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame 10 numeros: "); 
		int[] tabla1 = new int[10];
		int[] tabla2 = new int[10];
		for(int i = 0; i < tabla1.length; i++) {
			tabla1[i] = entrada.nextInt();
		} System.out.println("Dame 10 numeros: "); 
		for(int i = 0; i < tabla2.length; i++) {
			tabla2[i] = entrada.nextInt();
		}
		comparar(tabla1, tabla2);
	}
	
	public static void comparar(int[] tabla1, int[] tabla2) {
		int cont = 0;
		for(int i = 0; i < tabla1.length; i++) {
			for(int j = 0; j < tabla1.length; j++) {
				if(tabla1[i] == tabla2[j]) {
					System.out.println("Elementos repetidos: " + tabla1[i]);
					cont++;
					break;
				}
			
			} 
		} if(cont > 0) {
			System.out.println("Numeros repetidos= " + cont);
		} else {
			System.out.println("NO hay prepetidos.");
		}
	}
}
