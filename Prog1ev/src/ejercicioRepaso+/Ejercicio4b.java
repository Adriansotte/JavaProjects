package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio4b {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el String: ");
		String cadena1 = entrada.nextLine();
		System.out.println("Eliminamos \"a\" y \"ac\" y queda: " + 
				cadena1.replaceAll("ac", "").replaceAll("a", ""));
	}
}
