package eda;

public class Nodo {

	private int contenido;
	private Nodo siguiente;
	
	public Nodo(int contenido, Nodo siguiente) {
		this.contenido = contenido;
		this.siguiente = siguiente;
	}
	
	public Nodo(int contenido) {
		this.contenido = contenido;
		this.siguiente = null;
	}

	public int getContenido() {
		return contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	
}
