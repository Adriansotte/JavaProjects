package tarea4;

public class Ejercicio3 {
	/**
	 *  Escribe un programa Java que te muestre únicamente la suma de los números enteros entre 50 y 100 (ambos incluidos)
	 */

		public static void main(String[] args) {
			/**
			 * Pre: ---
			 * Post:
			 */
			
			suma();
		}
		
		public static void suma() {
			/**
			 * Pre; ---
			 * Post:
			 */
			
			int suma = 0;
			for(int i = 50; i <= 100; i++) {
				suma += i;
			}
			System.out.println(suma);
		}
}
