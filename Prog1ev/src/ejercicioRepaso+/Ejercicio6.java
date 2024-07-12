package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el primer String: ");
		String cadena1 = entrada.nextLine().toLowerCase();
		System.out.print("Dame el segundo String: ");
		String cadena2 = entrada.nextLine().toLowerCase();
		if(cadena1.length() == cadena2.length()) {
			boolean rotacion = true;
			for(int i = 0; i < cadena1.length(); i++) {
				if(!cadena1.substring(i, i + 1).equals(cadena2.
						substring(cadena1.length() - i - 1, cadena1.length() - i))) {
					rotacion = false;
					break;
				}
			}
			if(rotacion) {
				System.out.println("Son rotación");
			} else {
				System.out.println("No son rotación.");
			}
		} else {
			System.out.println("No son rotación.");
		}
	}
}
