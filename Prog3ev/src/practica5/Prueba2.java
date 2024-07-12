package practica5;

import java.util.ArrayList;

public class Prueba2 {

	public static void main(String[] args) {
		ArrayList<Integer> hola = new ArrayList<>();
		hola.add(2);
		System.out.println(hola.indexOf(2));
		System.out.println(hola.indexOf(22));
	}
	
	public static int[] crearColumna(int[][] celda, int x, int j) {
		int[] columna = new int[celda.length];
		for(int i = 0; i < celda.length; i++) {
			columna[i] = celda[i][j];
		}
		System.out.println("hola");
		for(int i = 0; i < columna.length; i++) {
			System.out.print(columna[i] + " - ");
		}
		return columna;
	}
}
