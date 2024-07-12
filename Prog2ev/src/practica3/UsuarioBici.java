package practica3;

/**
 * Clase que almacena la informacion sobre los usuarios y los usos
 * que han hecho en forma de atributos. 
 */
public class UsuarioBici {
	
	private String usuario;
	private int circulares;
	private int traslados;
	
	public UsuarioBici(String usuario) {
		this.usuario = usuario;
		this.circulares = 0;
		this.traslados = 0;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public int getCirculares() {
		return circulares;
	}

	public void setCirculares(int circulares) {
		this.circulares = circulares;
	}

	public int getTraslados() {
		return traslados;
	}

	public void setTraslados(int traslados) {
		this.traslados = traslados;
	}

	/**
	 * Pre:---
	 * Post: metodo que sirve para aumentar en 1 el atributo de circular
	 */
	public void aumentarCirculares() {
		this.circulares += 1;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que sirve para aumentar en 1 el atributo de traslado
	 */
	public void aumentarTraslados() {
		this.traslados += 1;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que sirve para sumar el atributo de circular y traslado
	 * 		 para conseguir las totales.
	 */
	public int calcularTotal() {
		return this.circulares + this.traslados;
	}
	
	@Override
	public String toString() {
		return " " + getUsuario() + "        " +  getTraslados() + "          " + getCirculares() + 
				"            " + calcularTotal();
	}
}
