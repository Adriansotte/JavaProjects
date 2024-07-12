package practica2;

/**
 * Thread que se encarga de calcular el producto entre una matriz y un vector,
 * como solo calcula un tramo de la matriz, se guia por indices que recibe como
 * parametros. Finalmente almacena el resultado en una variable compartida llamada
 * resultado. 
 */
public class ThreadMult extends Thread{

	private float[][] matriz;
	private float[] vector;
	private SharedData1 compartido;
	private int indice;
	private int indiceFinal;
	
	public ThreadMult(float[][] matriz, float[] vector, int indice, SharedData1 compartido, 
			int indiceFinal) {
		this.matriz = matriz;
		this.vector = vector;
		this.indice = indice;
		this.compartido = compartido;
		this.indiceFinal = indiceFinal;
	}
	
	public void run() {
		long primero = System.currentTimeMillis();
		for(int i = indice; i < indiceFinal; i++) {
			for(int j = 0; j < matriz[indice].length; j++) {
				compartido.resultado[i] += matriz[i][j] * vector[j];
			}
		}
		long segundo = System.currentTimeMillis();
		calcularTiempo(segundo-primero);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que compara el tiempo que tarda un thread para realizar la tarea.
	 * 		 Como el thread con indice cero da como resultado una indeterminacion, directamente
	 * 		 se pone a cero.
	 */
	public synchronized void calcularTiempo(long tiempo) {
		if(compartido.tMax < tiempo) {
			compartido.setTMax(tiempo);
			try {
			compartido.setIdMasLento(compartido.resultado.length/indice);
			} catch(ArithmeticException e) {
				compartido.setIdMasLento(0);
			}
		}
	}
}