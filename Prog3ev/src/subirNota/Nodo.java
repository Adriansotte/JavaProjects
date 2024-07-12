package subirNota;

public class Nodo {

	private Personaje content;
	private Nodo next;
	
	public Nodo(Personaje content) {
		this.content = content;
		this.next = null;
	}

	public Personaje getContent() {
		return content;
	}

	public void setContent(Campeon content) {
		this.content = content;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
