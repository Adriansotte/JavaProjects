package practica6JuegoDeRol;

/**
 * Clase que representa el objeto de tipo arma con sus atributos de nombre y su daño.
 */
public class Arma {

	private int codArma;
	private String arma;
	private int daño;
	
	public Arma(int codArma, String arma, int daño) {
		this.codArma = codArma;
		this.arma = arma;
		this.daño = daño;
	}
	
	public int getCodArma() {
		return codArma;
	}
	
	public void setCodArma(int codArma) {
		this.codArma = codArma;
	}

	public String getArma() {
		return arma;
	}
	
	public void setArma(String arma) {
		this.arma = arma;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	@Override
	public String toString() {
		return arma + " Daño: " + daño;
	}
}
