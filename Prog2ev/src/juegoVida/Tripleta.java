package juegoVida;

/**
 * Clase que representa la informacion que se recoge de cada tabla de
 * celulas generas, guardando el numero de iteracion, el numero de celulas
 * vivas y el numero ded celulas muertas. 
 */
public class Tripleta {
	
	private int numIteracion;
	private int numCelulasVivas;
	private int numCelulasNuevas;

	public Tripleta(int numIteracion, int numCelulasVivas, int numCelulasNuevas) {
		this.numIteracion = numIteracion;
		this.numCelulasVivas = numCelulasVivas;
		this.numCelulasNuevas = numCelulasNuevas;
	}
	
	public int getNumIteracion() {
		return numIteracion;
	}
	public void setNumIteracion(int numIteracion) {
		this.numIteracion = numIteracion;
	}
	public int getNumCelulasVivas() {
		return numCelulasVivas;
	}
	public void setNumCelulasVivas(int numCelulasVivas) {
		this.numCelulasVivas = numCelulasVivas;
	}
	public int getNumCelulasNuevas() {
		return numCelulasNuevas;
	}
	public void setNumCelulasNuevas(int numCelulasNuevas) {
		this.numCelulasNuevas = numCelulasNuevas;
	}
}
