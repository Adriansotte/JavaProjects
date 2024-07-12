package repasoFinal1evaluacion;

import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame un entero: ");
		int num = entrada.nextInt();
		System.out.print("Dame otro entero: ");
		int num2 = entrada.nextInt();
		System.out.println("1º entero: " + num);
		System.out.println("2º entero: " + num2);
		if(num != num2) {
			System.out.println(num + " != " + num2);
			if(num < num2) {
				System.out.println(num + " < " + num2);
			} else {
				System.out.println(num + " > " + num2);
			}
		} else {
			System.out.println(num + " = " + num2);
		}
	}
}
