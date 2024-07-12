package tarea1;

/**
 * 
 * Implementa un programa Java que muestre por pantalla el resultado de las siguientes operaciones:
 * a. -5 + 8 * 6 
 * b. (55+9) % 9 
 * c. 20 + -3*5 / 8
 *
 */
public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post: escribe el resultado de las operaciones: a, b, c. Cada uno en una linea distinta.
	 */
	public static void main(String[] args) {
		int a = -5+(8*6);
		double b = (55+9)%9;
		double c = 20+(-3*5/8);
		System.out.println("a= " + a);
		System.out.println("b= " + b);
		System.out.println("c= " + c);
	}
}
