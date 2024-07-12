package ejerciciosRepaso;

/**
 * Dado un array de 10 elementos, debes separar sus elementos
 * por la mitad y almacenarlos en dos arrays de 5 elementos
 * cada uno de ellos
 */
public class Ejercicio18 {
	/**
	 * Pre:- --
	 * Post:
	 */
	public static void main(String[] args) {
		int[] tabla = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] tabla1 = new int[5];
		int[] tabla2 = new int[5];
		for(int i = 0; i < tabla.length; i++) {
			if(i < tabla.length/2) {
				tabla1[i] = tabla[i];
			} else {
				tabla2[i - tabla.length/2] = tabla[i];
			}
		} System.out.print("La primera tabla es: ");
		for(int x = 0; x < tabla1.length; x++) {
			System.out.print(tabla1[x] + " ");
		} System.out.println("");
		System.out.print("La segunda tabla es: ");
		for(int x = 0; x < tabla2.length; x++) {
			System.out.print(tabla2[x] + " ");
		}
	}
}
