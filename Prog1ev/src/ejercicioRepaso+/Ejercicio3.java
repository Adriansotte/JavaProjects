package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el primer String: ");
		String cadena1 = entrada.nextLine();
		System.out.print("Dame el segundo String: ");
		String cadena2 = entrada.nextLine();
		if(cadena1.toUpperCase().contains(cadena2.toUpperCase())) {
			System.out.println("Lo contiene");
		} else {
			System.out.println("No lo contiene");
		}
	}
}
