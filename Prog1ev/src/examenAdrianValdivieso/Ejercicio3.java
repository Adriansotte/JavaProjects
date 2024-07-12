package examenAdrianValdivieso;

/**
 * Dada la siguiente tabla multidimensional, la cual almacena el salario mensual
 * de los empleados (cada fila pertenece a un empleado distinto): int
 * salarios[][] = { {700, 900, 1300, 800, 790, 850} , {1000, 950, 1080, 1070,
 * 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000} , {1500, 1950, 1880, 1978,
 * 2200, 2100} }; implementa un método maxFila(int[][] tabla) que devuelve la
 * posición de la fila cuya suma de todos sus datos es mayor.
 */
public class Ejercicio3 {
	/**
	 * Pre: --- 
	 * Post: metodo en el que se presenta la tabla con los salarios y llama al metodo que realizara
	 * 		 la comparacion de salarios.
	 */
	public static void main(String[] args) {
		int salarios[][] = { {700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, 
				{1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100} };
		System.out.println("El indice es : " + maxFila(salarios));
	}
	/**
	 * Pre: ---
	 * Post: metodo que realiza la comparacion de la suma de los sueldos y devuelve el indice
	 *  	 mas alto.
	 */
	public static int maxFila(int[][] tabla) {
		int indiceAlto = 0;
		int masAlto = 0;
		for(int i = 0; i < tabla.length; i++) {
			int suma = 0;
			for(int j = 0; j < tabla[i].length; j++) {
				suma += tabla[i][j];
			} 
			if(suma > masAlto) {
				masAlto = suma;
				indiceAlto = i;
			}
		} return indiceAlto;
	}
}
