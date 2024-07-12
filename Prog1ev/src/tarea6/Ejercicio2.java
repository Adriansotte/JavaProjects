package tarea6;

/**
 * Escribe un programa Java que muestre los números del 1 al 110, con 11
 * números por línea. El programa deberá escribir por pantalla “Coza” en
 * lugar de los números múltiplos de 3, “Loza” en lugar de los números
 * múltiplos de 5, “Woza” en lugar de los números múltiplos de 7 y
 * “CozaLoza” en lugar de los números múltiplos de 3 y 5. El resultado debe
 * ser similar al siguiente:
 */
public class Ejercicio2 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		multi();
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void multi() {
		int i = 1;
		int y = 10;
		for(int c = 0; c <= 10; c++) {
			while(i <= y) {
				if(i % 3 == 0 && i % 5 == 0) {
					System.out.print("CozaLoza ");
				} else if(i % 3 == 0) {
					System.out.print("Coza ");
				} else if(i % 5 == 0) {
					System.out.print("Loza ");
				} else if(i % 7 == 0) {
					System.out.print("Woza ");
				} else {
					System.out.print(i + " ");
				} i++;
			} y = y + 10;
			System.out.println(" ");
		}
	}
}
