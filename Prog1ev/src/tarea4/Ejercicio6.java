package tarea4;

public class Ejercicio6 {
	/**
	 * Escribe un programa Java que muestre los números impares entre 0 y 100.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre: ---
		 * Post:
		 */
		numerosImpares();
	}
	
	public static void numerosImpares() {
		/**
		 * Pre: ---
		 * Post
		 */
		
		System.out.println("Los numeros impares del 1 al 100 son:");
		for(int i = 0; i < 100; i++) {
			if(i % 2 == 0) {
				i++;
			}
			if(i % 2 == 1 && i != 99) {
				System.out.println(i +", ");
			}
			if(i == 99) {
				System.out.println(i + ".");
			}
		}
	}
}
