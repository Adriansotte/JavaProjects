package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el primer String: ");
		String cadena1 = entrada.nextLine();
		System.out.print("Dame el segundo String: ");
		String cadena2 = entrada.nextLine();
		if(cadena1.length() == cadena2.length() &&
			cadena1.toUpperCase().equals(cadena2.toUpperCase())) {
			System.out.println("Son lexicograficamente iguales");
		} else {
			System.out.println("No son lexicograficamente iguales");
		}
	}
}
