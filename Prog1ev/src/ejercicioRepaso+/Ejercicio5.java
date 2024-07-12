package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el String: ");
		String cadena1 = entrada.nextLine().toLowerCase();
		String yaComparados = "";
		for(int i = 0; i < cadena1.length(); i++) {
			String caracterAcomparar = cadena1.substring(i, i + 1);
			if(!yaComparados.contains(caracterAcomparar)) {
				int contador = 1;
				for(int j = i + 1; j < cadena1.length(); j++) {
					if(caracterAcomparar.equals(cadena1.substring(j, j + 1))) {
						contador++;
					}
				}
				if(contador > 1) {
					System.out.println("Caracter " + caracterAcomparar + " se " + 
						"repite " + contador + " veces.");
					yaComparados += caracterAcomparar;
				}
			}
				
		}
	}
}
