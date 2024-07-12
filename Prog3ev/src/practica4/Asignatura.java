package practica4;

/**
 * Clase que representa una asignatura con sus atributos tales como
 * el codigo de la asignatura, el nombre, el tipo, trimestre, etc.
 * Cuya informacion la obtendremos de un fichero . 
 */
public class Asignatura {

	private int codAsig;
	private String creditos;
	private String trimestre;
	private String tipo;
	private String nombre;
	
	public Asignatura(int codAsig, String creditos, String trimestre, String tipo, String nombre) {
		this.codAsig = codAsig;
		this.creditos = creditos;
		this.trimestre = trimestre;
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public int getCodAsig() {
		return codAsig;
	}

	public void setCodAsig(int codAsig) {
		this.codAsig = codAsig;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve la informacion de la asignatura en formato String
	 */
	@Override
	public String toString() {
		return codAsig + " " + creditos + " " + trimestre + " "  + " " + tipo + " " + nombre;
	}
}