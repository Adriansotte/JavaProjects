package practica7Aeropuerto;

/**
 * Clase que simula la estructura de datos de una SImpleLinkedList.
 */
public class ListaSimple {

	private int size;
	private NodeAvion first;
	
	public ListaSimple() {
		this.size = 0; 
		this.first = null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public NodeAvion getFirst() {
		return this.first;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba el size del objeto, si es mayor que
	 * 		 0 devuelve false, si es igual a cero devuelve true.
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que añade un NodeAvion detras del ultimo NodeAvion
	 * 		 añadido, si es el primero lo añade en la primera posicion. 
	 */
	public void add(NodeAvion n) {
		if(isEmpty()) {
			this.first = n;
		} else {
			NodeAvion p = first;
			for(int i = 0; i < size - 1; i++) {
				p = p.getNext();
			}
			p.setNext(n);
		}
		this.size += 1;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre la lista hasta encontrar el nodo que
	 * 		 contenga el avion que coincida con el numero recibido
	 * 		 como parametro, si lo encuentra lo devuelve, sino devuelve null.
	 */
	public Avion getAvion(int numero) {
		try {
			NodeAvion n = first;
			for(int i = 0; i < size; i++) {
				if(n.getAvion().getNumero() == numero) {
					return n.getAvion();
				} else {
					n = n.getNext();
				}
			}
			return null;
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre toda la listaSimple y enseña por pantalla
	 * 		 el numero del avion y los pasajeros que lleva dentro de el.
	 */
	public void mostrarAviones() {
		NodeAvion n = first;
		for(int i = 0; i < size; i++) {
			System.out.println("-----------------------------------");
			System.out.println(n.getAvion().getNumero());
			n.getAvion().showInfo();
			n = n.getNext();
		}
	}
}