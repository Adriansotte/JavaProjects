package tarea4;

public class Ejercicio5 {
	/**
	 * Escribe un programa Java que muestre los números pares entre 0 y 100
	 */

	public static void main(String[] args) {
		/**
		 * Pre; ---
		 * Post:
		 */
		
		mostrarPares();
	}
	
	public static void mostrarPares() {
		/**
		 * Pre: ---
		 * Post:
		 */
		System.out.println("Los numeros pares entre 0 y 100 son:");
		for(int i = 0; i <= 100; i++) {
			if(i % 2 == 0 && i < 100) {
			System.out.println(i + ", ");
			}else if(i == 100) {
			System.out.println(i + ".");
			}
		}
	}
}
