package tarea1;

public class Ejercicio8 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String numero = "123";
		String[] numeros = numero.split("");
		System.out.println(sumarNumeros(numeros));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int sumarNumeros(String[] numeros) {
		return sumarNumeros(numeros, 0, 0);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	private static int sumarNumeros(String[] numeros, int suma, int i) {
		try {
			return sumarNumeros(numeros, suma + Integer.parseInt(numeros[i]), i + 1);
		} catch(IndexOutOfBoundsException e) {
			return suma;
		}
	}
}
