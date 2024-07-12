package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Crea una tabla multidimensional (2D) de números enteros y rellénala como te
 * apetezca.  Escribe un método: public static int max(int[][] a) que devuelva
 * el valor más grande del array.  Escribe un método: public static int
 * rowSum(int[][] a, int x) que devuelva la suma de todos los elementos de la
 * fila x  Escribe un método: public static int columnSum(int[][] a, int x) que
 * devuelva la suma de todos los elementos de la columna x  Escribe un método:
 * public static int[] allRowSums(int[][] a) que calcule la suma de todas las
 * filas del array multidimensional, y almacene cada una de las sumas en un
 * nuevo array simple, en el índice que corresponde. Es decir, el nuevo array
 * contendrá en la posición 0, la suma de los elementos de la fila 0 del array
 * multidimensional, y así sucesivamente.  Escribe un método public static
 * boolean isRowMagic(int[][] a) que devuelva true, sí y solo sí, la suma de
 * todas las filas del array multidimensional es la misma.  Escribe un método
 * public static boolean isColumnMagic(int[][] a) que devuelva true, sí y solo
 * sí, la suma de todas las columnas del array multidimensional es la misma.
 */
public class Ejercicio20 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int[][] tabla = new int[5][5];
		for(int i = 0; i < tabla.length; i++) {
			for(int j= 0; j < tabla[i].length; j++) {
				tabla[i][j] = (int) Math.floor(Math.random()*(0-50+1)+50);
				System.out.print(tabla[i][j] + " ");
			} System.out.println(" ");
		} System.out.println("Valor mas grande: " + max(tabla));
		System.out.println("Elige un numero de fila y se sumara sus componentes(0 - 4): ");
		int sumaFila = entrada.nextInt();
		System.out.println(rowSum(tabla, sumaFila));
		System.out.println("Elige un numero de columna y se sumara sus componentes(0 - 4): ");
		int sumaColumna = entrada.nextInt();
		System.out.println(columnSum(tabla, sumaColumna));
		System.out.println("Suma de todos las filas: ");
		int[] tablaSuma = allRowSums(tabla);
		for(int i = 0; i < tablaSuma.length; i++) {
			System.out.print(tablaSuma[i] + " ");
		} System.out.println("");
		System.out.println("Suma de todos las columnas: ");
		int[] tablaSuma2 = allColumnSums(tabla);
		for(int i = 0; i < tablaSuma2.length; i++) {
			System.out.print(tablaSuma2[i] + " ");
		} System.out.println("");
		System.out.println("¿La suma de todas las filas es igual? " + isRowMagic(tabla));
		System.out.println("¿La suma de todas las columnas es igual? " + isColumnMagic(tabla));
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static int max(int[][] a) {
		int max = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0 ; j < a[i].length; j++) {
				if(a[i][j] > max) {
					max = a[i][j];
				}
			}
		} return max;
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static int rowSum(int[][] a, int x) {
		int sumaFil = 0;
		for(int i = 0; i < a.length; i++) {
			sumaFil += a[x][i]; 
		} return sumaFil;
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static int columnSum(int[][] a, int x) {
		int sumaCol = 0;
		for(int i = 0; i < a.length; i++) {
			sumaCol += a[i][x]; 
		} return sumaCol;
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static int[] allRowSums(int[][] a) {
		int[] tabla = new int[5];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				tabla[i] += a[i][j];
			} 
		} return tabla;
	}
	public static int[] allColumnSums(int[][] a) {
		int[] tabla = new int[5];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				tabla[i] += a[j][i];
			} 
		} return tabla;
	}
	/**
	 * Pre:---
	 * Post
	 */
	public static boolean isRowMagic(int[][] a) {
		int sumaTotal = a[0][0] + a[0][1] + a[0][2] + a[0][3] + a[0][4];
		for(int i = 1; i < a.length; i++) {
			int sumaAnterior = 0;
			for(int j = 0; j < a[i].length; j++) {
				sumaAnterior += a[i][j];
			} if(sumaAnterior != sumaTotal) {
				return false;
			}
		} return true;
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static boolean isColumnMagic(int[][] a) {
		int sumaTotal = a[0][0] + a[1][0] + a[2][0] + a[3][0] + a[4][0];
		for(int i = 0; i < a.length; i++) {
			int sumaAnterior = 0;
			for(int j = 0; j < a[i].length; j++) {
				sumaAnterior += a[j][i];
			} if(sumaAnterior != sumaTotal) {
				return false;
			}
		} return true;
	}
}
