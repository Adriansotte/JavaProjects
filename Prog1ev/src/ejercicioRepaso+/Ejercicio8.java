package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame un entero: ");
		int num = entrada.nextInt();
		String binario = Integer.toBinaryString(num);
		System.out.println(binario);
	}
}
