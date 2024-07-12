package practica3;

/**
 * Hilo que se encarga de leer y sacar Nodos de la estructura de datos Cola.
 */
public class ThreadEscritor extends Thread{

	private ColaConcurrente cola;
	private int identificador;
	
	public ThreadEscritor(ColaConcurrente cola, int identificador) {
		this.cola = cola;
		this.identificador = identificador;
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * Pre:---
	 * Post: metodo que inserta mensajes den la Cola.
	 */
	public void run() {
		for(int i = 0; i < 8; i++) {
			cola.push(new Nodo("Mensaje Insertado: " + i + " por el Thread: " + identificador));
		}
	}
}
