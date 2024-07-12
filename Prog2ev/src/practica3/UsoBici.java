package practica3;

/**
 * Clase que almacena los datos sobre las estaciones de entrada
 * y de salida sobre los usos que se hacen de Bizi Zaragoza.
 */
public class UsoBici {
	
	private int estacionSalida;
	private int estacionDestino;
	
	public UsoBici(int estacionSalida, int estacionDestino) {
		this.estacionSalida = estacionSalida;
		this.estacionDestino = estacionDestino;
	}

	public int getEstacionSalida() {
		return estacionSalida;
	}
	
	public void setEstacionSalida(int estacionSalida) {
		this.estacionSalida = estacionSalida;
	}
	
	public int getEstacionDestino() {
		return estacionDestino;
	}
	
	public void setEstacionDestino(int estacionDestino) {
		this.estacionDestino = estacionDestino;
	}
	 
	@Override
	public String toString() {
		return "Estacion de entrada: " + this.estacionSalida + " Estacion destino: " + getEstacionDestino();
	}
}
