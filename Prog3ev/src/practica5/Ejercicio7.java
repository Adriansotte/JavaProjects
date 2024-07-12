package practica5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La entrada está compuesta por diferentes casos de prueba. Cada caso
 * comienza con una línea con dos enteros, el número F de filas y el número
 * C de columnas de la matriz (entre 1 y 300). A continuación, aparecen F
 * líneas cada una con C números enteros, que representan los valores de la matriz.
 */
public class Ejercicio7 {
	
	private static Scanner n;
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se recogen todas la matrices a comprobar
	 * 		y luego se comprueba cada elemento de la matriz mediante un bucle.
	 */
	public static void main(String[] args) {
		ArrayList<int[][]> matrices = recogerMatrices();
		for(int i = 0; i < matrices.size(); i++) {
			ArrayList<int[]> columnas = recogerColumnas(matrices.get(i));
			ArrayList<int[]> filas = recogerFilas(matrices.get(i));
			System.out.println(comprobarSilla(matrices.get(i), filas, columnas));			
		}	
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual pide al usuario la informacion necesaria para
	 * 		 hacer las matrices, y las almacena en un ArrayList de matrices, 
	 * 		 la cual devuelve como parametro.
	 */
	public static ArrayList<int[][]> recogerMatrices() {
		n = new Scanner(System.in);
		ArrayList<int[][]> lista = new ArrayList<>();
		while(true) {
			String numeros = n.nextLine();
			String[] numero = numeros.split(" ");
			if(Integer.parseInt(numero[0]) > 300 || Integer.parseInt(numero[0]) <= 0 ||
					Integer.parseInt(numero[1]) <= 0 || Integer.parseInt(numero[1]) > 300) break;
			int[][] matriz = crearCelda(Integer.parseInt(numero[0]), Integer.parseInt(numero[1]));
			lista.add(matriz);
		}
		return lista;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros, una matriz y dos arrayList, uno que 
	 * 		 almacena todas las filas de la matriz y otra que almacena todas las
	 * 		 columnas de la matriz, recorre cada posicion de la matriz y comprueba:
	 * 		 si se trata de un punto de silla, devuelve "SI", sino sigue comprobando,
	 * 		 si recorre todo la matriz y no encuentra un punto de silla devuelve "NO"
	 */
	public static String comprobarSilla(int[][] matriz, ArrayList<int[]> filas, 
			ArrayList<int[]> columnas) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				int[] fila = filas.get(i);
				int[] columna = columnas.get(j);
				int numero = matriz[i][j];
				if(numero == fila[0] && numero == fila[fila.length - 1] && numero == columna[0] &&
						numero == columna[columna.length - 1]) {
					return "SI";
				} else if(numero <= fila[0] && numero >= columna[columna.length - 1]) {
					return "SI";
				} else if(numero <= columna[0] && numero >= fila[fila.length - 1]) {
					return "SI";
				} 
			}
		}
		return "NO";
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una matriz y recoge todas las columnas
	 * 		 en formato int[] lo almacena en un array y lo devuelve como parametro.
	 */
	public static ArrayList<int[]> recogerColumnas(int[][] matriz) {
		ArrayList<int[]> lista = new ArrayList<>();	
		for(int i = 0; i < matriz[0].length; i++) {
			int[] columna = crearColumna(matriz, i);
			ordenar(columna);
			lista.add(columna);
		}
		return lista;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una matriz y recoge todas las filas
	 * 		 en formato int[] lo almacena en un array y lo devuelve como parametro.
	 */
	public static ArrayList<int[]> recogerFilas(int[][] matriz) {
		ArrayList<int[]> lista = new ArrayList<>();	
		for(int i = 0; i < matriz.length; i++) {
			int[] fila = matriz[i];
			ordenar(fila);
			lista.add(fila);
		}
		return lista;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que crea una columna y la devuelve como parametro segun un
	 * 		 indice y una martiz enviada como parametro.
	 */
	public static int[] crearColumna(int[][] matriz, int j) {
		int[] columna = new int[matriz.length];
		for(int i = 0; i < matriz.length; i++) {
			columna[i] = matriz[i][j];
		}
		return columna;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que ordena de mayor a menos las tablas que recibe como parametro.
	 */
	public static void ordenar(int[] n) {
		 for(int i = 0; i < n.length; i++) {
	         for (int j = i + 1; j < n.length; j++) {
	            if(n[i] > n[j]) {
	               int aux = n[i];
	               n[i] = n[j];
	               n[j] = aux;
	            }
	         }
	      }
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual mediante lo introducido por el usuario, crea
	 * 		 matrices y las devuelve como parametro.
	 */
	public static int[][] crearCelda(int f, int c) {
		int[][] celda = new int[f][c]; 
		for(int i = 0; i < celda.length; i++) {
			String fila = n.nextLine().trim();
			String[] numeros = fila.split(" ");
			for(int j = 0; j < numeros.length; j++) {
				celda[i][j] = Integer.parseInt(numeros[j]);
			}
		}
		return celda;
	}
}