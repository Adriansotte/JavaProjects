package nodos;

/**
 * Clase que simula una estructura de datos de una SimpleLinkedList.
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
		Node n = new Node(content, null);
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
	
	public void add(int content, int position) {
		Node n = new Node(content, null);
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
	
	public int verificar(int content) {
		Node comp = new Node(content, null);
		Node p = this.first;
		for(int i = 0; i < size; i++) {
			if(p.getContent() == comp.getContent()) {
				return i;
			}
			p = p.getNext();
		}
		return -1;
	}
	
	public void addComplex(int content) {
		int posicion = verificar(content);
		if(posicion != -1) {
			remove(posicion);
		} 
		add(content);
	}
	
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
			return p.getContent();
		}
	}
	
	public void show() {
		Node p = this.first;
		System.out.println(p);
		for(int i = 0; i < size; i++) {
			System.out.println(p.getContent());
			p = p.getNext();
		}
	}
}
