package tarea1;

import java.util.Scanner;

public class Ejercicio6 {
	/**
	 * Implementa un programa Java que PREGUNTE al usuario por un número
	 * entero (x) y muestre por pantalla su tabla de multiplicar, con el siguiente
	 * formato:
	 * La tabla de multiplicar del número 2 es la siguiente:
	 * 2 x 1 = 2
	 * 2 x 2 = 4
	 */
	
	static public void main(String[] args) {
		
		/**
		 * Pre: --
		 * Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("La tabla de multiplicar del numero ");
		int x = entrada.nextInt();
		System.out.println("es: ");
		int uno = 1 * x;
		int dos = 2 * x;
		int tres = 3 * x;
		int cuatro = 4 * x;
		int cinco = 5 * x;
		int seis = 6 * x;
		int siete = 7 * x;
		int ocho = 8 * x;
		int nueve = 9 * x;
		int diez = 10 * x;
		System.out.println("1. " + "1 * " + x + " = " + uno);
		System.out.println("2. " + "2 * " + x + " = " + dos);
		System.out.println("3. " + "3 * " + x + " = " + tres);
		System.out.println("4. " + "4 * " + x + " = " + cuatro);
		System.out.println("5. " + "5 * " + x + " = " + cinco);
		System.out.println("6. " + "6 * " + x + " = " + seis);
		System.out.println("7. " + "7 * " + x + " = " + siete);
		System.out.println("8. " + "8 * " + x + " = " + ocho);
		System.out.println("9. " + "9 * " + x + " = " + nueve);
		System.out.println("10. " + "1 * " + x + " = " + diez);
	}
}
