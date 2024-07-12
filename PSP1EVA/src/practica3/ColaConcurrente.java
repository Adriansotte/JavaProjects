package practica3;

import java.util.concurrent.Semaphore;

/**
 * La cola es una estructura compartida que tiene una capacidad máxima de 10 mensajes
 * de texto.
 */
public class ColaConcurrente {
	
	public Semaphore lector;
	public Semaphore portero;
	public Semaphore maximo;
	public int size;
	public Nodo first;
	
	public ColaConcurrente() {
		this.size = 0;
		this.first = null;
		lector = new Semaphore(0);
		portero = new Semaphore(1);
		maximo = new Semaphore(10);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Nodo getFirst() {
		return first;
	}

	public void setFirst(Nodo first) {
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
	 * Post: metodo que añade a la ultima posicion un objeto de tipo Node.
	 */
	public boolean push(Nodo n) {
		try {
			maximo.acquire();
			portero.acquire();
			if(isEmpty()) {
				this.first = n;
			} else {
				Nodo p = first;
				for(int i = 0; i < size - 1; i++) {
					p = p.getNext();
				}
				p.setNext(n);
			}
			this.size += 1;
			lector.release();
			portero.release();
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
	public Nodo pop() {
		try {
			lector.acquire();
			portero.acquire();
			Nodo p = this.first;
			this.first = p.getNext();
			this.size -= 1;
			portero.release();
			maximo.release();
			return p;
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
		Nodo n = this.first;
		for(int i = 0; i < this.size; i++) {
			n = n.getNext();
		}
	}
}