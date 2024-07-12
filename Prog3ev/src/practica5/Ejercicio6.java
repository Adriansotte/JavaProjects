package practica5;

/**
 * Diseña un método recursivo en Java que elimine todas las vocales de una frase. 
 */
public class Ejercicio6 {

	/**
	 * Pre:---
	 * Post: metodo principal el cual genera un frase la cual sera gestionada
	 * 		 en el metodo al que se llama.
	 */
	public static void main(String[] args) {
		String frase = "Hola me llamo adrian èéaqui iban dos èé "
				+ "á1à2â3ä4a5é6è7ê8ë9e1ì2í3î4ï5i6ò7ó8ö9ô1o2ù3ú4ü5û6u";
		System.out.println("Frase sin modificar: " + frase);
		borrarVocales(frase);
	}
	
	/**
	 * Pre:---
	 * Post: metodo auxiliar el cual genera un indicie y llama a un metodo
	 * 		 recursivo el cual borrara las vocales de la frase enviada por
	 * 		 parametro.
	 */
	public static void borrarVocales(String frase) {
		String vocales = "áàâäaéèêëeìíîïiòóöôoùúüûu";
		borrarVocales(frase, vocales, 0);
	}
	
	/**
	 * Pre:---
	 * Post: metodo recursivo que borra las vocales de la frase enviada como
	 * 	     parametro. y enseña la frase por pantalla.
	 */
	private static void borrarVocales(String frase, String vocales, int i) {
		if(frase.length() == i) {
			System.out.println("Frase modificada: " + frase);
		} else if(vocales.contains(frase.substring(i, i + 1))) {
			frase = frase.replace(frase.substring(i, i + 1), "");
			borrarVocales(frase, vocales, i);
		} else {
			borrarVocales(frase, vocales, i + 1);
		}
	}
}