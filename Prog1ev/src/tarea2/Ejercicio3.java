package tarea2;

public class Ejercicio3 {
	/**
	 * Escribe un programa Java que te muestre únicamente la suma de los números enteros entre 50 y 100 ambos incluidos.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post:
		 */
		
		int i = 50;
		int resultado  = 0;
		while(i <= 100) {
			resultado = resultado + i;
			i++;	
		}
		System.out.println(resultado);
	}
}
