package tarea4;

import java.util.Scanner;

public class Ejercicio8 {
	/**
	 * Escribe un programa Java que pregunte al usuario por 10 números enteros
	 * y muestre por pantalla el número mayor y el menor de todos los introducidos
	 */

		public static void main(String[] arg) {
			/**
			 * Pre: ---
			 * Post:
			 */
			respuesta();
		}
		
		public static void respuesta() {
			/**
			 * Pre:---
			 * Post:
			 */
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduzca diez numeros:");
			int nMayor = 0;
			int nMenor= 0;
			for(int i = 0; i < 10; i++) {
				int x = entrada.nextInt();
				if(i == 0) {
					nMayor = x;
					nMenor = x;
				}
				if(x > nMayor) {
					nMayor = x;
				}
				if(x < nMayor) {
					nMenor = x;
				}
			}
			System.out.println("Numero mayor: " + nMayor + "; Numero menor: " + nMenor);
		}
}
