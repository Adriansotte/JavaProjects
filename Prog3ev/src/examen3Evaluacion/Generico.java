package examen3Evaluacion;

/**
 * Clase que representa a un personaje generico, heredando los
 * atributos.
 */
public class Generico extends Personajes{

	private int vida;

	public Generico(int id, String nombre, int edad, int vida) {
		super(id, nombre, edad);
		this.vida = vida;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "id: " + id + " nombre: " + nombre + " edad " + edad + " vida " + vida;
	}	
	
}
