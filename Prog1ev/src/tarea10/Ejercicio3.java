package tarea10;

import java.util.Scanner;

/**
 * Tenemos la siguiente tabla multidimensional:
 * int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
 * Implementa un método Java llamado “modificar” que, dado una tabla
 * multidimensional y un entero positivo, multiplique todos los elementos
 * de dicha tabla por el entero dado. Al finalizar la operación, deberás
 * mostrar el resultado de final de la tabla en el método main.
 */
public class Ejercicio3 {
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] argas) {
		int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		modificar(tabla);
	}
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void modificar(int[][] tabla) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame un numero: ");
		int mult = entrada.nextInt();
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] = tabla[i][j] * mult;
				if(j < tabla[i].length - 1) {
					System.out.print(tabla[i][j] + ", ");
				} else {
					System.out.println(tabla[i][j] + ".");
				}
			}
		}
		
	}
}
