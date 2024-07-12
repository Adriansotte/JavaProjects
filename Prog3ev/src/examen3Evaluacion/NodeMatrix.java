package examen3Evaluacion;

public class NodeMatrix {

	private Generico generico;
	private NodeMatrix next;
	
	public NodeMatrix(Generico generico) {
		this.generico = generico;
		this.next = null;
	}

	public Generico getGenerico() {
		return generico;
	}

	public void setGenerico(Generico generico) {
		this.generico = generico;
	}

	public NodeMatrix getNext() {
		return next;
	}

	public void setNext(NodeMatrix first) {
		this.next = first;
	}
	
}
