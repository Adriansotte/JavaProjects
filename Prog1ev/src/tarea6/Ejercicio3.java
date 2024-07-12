package tarea6;

import java.util.Scanner;

/**
 * Escribe un programa Java que solicite al usuario un entero N y escriba el
 * siguiente patrón por pantalla:
 */
public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		cadena();
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void cadena() {
		System.out.println("Escriba un numero por pantalla:");
		Scanner entrada = new Scanner(System.in);
		int n = entrada.nextInt();
		while(n >= 0) {
			for(int i = 0; i <= n; i++) {
				System.out.print("*");
			} 
			n--;
			System.out.println(" ");
		}
	}
}
