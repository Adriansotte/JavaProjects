package practica5;

/**
 * Clase que almacena el objeto Pais, el cual contiene el nombre
 * del pais y el numero de ocurrencias que tiene.
 */
public class Pais {

	private String nombre;
	private int ocurrencias;
	
	public Pais(String nombre) {
		this.nombre = nombre;
		this.ocurrencias = 1;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getOcurrencias() {
		return ocurrencias;
	}
	
	public void setOcurrencias(int ocurrencias) {
		this.ocurrencias = ocurrencias;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que al ser llamado aumenta las ocurrencias del objeto.
	 */
	public void aumentarOcurrencias() {
		this.ocurrencias += 1;
	}
	
	@Override
	/**
	 * Pre:---
	 * Post: metodo que sobreescribe al metodo toString y devuelve la informacion
	 * 		 necesaria del objeto.
	 */
	public String toString() {
		return "Pais: " + nombre + " / Ocurrencias: " + ocurrencias;
	}
}
