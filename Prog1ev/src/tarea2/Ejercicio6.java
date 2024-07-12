package tarea2;

public class Ejercicio6 {
	/**
	 * Escribe un programa Java que muestre los números impares entre 0 y 100
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post:
		 */
		
		int i = 0;
		System.out.println("Los numeros impares desde el 0 al 100 son:");
		while(i < 100) {
			if(i % 2 != 0) {
				System.out.print(i +" ");	
			}	
			i++;
		}
	}
}

