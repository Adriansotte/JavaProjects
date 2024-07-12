package practica5;

/**
 * Clase que contiene el objeto Acciente y sus atributos correspondientes
 * 	los cuales son contadores de si el accidente ha sido de un hombre, mujer
 * 	o desconocido. 
 */
public class Accidente {

	private String tipo;
	private int hombre;
	private int mujer;
	private int desconocido;
	
	public Accidente(String tipo) {
		this.tipo = tipo;
		this.hombre = 0;
		this.mujer = 0;
		this.desconocido = 0;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHombre() {
		return hombre;
	}

	public void setHombre(int hombre) {
		this.hombre = hombre;
	}

	public int getMujer() {
		return mujer;
	}

	public void setMujer(int mujer) {
		this.mujer = mujer;
	}

	public int getDesconocido() {
		return desconocido;
	}

	public void setDesconocido(int desconocido) {
		this.desconocido = desconocido;
	}

	/**
	 * Pre:---
	 * Post: metodo que al ser llamado aumenta las ocurrencias de los hombres.
	 */
	public void aumentarHombre() {
		this.hombre += 1;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que al ser llamado aumenta las ocurrencias de lass mujeres.
	 */
	public void aumentarMujer() {
		this.mujer += 1;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que al ser llamado aumenta las ocurrencias de los desconocidos.
	 */
	public void aumentarDesconocido() {
		this.desconocido += 1;
	}
	
	@Override
	/**
	 * Pre:---
	 * Post: metodo que sobreescribe al metodo toString y devuelve la informacion
	 * 		 necesaria del objeto.
	 */
	public String toString() {
		return "Tipo accidente: " + tipo + " / Masculino: " + hombre + " / Femenino: " + mujer +
				" / Desconocido: " + desconocido;
	}
}
