package tarea8;

/**
 * Implementa un método Java llamado mayorYmenor, el cual
 * recibe como parámetro una tabla de Strings y muestra por pantalla el
 * String con mayor longitud y el String con menor longitud.
 */
public class Ejercicio5 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		String[] tabla = new String[] { "universidades", "utopia", "doscientos", "awdawdawdwadaw", "cuatromil", "trescientos", "gato", "perros", "palabras"};
		mayorMenor(tabla);
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void mayorMenor(String[] tabla) {
		String mayor = "";
		String menor = "";
		int mayornum = 0;
		int menornum = 100;
		for(int i = 0; i < tabla.length; i++) {
			int cadena = tabla[i].length();
			if(cadena > mayornum) {
				mayornum = cadena;
				mayor = tabla[i];
			} 
			if(cadena < menornum) {
				menornum = cadena;
				menor = tabla[i];
			}
		} 
		System.out.println("el string con mas caracteres de la tabla es : " + mayor);
		System.out.println("el string con menos caracteres de la tabla es : " + menor);
	}
}

