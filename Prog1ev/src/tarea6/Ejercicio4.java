package tarea6;

/**
 * Escribe un programa Java que muestre el siguiente patrón (hasta 7, tal
 * cual se muestra en el ejemplo). Pista: debes utilizar 3 bucles.
 */
public class Ejercicio4 {

		/**
		 * Pre: ---
		 * Post:
		 */
	public static void main(String[] args) {
		mostrar();
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public static void mostrar() {
		String n ="1234567";
		int cont = 6;
		for(int i = 1; i < 8; i++) {
			String n1 = n.substring(0, i);
			System.out.print(n1);
			String m = "******";
			System.out.println(m.substring(0, cont));
			cont--;
			}
	}
}
