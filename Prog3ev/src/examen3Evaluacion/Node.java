package examen3Evaluacion;

public class Node {

	private int contenido;
	private Node next;
	
	public Node(int contenido) {
		this.contenido = contenido;
		this.next = null;
	}

	public int getContenido() {
		return contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
