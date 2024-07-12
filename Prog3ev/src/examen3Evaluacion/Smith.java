package examen3Evaluacion;

/**
 * Clase que representa a Smith, con atributos adicionales ademas de 
 * los heredados de persona.
 */
public class Smith extends Personajes{

	private int infectar;
	
	public Smith(int id, String nombre, int edad, int infectar) {
		super(id, nombre, edad);
		this.infectar = infectar;
	}

	public int getInfectar() {
		return infectar;
	}

	public void setInfectar(int infectar) {
		this.infectar = infectar;
	}	
}
