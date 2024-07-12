package practica3;

/**
 * Clase Nodo que sirve para poder llevar a cabo la estructura de la cola.
 */
public class Nodo {

	public String contenido;
	public Nodo next;
	
	public Nodo(String contenido) {
		this.contenido = contenido;
		this.next = null;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
