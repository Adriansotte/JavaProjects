package ejerciciosRepaso;

import java.util.Scanner;

public class TomyJerry {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("--- WELCOME TO TOM&JERRY´S GAME! ---");
		ejecutor(entrada);
		
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void ejecutor(Scanner entrada) {
		System.out.println("Selecciona el numero de filas y columnas(1 -10)");
		int numTablero = entrada.nextInt();
		crearTablero(numTablero);
	}
	/**
	 * Pre.---
	 * Post:
	 */
	public static String[] crearTablero(int x) {
		String[][] tabla = new String[x][x];
		return null;
	}
}
