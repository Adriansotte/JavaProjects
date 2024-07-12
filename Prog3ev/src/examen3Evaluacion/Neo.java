package examen3Evaluacion;

/**
 * Clase que representa a Neo, con atributos adicionales ademas de 
 * los heredados de persona.
 */
public class Neo extends Personajes{

	private Boolean elegido;
	
	public Neo(int id, String nombre, int edad, boolean elegido) {
		super(id, nombre, edad);
		this.elegido = elegido;
	}

	public Boolean getElegido() {
		return elegido;
	}

	public void setElegido(Boolean elegido) {
		this.elegido = elegido;
	}
}
