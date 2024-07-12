package tarea1;

public class Ejercicio7 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String numero = "12345";
		String[] numeros = numero.split("");
		invertirNumero(numeros, numeros.length - 1);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void invertirNumero(String[] numeros, int l) {
		if(l == 0) {
			System.out.print(numeros[l]);
		} else {
			System.out.print(numeros[l]);
			invertirNumero(numeros, l - 1);
		}
	}
}
