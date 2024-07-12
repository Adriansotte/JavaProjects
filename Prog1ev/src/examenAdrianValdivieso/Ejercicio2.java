package examenAdrianValdivieso;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Viendo el auge de las máquinas de golosinas, el colegio ha decidido invertir en la
 * empresa Sabor Dulce el total del presupuesto anual. Los futuros programadores de 1oH-V se
 * han dado cuenta que el algoritmo que maneja las máquinas está anticuado, y no siempre
 * funciona bien. Por ello, tras unas largas reuniones se ha decidido implementar un nuevo
 * software en Java que gestione la compra de productos en las máquinas. El nuevo algoritmo
 * mostrará el siguiente mensaje hasta que el usuario escriba fin:
 * La máquina contiene un total de 5 productos (inventados por el programador para realizar las
 * pruebas del software diseñado). Estos productos se almacenan en una tabla multidimensional
 * String de 5 columnas y 3 filas. En la primera de ellas, se almacena el identificador del producto.
 * En la segunda el precio en euros (SOLAMENTE PUEDEN VALER 1 O 2 EUROS), y en la
 * tercera fila el nombre completo del producto. Un ejemplo sería el siguiente:
 */
public class Ejercicio2 {
	/**
	 * Pre: ---
	 * Post: metodo principal el cual ejecuta el programa y contiene el corrector
	 * 		 de errores.
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
	 * Post: metodo ejecutor del programa, da las opciones al usuario y crea las variables
	 *       que se enviaran a otros metodos para procesar. Este metodo se esta ejecutando
	 *       constantemente hasta que el usuario lo termine.
	 */
	public static void ejecutor(Scanner entrada) {
		int cartera = 0;
		String[][] tabla = { {"manzana", "patatas", "galletas", "pera", "sal"}, {"2" ,"1" ,"2", "2", "1"}, 
				{"Manzana Golden Verde", "Fritos Matutano", "Galletas Principito", "Peras", "Sal"} };
		while(true) {
			System.out.print("Comando > ");
			String palabra = entrada.nextLine();
			String[] peticion = palabra.split(" ");
			if(peticion[0].equals("insertar")) {
				int moneda = Integer.parseInt(peticion[peticion.length - 1]);
				if(moneda > 0 && moneda < 3) {
					cartera += moneda;
				} else {
					System.out.println("Moneda no reconocida.");
				}
			} else if(peticion[0].equals("retirar")) {
				String eleccion = peticion[peticion.length - 1];
				int gasto = comprar(cartera, eleccion, tabla);
				cartera -= gasto;
			} else if(palabra.equals("fin")) {
				System.out.println("Usted ha salido.");
				break;
			} else {
				System.out.println("Peticion no valida.");
			} System.out.println("Saldo: "+ cartera);
		}
	}
	/**
	 * Pre: ---
	 * Post: metodo que realiza la compra del usuario comparando la eleccion con la tabla,
	 *       devuelve la cantidad a restar de la cartera.
	 */
	public static int comprar(int cartera, String eleccion, String[][] tabla) {
		int producto = 0;
		for(int i = 0; i < tabla[0].length; i++) {
			if(eleccion.equals(tabla[0][i])) {
				producto = Integer.parseInt(tabla[1][i]);
				if(cartera >= producto) {
					cartera -= producto;
					System.out.println("Ha elegido: "+ tabla[0][i]);
					return producto;
				} else {
					System.out.println("Saldo no suficiente.");
				}
			} 
		} System.out.println("Operacion no valida.");
		return 0;
	}
}
