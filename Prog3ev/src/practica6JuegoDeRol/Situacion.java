package practica6JuegoDeRol;

/**
 * Clase que representa una situacion por la que tendra que pasar el jugador,
 * esta tiene dos opciones, dos resultados, dos elecciones y sus respectivos daños.
 */
public class Situacion {

	private String situacion;
	private String eleccion1;
	private String resultado1;
	private int daño1;
	private String eleccion2;
	private String resultado2;
	private int daño2;
	
	public Situacion(String situacion, String eleccion1, String resultado1, int daño1, String eleccion2,
			String resultado2, int daño2) {
		this.situacion = situacion;
		this.eleccion1 = eleccion1;
		this.resultado1 = resultado1;
		this.daño1 = daño1;
		this.eleccion2 = eleccion2;
		this.resultado2 = resultado2;
		this.daño2 = daño2;
	}
	
	public String getSituacion() {
		return situacion;
	}
	
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	
	public String getEleccion1() {
		return eleccion1;
	}
	
	public void setEleccion1(String eleccion1) {
		this.eleccion1 = eleccion1;
	}
	
	public String getResultado1() {
		return resultado1;
	}
	
	public void setResultado1(String resultado1) {
		this.resultado1 = resultado1;
	}
	
	public int getDaño1() {
		return daño1;
	}
	
	public void setDaño1(int daño1) {
		this.daño1 = daño1;
	}
	
	public String getEleccion2() {
		return eleccion2;
	}
	
	public void setEleccion2(String eleccion2) {
		this.eleccion2 = eleccion2;
	}
	
	public String getResultado2() {
		return resultado2;
	}
	
	public void setResultado2(String resultado2) {
		this.resultado2 = resultado2;
	}
	
	public int getDaño2() {
		return daño2;
	}
	
	public void setDaño2(int daño2) {
		this.daño2 = daño2;
	}	
	
	@Override
	public String toString() {
		return situacion + "\n" + eleccion1 + " / " + eleccion2;
	}
}