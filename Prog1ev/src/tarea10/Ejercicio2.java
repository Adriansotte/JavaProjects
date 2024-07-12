package tarea10;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Utilizando las mismas tablas del ejercicio anterior,
 * implementa un programa Java que ordene los salarios de cada uno de los
 * empleados de mayor a menor, y los muestre ordenados por pantalla de la
 * siguiente forma:
 * Javier Marías -&gt; 700 / 900 / 1300
 * Antonio Muñoz -&gt; 950 / 1000 / 1080
 * Isabel Allende -&gt; 930 / 1200 / 1300
 */
public class Ejercicio2 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int salarios[][] = { {700, 900, 1300} , {1000, 950, 1080}, {1300, 930, 1200} };
		String empleados[] = {"Javier María", "Antonio Muñoz", "Isabel Allende"};
		ordenarTabla(salarios, empleados);
	
	}
	public static void ordenarTabla(int[][] salarios, String[] empleados) {
		for(int x = 0; x < salarios.length; x++) {
			System.out.print(empleados[x] + ".- ");
			Arrays.sort(salarios[x]);
			for(int y = 0; y < salarios[x].length; y++) {
				if(y < salarios[x].length - 1) {
					System.out.print(salarios[x][y] + " / ");
				} else {
					System.out.println(salarios[x][y] + ".");
				}
			}
		}
	}
}
