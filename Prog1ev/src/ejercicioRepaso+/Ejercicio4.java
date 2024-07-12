package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el primer String: ");
		String cadena1 = entrada.nextLine();
		System.out.print("Dame el segundo String: ");
		String cadena2 = entrada.nextLine();
		boolean termina = true;
		if(cadena2.length() <= cadena1.length()) {
			int i = 0;
			while(i < cadena2.length()) {
				if(!cadena1.substring(cadena1.length() - 1 - i, 
						cadena1.length() - i).toUpperCase().
						equals(cadena2.substring(cadena2.length() - 1 - i,
						cadena2.length() - i).
						toUpperCase())) {
					termina = false;
					break;
				}
				i++;
			}
			if(termina) {
				System.out.println(cadena1 + " termina con " + cadena2);
			} else {
				System.out.println(cadena1 + " NO termina con " + cadena2);
			}
		} else {
			System.out.println("La primera cadena debe ser de "
					+ "mayor longitud que la segunda");
		}
	} 
}
