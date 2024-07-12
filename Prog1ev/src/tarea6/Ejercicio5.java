package tarea6;

import java.util.Scanner;

/**
 * Escribe un programa Java que muestre por pantalla las potencias de n^1
 * hasta n^4 de los números desde 1 hasta n, donde n es un número entero
 * escrito por el usuario.
 */
public class Ejercicio5 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		potencias();
	}
	
	/**Pre: ---
	 * Post:
	 */
	public static void potencias() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		int n = entrada.nextInt();
		System.out.println("n      n^2      n^3      n^4");
		for(int i = 1; i <= n; i++) {
			int d = (int)Math.pow(i, 2);
			int t = (int)Math.pow(i, 3);
			int c = (int)Math.pow(i, 4);
			System.out.println(i + "        " + d + "        " + t + "        " + c);
		}
	}
}
