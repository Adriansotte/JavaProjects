package arrayList;

import java.util.ArrayList;

/**
 * Implementa un programa Java que compare dos ArrayLists de datos String.
 */
public class Ejercicio9 {
	/**Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		ArrayList<String> tabla = new ArrayList<>();
		ArrayList<String> copia = new ArrayList<>();
		tabla.add("hola");
		tabla.add("adios");
		copia.add("hola");
		copia.add("adios");
		if(tabla.size() == copia.size()) {
			comparar(tabla,  copia);
		} else {
			System.out.println("Las tablas no son iguales");
		}
	}
	/**Pre: ---
	 * Post:
	 */
	public static void comparar(ArrayList<String> tabla, ArrayList<String> copia) {
		for(int i = 0; i < tabla.size(); i++) {
			if(!tabla.get(i).equals(copia.get(i))) {
				System.out.println("Las tablas no son iguales.");
				break;
			} else if(i == tabla.size() - 1) {
				System.out.println("Las dos tablas son iguales");
			}
		}
	}
}
