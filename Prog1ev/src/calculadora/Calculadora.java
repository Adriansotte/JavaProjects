package calculadora;
import java.util.Scanner;
/**
* Implementa un programa Java que te muestre por pantalla el siguiente menú de acciones:
* ¡Bienvenidos a mi primera calculadora!
* 1.- Sumar
* 2.- Restar
* 3.- Multiplicar
* 4.- Dividir
* 5.- Salir
* El usuario deberá indicarle al programa qué operación es la que desea realizar,
* utilizando el código numérico asignado a cada una de las acciones (1, 2, 3, 4 5),
* y posteriormente deberá indicarle nuevamente al programa que dos números 
* utilizará para dicha operación. Este proceso se repetirá hasta que el usuario
* realice la acción 5 (Salir). Os adjunto en esta tarea un archivo que muestra
* un ejemplo de cómo debería funcionar vuestro programa. Espero que os sirva
* de ayuda ;) Acordaros que os pido que uséis la clase Scanner, nuevos métodos 
* para cada una de las acciones, bucles y condiciones (if, else if y else).
*/
public class Calculadora {
	/**
	 * Pre:---
	 * Post: creo un programa, a modo de calculadora, con el cual el usuario
	 *       pueda realizar operaciones como: sumar, restar, multiplicar, dividir,
	 *       ademas de añadir una quinta opcion la cual hace que la calculadora 
	 *       se apague.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¡Bienvenidos a mi primera calculadora!\n1.sumar");
		System.out.println("1.- Sumar.");
		System.out.println("2.- Restar.");
		System.out.println("3.- Multiplicar.");
		System.out.println("4.- Dividir.");
		System.out.println("5.- Salir.");
		while(true) {
			System.out.println("¿Que accion desea realizar?");
			int x = entrada.nextInt();
			if(x <= 0) {
			System.out.println("Esa opcion no existe.\n");
			} else if(x > 5) {
				System.out.println("Esa opcion no existe.");
			} else if(x == 1) {
				System.out.print("Introduzca el primer numero que desea sumar: ");
				double a = entrada.nextDouble();
				System.out.print("Introduzca el segundo numero que desea sumar: ");
				double b = entrada.nextDouble();
				double suma = suma(a, b);
				System.out.println("La suma de " + a + " + " + b + " es igual a: " + suma + ".");
			} else if(x == 2) {
				System.out.print("Introduzca el primer numero que desea restar: ");
				double a = entrada.nextDouble();
				System.out.print("Introduzca el segundo numero que desea restar: ");
				double b = entrada.nextDouble();
				double resta = resta(a, b);
				System.out.println("La resta de " + a + " - " + b + " es igual a: " + resta + ".");
				resta(a, b);
			} else if(x == 3) {
				System.out.print("Introduzca el primer numero que desea multiplicar: ");
				double a = entrada.nextDouble();
				System.out.print("Introduzca el segundo numero que desea multiplicar: ");
				double b = entrada.nextDouble();
				double multi = multi(a, b);
				System.out.println("La multiplicacion de " + a + " * " + b + " es igual a: " + multi + ".");
				multi(a, b);
			} else if(x == 4) {
				System.out.print("Introduzca el primer numero que desea dividir: ");
				double a = entrada.nextDouble();
				System.out.print("Introduzca el segundo numero que desea dividir: ");
				double b = entrada.nextDouble();
				double divi = divi(a, b);
				System.out.println("La division entre " + a + " / " + b + " es igual a: " + divi + ".");
				divi(a, b);
			} else if(x == 5) {
				salir();
				break;
			}	
		}
	}
	/**
	 * Pre: ---
	 * Post: este metodo recibe como parametros dos numeros
	 *       y muestra por pantalla la suma de ambos.
	 */
	public static double suma(double a, double b) {
		double suma = a + b;
		return suma;
	}
	/**
	 * Pre: ---
	 * Post: este metodo recibe como parametros dos numeros
	 *       y muestra por pantalla la resta de ambos.
	 */
	public static double resta(double a, double b) {
		double resta = a - b;
		return resta;
	}
	/**
	 * Pre:---
	 * Post: este metodo recibe como parametros dos numeros
	 *       y muestra por pantalla la multiplicacion de ambos.
	 */
	public static double multi(double a, double b) {
		double multi = a * b;
		return multi;
	}
	/**
	 * Pre: ---
	 * Post: este metodo recibe como parametros dos numeros
	 *       y muestra por pantalla la division de ambos.
	 */
	public static double divi(double a, double b) {
		double divi = a / b;
		return divi;
	}
	/**
	 * Pre: ---
	 * Post: creo un metodo cuya funcion es terminar con el bucle y
	 *       enseñar por pantalla el mensaje "Usted ha salido".
	 */
	public static void salir() {
		System.out.println("Usted ha salido.");
	}
}
