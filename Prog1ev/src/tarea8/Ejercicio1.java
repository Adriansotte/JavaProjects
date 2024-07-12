package tarea8;

/**
 * Implementa un método Java llamado calcularModa que
 * calcule la moda de una tabla Java. La moda es el valor con mayor
 * frecuencia que aparece en una colección de datos. Por ejemplo, si
 * tenemos la tabla: {1, 1, 2, 1, 4, 1, 2, 1} la moda es 1.
 */
public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] tabla = new int[] {1, 6, 6, 6, 8, 9, 9, 9, 9, 9};
		System.out.println("Dada la tabla: ");
		for(int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i] + " ");
		}
		calcularModa(tabla);
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void calcularModa(int[] tabla) {
		int moda = 0;
		int anterior = 0;
		for(int i = 0; i < tabla.length; i++) {
			int contador = 0;
			for(int y = 0; y < tabla.length; y++) {
				if(tabla[i] == tabla[y]) {
					contador++;	
				}
			}
			if(contador > anterior) {
				anterior = contador;
				moda = tabla[i];
			}
		}System.out.println("La moda es : " + moda);
	}
}
