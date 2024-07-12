package codigoEspecial;

import java.util.InputMismatchException;
import java.util.Scanner;

	public class hola {
		/**
		 * Pre: ---
		 * Post:
		 */
		public static void main(String[] args) {
			Scanner entrada = new Scanner(System.in);
			System.out.println("---DISPENSADORA---");
			try {
				ejecutor(entrada);
			} catch(InputMismatchException e) {
				System.out.println("El dato es erroneo " + e);
			} catch(NumberFormatException e) {
				System.out.println("El dato es erroneo " + e);
			} 
		}
		/**
		 * Pre: ---
		 * Post:
		 */
		public static void ejecutor(Scanner entrada) {
			int cartera = 0;
			menu();
			while(true) {
				System.out.print("Comando > ");
				String eleccion = entrada.nextLine();
				if(eleccion.contains("insertar")) {
					String cantidad = eleccion.substring(eleccion.length()-1, eleccion.length());
					int moneda = Integer.parseInt(cantidad);
					if(moneda >= 0 && moneda < 3) {
						cartera += moneda;
					} else {
						System.out.println("Moneda no reconocida.");
					}
				} else if(eleccion.contains("retirar")) {
					String[] producto = eleccion.split(" ");
					if(producto[producto.length - 1].equals("manzana") && cartera >= 2) {
						System.out.println("Manzana Obtenida");
						cartera -= 2;
					} else if(producto[1].equals("patatas") && cartera >= 1) {
						System.out.println("Patatas Obtenidas");
						cartera -= 1;
					} else if(producto[1].equals("galletas") && cartera >= 2) {
						System.out.println("Galletas Obtenidas");
						cartera -= 2;
					} else if(producto[1].equals("pera") && cartera >= 2) {
						System.out.println("Pera Obtenida");
						cartera -= 2;
					} else if(producto[1].equals("sal") && cartera >= 1) {
						System.out.println("Sal Obtenida");
						cartera -= 1;
					} else {
						System.out.println("Dato erroneo.");
					}
				} else if(eleccion.equals("fin")) {
					break;
				} else {
					System.out.println("Comando no valido");
				} System.out.println("Su cartera: " + cartera);
			} 
		}
		/**
		 * Pre: ---
		 * Post:
		 */
		public static void menu() {
			productos();
			System.out.println("Introduzca 'insertar' y la cantidad que desea ingresar.");
			System.out.println("Introduzca 'retirar' y el codigo del producto.");
			System.out.println("Introduzca 'fin' para finalizar.");
			
		}
		/**
		 * Pre: ---
		 * Post:
		 */
		public static void productos() {
			String[][] tabla = {{"manzana", "patatas", "galletas", "pera", "sal"}, {"2" ,"1" ,"2", "2", "1"}, 
					{"Manzana Golden Verde", "Fritos Matutano", "Galletas Principito", "Peras", "Sal"}};
			for(int i = 0; i < tabla.length; i++) {
				for(int j = 0; j < tabla[i].length; j++) {
					System.out.print("-" + tabla[i][j] + "-");
				} System.out.println("");
			}
		}
	}