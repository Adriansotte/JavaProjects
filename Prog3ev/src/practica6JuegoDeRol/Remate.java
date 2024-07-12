package practica6JuegoDeRol;

/**
 * Clase que guarda la informacion del objeto de tipo remate, con su nombre y su daño.
 */
public class Remate {

	private int codRemate;
	private String remate;
	private int daño;

	public Remate(int codRemate, String remate, int daño) {
		this.codRemate = codRemate;
		this.remate = remate;
		this.daño = daño;
	}
	
	public int getCodRemate() {
		return codRemate;
	}
	
	public void setCodRemate(int codRemate) {
		this.codRemate = codRemate;
	}
	
	public String getRemate() {
		return remate;
	}
	
	public void setRemate(String remate) {
		this.remate = remate;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	@Override
	public String toString() {
		return remate + " Daño: " + daño;
	}
}
