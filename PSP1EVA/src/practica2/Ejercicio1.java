package practica2;

import java.util.Random;

/**
 * Considérese el entorno de datos siguientes, preparado para trabajar con matrices de
 * 512^2 datos de tipo float.
 * El ejercicio pide calcular el módulo del vector resultante de multiplicar una matriz por un
 * vector. Para ello, 16 procesos distintos llevan a cabo el cálculo del producto de la
 * matriz por el vector: cada proceso se implementará mediante un thread y realizará el
 * producto parcial de 32 filas. Una vez que todos han acabado, un proceso
 * informador calcula su módulo y lo muestra por la salida estándar. Es preciso llevar
 * a cabo un análisis detallado de los aspectos de sincronización (datos compartidos,
 * posibles interferencias, esperas necesarias, etc.), plantear un diseño de la solución en
 * consecuencia y llevar a cabo una implementación utilizando las esperas activas donde
 * sea necesaria la sincronización. El valor de este ejercicio será el 75 % de la nota total.
 * La entrega de esta parte es obligatoria.
 */
public class Ejercicio1 {
	
	private static float[][] numeros;
	private static float[] vector;
	private static SharedData1 compartido;
	private static Random r;
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual genera una lista de Threads los cuales realizan las
	 * 		 operaciones necesarias para calcular el resultado y almacenarla en una tabla.
	 * 		 Cada Thread recibe como parametro las dos tablas con las que operar mas la tabla
	 * 		 compartida para modificarla y ademas los indices donde deben empezar y terminar.
	 */
	public static void main(String[] args) {
		hacerTablas();
		ThreadMult[] threads = new ThreadMult[16];
		for(int i = 0; i < 16; i++) {
			threads[i]  = new ThreadMult(numeros, vector, i * numeros.length/threads.length, compartido, 
					numeros.length/threads.length + (i * numeros.length/threads.length));
			threads[i].start();
		}
		try {
			for(int i = 0; i < threads.length; i++) {
				threads[i].join();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		enseñarResultado();
	}
	
	/**
	 * Pre:---
	 * Post: metodo que crea las tablas correspondientes y rellena numeros y vector.
	 */
	public static void hacerTablas() {
		r = new Random();
		numeros = new float[512][512];
		vector = new float[512];
		compartido = new SharedData1();;
		for(int i = 0; i < numeros.length; i++) {
			vector[i] = r.nextInt(7);
			for(int j = 0; j < numeros[i].length; j++) {
				numeros[i][j] = r.nextInt(7);
			}
		}	
	}
	
	/**
	 * Pre:---
	 * Post: metodo que calcula la raiz cuadrada de la suma de los cuadrados
	 * 		 del vector resultado.
	 */
	public static void calcularModulo() {
		double resultado = 0;
		for(int i = 0; i < compartido.resultado.length; i++) {
			resultado += Math.pow(compartido.resultado[i], 2) ;
		}
		System.out.println("El modulo del vector resultante es: " + Math.sqrt(resultado));
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra el contenido del resultado final.
	 */
	public static void enseñarResultado() {
		calcularModulo();
		System.out.println("El indice del Thread mas lento es el: " + compartido.idMasLento +
				" con: " + compartido.tMax/1000 + " segundos.");
	}
}