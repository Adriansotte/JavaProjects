package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que genere números randoms entre N y M
 * (incluidos). Los valores de N y M son números enteros introducido
 * por el usuario.
 */
public class Ejerciico8 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		random();
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void random() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("El programa seleccionara un numero aleatorio entre dos numeros.");
		System.out.println("Escribe un numero:");
		int n = entrada.nextInt();
		System.out.println("Escribre otro numero:");
		int m = entrada.nextInt();
		if(n < m) {
			for(int i = 0; i < 5; i++) {
				int valorEntero = (int) Math.floor(Math.random()* m  + n );
				System.out.println(valorEntero);
			}
		} else if(m < n) {
			for(int i = 0; i < 5; i++) {
				int valorEntero = (int) Math.floor(Math.random()* n  + m );
				System.out.println(valorEntero);
			}
		}
	}
}
