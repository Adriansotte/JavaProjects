package ejerciciosRepaso;

/**
 * Escribe un programa Java que muestre por pantalla todos los posibles números
 * de 3 dígitos que se pueden crear con los números 1, 2, 3 y 4. Además, debe
 * devolver la cuenta del número total de posibilidades. 123 124 ... 431 432
 * Número total de números con 3 dígitos es 24
 */
public class Ejercicio8 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] tabla = {1, 2, 3, 4};
		int cont = 0;
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla.length; j++) {
				for(int l = 0; l < tabla.length; l++) {
					System.out.println(tabla[i] + "" + tabla[j] + "" + tabla[j] );
					cont++;
				}
			}
		} System.out.println("Numeros resultantes= "+ cont);
		
	}
}
