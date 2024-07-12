package practica3;

/**
 * Hilo que se encarga de leer y sacar Nodos de la estructura de datos Cola.
 */
public class ThreadLector extends Thread{

	private ColaConcurrente cola;
	private int identificador;
	
	public ThreadLector(ColaConcurrente cola, int identificador) {
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
	 * Post: metodo que lee 5 mensajes de la Cola y muestra el mensaje por pantalla.
	 */
	public void run() {
		for(int i = 0; i < 6; i++) {
			Nodo sacado = cola.pop();
			System.out.println("Se muestra " + sacado.contenido + " con el ThreadLector: " + identificador);
		}
	}
}
