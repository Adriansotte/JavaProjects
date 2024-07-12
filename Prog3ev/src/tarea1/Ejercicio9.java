package tarea1;

public class Ejercicio9 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String[][] numeros = {{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4"}, {"5"}};
		System.out.println(sumarNumeros(numeros));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int sumarNumeros(String[][] numeros) {
		return sumarNumeros(numeros, 0, 0, 0);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	private static int sumarNumeros(String[][] numeros, int suma, int i, int j) {
		try {
			return sumarNumeros(numeros, suma + Integer.parseInt(numeros[j][i]), i + 1, j);
		} catch(IndexOutOfBoundsException e) {
			if(j < numeros.length) return sumarNumeros(numeros, suma + Integer.parseInt(numeros[j][i]), 0, j + 1);
			else return suma;
		} 
	}
}