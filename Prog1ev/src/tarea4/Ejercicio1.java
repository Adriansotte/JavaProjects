package tarea4;

public class Ejercicio1 {
	/**
	 * Escribe un programa Java que te muestre 10 veces el texto: "Los bucles son muy sencillos"
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post:
		 */	
		
		bucles("Los bucles son muy sencillos.");
	}
	
	public static void bucles(String x) {
		/**
		 * Pre:---
		 * Post: muestra por pantalla la frase la frase "Los bucles son muy sencillos".
		 */
		
		for(int i = 0; i < 10; i++) {
			System.out.println(x);
		}
	}
}
