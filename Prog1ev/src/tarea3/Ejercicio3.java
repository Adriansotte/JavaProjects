package tarea3;

import java.util.Scanner;

public class Ejercicio3 {
	/**
	 * Implementa un programa Java que lea números hasta que se teclee uno 
	 * negativo. Al final debe mostrar cuántos números se han introducido.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:
		 * Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		double x = 1;
		int contador = 0;
		System.out.println("Introduce numeros:");
		while(x >= 0) {
			x = entrada.nextDouble();
			if(x < 0) {
				System.out.println("La canti1dad de numeros introducidos es: " + contador);
				break;
			}
			contador++;
		}
	}
}
