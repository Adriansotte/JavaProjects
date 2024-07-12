package codigoEspecial;

public class numeroRandom {
	/**
	 * me quedo en el ejercicio 8 de la tarea 5. ejemplo en el ejercicio 8 de la
	 * tarea 5. 
	 * En primer lugar, miramos cuántos valores queremos. En nuestro caso
	 * del 1 al 10 son 10 valores, del 1 al 10 ambos incluido. Debemos entonces
	 * multiplicar Math.random() por 10. Si quisieramos valores entre dos números
	 * cualquiera ambos incluídos, por ejemplo, del 5 al 10, la cuenta sería
	 * (maximo-minimimo)+1, es decir, (10-5)+1 = 6, multiplicaríamos por 6. En
	 * nuestro ejemplo del 1 al 10 sería (10-1)+1 = 10.
	 * 
	 * Math.random()*10 // Esto da valores de 0.0 a 10.0, excluido el 10.0 Como
	 * nuestro primer valor es 1, le sumamos 1 al resultado. En el caso de que
	 * quisieramos entre 5 y 10, habría que sumar 5, es decir, el valor mínimo.
	 * 
	 * Math.random()*10 + 1 // Esto da valores del 1.0 al 10.0 excluido el 10.0
	 * Finalmente, para conseguir un entero, quitamos los decimales usando la clase
	 * Math.floor()
	 * 
	 * int valorDado = Math.floor(Math.random()*10+1); En general, para conseguir un
	 * número entero entre M y N con M menor que N y ambos incluídos, debemos usar
	 * esta fórmula
	 * 
	 * int valorEntero = Math.floor(Math.random()*(N-M+1)+M); // Valor entre M y N,
	 * ambos incluidos. Si no queremos un valor entero sino double, la fórmula es
	 * sin el +1
	 * 
	 * double valorAleatorio = Math.random()*(N-M)+M; eso sí, recuerda que el valor
	 * N queda excluido y no saldrá nunca. ejemplos en los ejercicios: 4 de la tarea
	 * 3.
	 */
	/**
	 * En la tarea 5 estan los substrings a partir del 3. Intercambiar orden de
	 * letras en el ejercicio 6.
	 */
	/**
	 * clases en mayuscula datos y metodos en minusculas. solo vamos a ver los
	 * !!!string n= "hola"; string n2= n.string(0,1); se refiere a que n2 va a tomar
	 * el valor de n1 y ese valor va a ser: 0= empieza en la posicion 0 incluyendo
	 * esta y se acaba en la posicion 1 exlcuyendola en el mesnaje, en este caso
	 * seria de hola se quedaria en "h"
	 */
	/**
	 * TAREA 8
	 * Caulcular moda en el ejercicio 1 de la tarea 5
	 * Ejercicio 3 pares impares ceros y demas.
	 * Ejercicio 4 copiar tabla en orden inverso.
	 * Ejercicio 5 muestra por pantalla el string mas alto y el mas bajo
	 */
	/**
	 * TAREA 10 BIDIMENSIONALES
	 * Ejercicio 1 mostrar la suma de los salarios junto a los nombres
	 * Ejercicio 2 ordenar con sort tablas o con normal.
	 * Ejercicio 3 multiplicar una tabla por un entero.
	 * Ejercicio 4sumar variables de distintas tablas.
	 * Ejercicio 5 ordenar nombres alfabeticamente.
	 */
	public static void main(String[] args) {
		int[][] tabla = new int[5][5];
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] = (int) Math.floor(Math.random()*(500-0)+0);
				System.out.print(tabla[i][j] + " ");
			}System.out.println("");
		}
	}
	
	public static void ordenarSimple() {
		int [] t = new int[10];
		for(int i = 0; i < t.length; i++) {
			for(int j = i; j < t.length - 1; j++) {
				if(t[i] > t[j]) {
					int aux = t[i];
					t[i] = t[j];
					t[j] = aux;
				}
			}
		}
	}
	
	public static void ordenarNombresAlfabeticamente() {
		String [] t = {"Alberto", "Adrian", "Ramon"};
		for(int i = 0; i < t.length; i++) {
			for(int j = i; j < t.length; j++) {
				if(t[i].compareTo(t[j]) > 0) {
					String aux = t[i];
					t[i] = t[j];
					t[j] = aux;
				}
			}
		}
	}
}
