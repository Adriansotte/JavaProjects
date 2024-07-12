package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el primer String: ");
		String cadena1 = entrada.nextLine();
		System.out.print("Dame el segundo String: ");
		String cadena2 = entrada.nextLine();
		System.out.println("La concatenacion es " + (cadena1 + cadena2));
	}
}
