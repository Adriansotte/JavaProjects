package tarea1;

public class Ejercicio10 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println(fibonacci(9));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int fibonacci(int n) {
		return fibonacci(n, 0, 0, 1);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	private static int fibonacci(int n, int iteracion, int numero, int nuevo) {
		if(n == iteracion)	return numero;
		else return fibonacci(n, iteracion + 1, nuevo , (numero + nuevo));
	}
}
