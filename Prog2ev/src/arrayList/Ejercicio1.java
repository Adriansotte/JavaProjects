package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que contenga una ArrayList de datos String.
 * Almacena en él todos los colores que conozcas y muéstralos por pantalla.
 */
public class Ejercicio1 {
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> color = new ArrayList<String>();
		color.add("Azul");
		color.add("Amarillo");
		color.add("Verde");
		System.out.println(color);
	}
}
