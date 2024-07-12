package tarea2;

public class Ejercicio5 {
	/**
	 * Escribe un programa Java que muestre los números pares entre 0 y 100
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre: ---
		 * Post:
		 */
		
		int i = 0;
		System.out.println("Los numeros pares entre 0 y 100 son:");
		while(i < 100) {
			if(i % 2 == 0) {
				System.out.print(i + ", ");
			}
			i++;
			if(i == 100) {
			System.out.println(100 + ".");
			}
		}
	}
}