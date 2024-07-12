package practica7Aeropuerto;

/**
 * Clase que representa una estructura de datos que solo permite
 * añadir Nodes a la ultima posicion y solo permite quitar Nodes
 * desde la primera posicion.
 */
public class Cola {

	public int size;
	public Node first;
	
	public Cola() {
		this.size = 0;
		this.first = null;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba si la cola esta vacia, si es asi
	 * 		 devuelve true, sino devuelve false.
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
	 * Post: metodo que comprueba si la cola esta llena, si es asi
	 * 		 devuelve true, sino devuelve false.
	 */
	public boolean isFull() {
		if(size == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que añade a la ultima posicion un objeto de tipo Node.
	 */
	public boolean push(Node n) {
		try {
			if(isEmpty()) {
				this.first = n;
			} else {
				Node p = first;
				for(int i = 0; i < size - 1; i++) {
					p = p.getNext();
				}
				p.setNext(n);
			}
			this.size += 1;
			return true;
		} catch(Exception e) {
			System.out.println("Error en la cola en el push");
			return false;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve el primero objeto Node de la cola y lo elimina de ella.
	 */
	public Node pop() {
		try {
			if(!isEmpty()) {
				Node p = this.first;
				this.first = p.getNext();
				this.size -= 1;
				return p;
			} else {
				return null;
			}
		} catch(Exception e) {
			System.out.println("Error en la cola en el pop");
			return null;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que enseña el contenido de todos los objetos Node que
	 * 		 estan dentro de la cola.
	 */
	public void show() {
		Node n = this.first;
		System.out.println("Pasajeros en la cola: ");
		for(int i = 0; i < this.size; i++) {
			System.out.println(n.getPasajero().toString());
			n = n.getNext();
		}
	}
}