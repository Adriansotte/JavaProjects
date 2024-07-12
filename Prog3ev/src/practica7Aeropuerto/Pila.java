package practica7Aeropuerto;

/**
 * Clase que representa la estructura de datos llamada Pila
 * Solo permite añadir Nodes al final de la pila y solo permite
 * quitar Nodes de la ultima posicion de la pila. 
 */
public class Pila {

	private Node first;
	private int size;
	
	public Pila() {
		this.first = null;
		this.size = 0;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba si la pila esta vacia, si es asi
	 * 		 devuelve true, sino devuelve false.
	 */
	public boolean isEmpty() {
		if(size > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba si la pila esta llena, si es asi	
	 * 		 devuelve true, sino devuelve false.
	 */
	public boolean isFull() {
		if(size == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que añade un objeto Node al principio de la cola.
	 */
	public boolean push(Node n) {
		try {
			if(isEmpty()) {
				this.first = n;
			} else {
				n.setNext(this.first);
				this.first = n;
			}
			this.size += 1;
			return true;
		} catch(Exception e) {
			System.out.println("Error en la pila en el push");
			return false;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve y elimina de la pila el primer Node.
	 */
	public Node pop() {
		try {
			if(!isEmpty()) {
				Node n = this.first;
				this.first = n.getNext();
				this.size -= 1;
				return n;
			} else {
				return null;
			}
		} catch(Exception e) {
			System.out.println("Error en la pila en el pop");
			return null;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre la pila y muestra el contenido de cada node.
	 */
	public void show() {
		Node n = this.first;
		System.out.println("Pasajeros en la pila: ");
		for(int i = 0; i < this.size; i++) {
			System.out.println(n.getPasajero().toString());
			n = n.getNext();
		}
	}
}