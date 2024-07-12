package practica7Aeropuerto;

public class NodeAvion {

	private Avion avion;
	private NodeAvion next;
	
	public NodeAvion(Avion avion) {
		this.avion = avion;
		this.next = null;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public NodeAvion getNext() {
		return next;
	}

	public void setNext(NodeAvion next) {
		this.next = next;
	}	
}