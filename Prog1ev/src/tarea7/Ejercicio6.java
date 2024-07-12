package tarea7;

import java.util.Scanner;

/**
 * Implementa un programa Java con un método llamado
 * insertElement(int[] tabla, int num, int index) que devuelve “tabla”,
 * insertando el valor de “num” en el índice “index” pasado por parámetro.
 * Como ya conocemos, las tablas tienen una longitud máxima que se indica
 * al crearlas. Por lo tanto, para añadir este nuevo elemento deberemos
 * desplazar el resto una posición hacia abajo. Es decir, si queremos
 * 2 almacenar num=2 en index=3, los elementos en la posición desde 3 hasta
 * tabla.length deberán desplazarse para dejar hueco al nuevo elemento.
 */
public class Ejercicio6 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int[] tabla = new int[] {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		System.out.print("Dada la siguiente tabla: ");
		for(int i = 0; i <= 10; i++) {
			if (i < 10) {
				System.out.print(tabla[i] + ", ");
			}
			if(i == 10) {
				System.out.println(tabla[i] + ".");
			} 
		}System.out.println("Introduzca un numero que quiera introducir:");
		int num  = entrada.nextInt();
		System.out.println("Introduzca en que posicion desea colocarlo (0 al 10)");
		int index = entrada.nextInt();
		insertElement( tabla, num, index);
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void insertElement(int[] tabla, int num, int index) {
		for(int i = tabla.length - 1; i > index; i--) {
			tabla[i] = tabla[i - 1];
		}
		tabla[index] = num;
		for(int n = 0; n <= tabla.length; n++) {
			if (n < 10) {
				System.out.print(tabla[n] + ", ");
			}
			if(n == 10) {
				System.out.println(tabla[n] + ".");
			} 
		}
	}
}
