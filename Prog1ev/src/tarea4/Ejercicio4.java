package tarea4;

import java.util.Scanner;

public class Ejercicio4 {
	/*
	 * Escribe un programa Java que pregunte al usuario por 2 números,
	 *  y te muestre por pantalla todos los números situados entre ambos
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre: ---
		 * Post:
		 */
		System.out.println("Introduce un numero: ");
		Scanner entrada = new Scanner(System.in);
		int x = entrada.nextInt();
		System.out.println("Introduce otro numero: ");
		int y = entrada.nextInt();
		dosNumeros(x, y);
	}
	
	public static void dosNumeros(int x, int y) {
		if(y < x) {
			int aux = 0;
			aux = x;
			x = y;
			y = aux;
		}
		for(int i = x; i <= y; i++) {
			System.out.println(i + " ");
		}
	}	
}
