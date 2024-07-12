package tarea4;

import java.util.Scanner;

public class Ejercicio7 {
	/**
	 * Escribe un programa Java que pregunte al usuario por un número entero
	 * y muestre por pantalla su tabla de multiplicar
	 */
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post
		 */
		System.out.println("Inserte un numero:");
		Scanner entrada = new Scanner(System.in);
		int x = entrada.nextInt();
		tablaNumero(x);
	}
	
	public static void tablaNumero(int x) {
		for(int i = 0; i <= 10; i++) {
			System.out.println(i +". " + i + " * " + x + " = " + x * i);
		}
	}

}
