package tarea2;

import java.util.Scanner;

public class Ejercicio8 {
	/**
	 * Escribe un programa Java que pregunte al usuario por 10 números enteros y muestre por pantalla 
	 * el número mayor y el menor de todos los introducidos
	 */
	
	public static void main(String [] args) {
		/**
		 * Pre:---
		 * Post:
		 */
		
		Scanner entrada = new  Scanner(System.in);
		System.out.println("Escriba 10 numeros y en pantalla se mostrara el mayor de todos y el menor de todos:");
		int i = 0;
		int nMayor = 0;
		int nMenor = 0;
		while(i < 10) {
			int x = entrada.nextInt();
			if(i == 0) {
				nMayor = x;
				nMenor = x;
			}
			if(x > nMayor) {
				nMayor = x;
			}
			if(x < nMenor) {
				nMenor = x;
			}
			i++;
		}
		System.out.println("El numero mayor es: " + nMayor + ". El numero menor es: " + nMenor);
	}
}
