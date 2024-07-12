package practica7Aeropuerto;

public class Node {
	
	private Pasajero pasajero;
	private Node next;
		
	public Node(Pasajero pasajero) {
		this.pasajero = pasajero;
		this.next = null;
	}
	
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}