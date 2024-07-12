package examen3Evaluacion;

/**
 * Clase cuya funcion es de una Lista enlazada simple
 */
public class SimpleLinkedList {
 
	private int size;
	private Node first;
	
	public SimpleLinkedList() {
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
	
	public boolean isEmpty() {
		if(this.size == 0) return true;
		return false;
	}
	
	/**
	 * Pre: ---
	 * Post: añade siempre al final de la lista el contenido
	 */
	public void add(int content) {
		Node n = new Node(content);
		if(isEmpty()) {
			this.first = n;
		} else {
			Node p = first;
			for(int i = 0; i < size - 1; i++) {
				p = p.getNext();
			}
			p.setNext(n);
		} 
		size++;
	}
	
	/**
	 * Pre:---
	 * Post: añade un nodo en la posicion seleccionada
	 */
	public void add(int content, int position) {
		Node n = new Node(content);
		if(isEmpty()) {
			this.first = n;
			size++;
		} else if(position < size && position > 0) {
			Node p = first;
			for(int i = 0; i < position - 1; i++) {
				p = p.getNext();
			}
			n.setNext(p.getNext());;
			p.setNext(n);
			size++;
		} else {
			add(content);
		}
	}
	
	/**
	 * Pre:---
	 * Post: verifica si el contenido esta dentro de la estructura,
	 * 		 si es asi devuelve el indice, sino devuelve -1
	 */
	public int verificar(int content) {
		Node comp = new Node(content);
		Node p = this.first;
		for(int i = 0; i < size; i++) {
			if(p.getContenido() == comp.getContenido()) {
				return i;
			}
			p = p.getNext();
		}
		return -1;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que añade un nuevo nodo al final de la lista,
	 * 		 si este esta repetido, lo mueve al final de la lista de modo
	 * 		 que solo haya una.
	 */
	public void addComplex(int content) {
		int posicion = verificar(content);
		if(posicion != -1) {
			remove(posicion);
		} 
		add(content);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que elimina el modo cuya posicion se indica.
	 */
	public void remove(int position) {
		if(position == 0) {
			this.first = this.first.getNext();
		} else {
			Node p = this.first;
			for(int i = 0; i < position - 1; i++) {
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
		}
		size--;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve el dato segun el indice indicado y lo elimina
	 * 		 de la lista.
	 */
	public int get(int position, boolean delete) {
		if(position >= size || position < 0) {
			System.out.println("Indice no encontrado");
			return 0;
		} else {
			Node p = this.first;
			for(int i = 0; i < position; i++) {
				p = p.getNext();
			}
			if(delete) {
				p.setNext(p.getNext().getNext());
			}
			return p.getContenido();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que elimina siempre el elemento que esta a la mitad de 
	 * 		 la lista y devuelve el contenido como parametro.
	 */
	public Node deleteMiddle() {
		Node p = this.first;
		int iteracion = 0;
		for(int i = 0; i < (this.size / 2); i++) {
			p = p.getNext();
			iteracion++;
		}
		remove(iteracion);
		return p;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra el contenido de la lista.
	 */
	public void show() {
		Node p = this.first;
		for(int i = 0; i < size; i++) {
			System.out.print(p.getContenido() + " ");
			p = p.getNext();
		}
	}
}
