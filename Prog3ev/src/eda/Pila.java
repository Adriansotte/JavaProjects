package eda;

public class Pila {

	private Nodo primero;
	private int tamaño;
	
	public Pila() {
		this.primero = null;
		this.tamaño = 0;
	}
	
	private boolean estaVacia() {
		if(tamaño > 0) return false;
		else return true;
	}
	
	public boolean push(Nodo n) {
		try {
			if(estaVacia()) {
				this.primero = n;
			} else {
				n.setSiguiente(this.primero);
				this.primero = n;
			}
			this.tamaño += 1;
		} catch(Exception e) {
			return false;
		} 
		return true;
	}
	
	public Nodo pop() {
		if(!estaVacia()) {
			Nodo n = primero;
			this.primero = this.primero.getSiguiente();
			this.tamaño = this.tamaño - 1;
			return n;
		} 
		return null;
	}
	
	public void show() {
		Nodo n = this.primero;
		for(int i = 0; i < this.tamaño; i++) {
			System.out.println(n.getContenido());
			n = n.getSiguiente();
		}
	}
}
