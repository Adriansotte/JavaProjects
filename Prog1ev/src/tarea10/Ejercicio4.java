package tarea10;

/**
 * Tenemos la siguiente tabla multidimensional, la cual almacena por cada una de
 * sus filas el número de kilogramos vendidos de peras y manzanas en una
 * frutería:
 * int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
 * A su vez, disponemos también de una tabla alimentos, con los nombres de las
 * dos frutas de temporada que estamos vendiendo: String frutas[] =
 * {&quot;Pera&quot;, &quot;Manzana&quot;} Y una tabla con los precios de ambos
 * alimentos: int precios[] = {6, 7};
 * Implementa un programa Java que te muestre la suma total de los kilogramos
 * vendidos de cada uno de los alimentos, y al final muestre las ganancias
 * obtenidas gracias a las ventas de cada uno de ellos. El resultado debe ser el
 * siguiente:
 */
public class Ejercicio4 {
	/**
	 * Pre:
	 * Post:
	 */
	public static void main(String[] args) {
		int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
		String frutas[] = {"Pera", "Manzana"};
		int precios[] = {6, 7};
		mostrarDatos(kilos, frutas, precios);
	}
	/**
	 * Pre:--
	 * Post:
	 */
	public static void mostrarDatos( int[][] kilos, String[] frutas, int[] precios) {
		for(int i = 0; i < kilos.length; i++) {
			System.out.print(frutas[i] + "-> ");
			int suma = 0;
			for(int j = 0; j < kilos[i].length; j++) {
				suma += kilos[i][j];
			} System.out.println(suma + " kg " + "x " + precios[i] + " = " + (precios[i] * suma) + "€.");
		}
	}
}
