package practica6JuegoDeRol;

/**
 * Clase que guarda la informacion del objeto de tipo Tipo, con su tipo y su vida.
 */
public class Tipo {

	private int codTipo;
	private String tipo;
	private int vida;
	
	public Tipo(int codTipo, String tipo, int vida) {
		this.codTipo = codTipo;
		this.tipo = tipo;
		this.vida = vida;
	}
	
	public int getCodTipo() {
		return codTipo;
	}
	
	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que reduce la vida segun el parametro enviado.
	 */
	public void reducirVida(int daño) {
		vida += daño;
	}
	
	@Override
	public String toString() {
		return tipo + " Vida: " + vida;
	}
}
