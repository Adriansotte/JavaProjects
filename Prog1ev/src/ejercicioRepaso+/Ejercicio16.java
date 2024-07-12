package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio16 {
	public static void main(String[] args) {
		int[] tabla = {1, 2, 3, 4, 5, 10, 12, 14, 15, 19, 4, 5, 10, 12};
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dime cuánto tienen que sumar los pares de elementos: ");
		int suma = entrada.nextInt();
		for(int i = 0; i < tabla.length; i++) {
			for(int j = i + 1; j < tabla.length; j++) {
				if(tabla[i] +  tabla[j] == suma) {
					System.out.println("El par {" + tabla[i] + ", " + 
							tabla[j] + "} suma " + suma);
				}
			}
		}
	}
}
