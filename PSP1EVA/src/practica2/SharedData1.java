package practica2;

/**
 * Clase que almacena los datos que van a ser modificados por los
 * diferentes Threads, ademas tiene atributos los cuales seran modificados
 * que explican el indice que mas ha tardado y el tiempo que ha tardado.
 */
public class SharedData1 {

	public float[] resultado;
	public double tMax;
	public int idMasLento;
	
	public SharedData1() {
		this.resultado = new float[512];
		this.tMax = 0;
		this.idMasLento = 0;
	}

	public float[] getResultado() {
		return resultado;
	}

	public void setResultado(float[] resultado) {
		this.resultado = resultado;
	}

	public double getTMax() {
		return tMax;
	}

	public void setTMax(long tMax) {
		this.tMax = tMax;
	}

	public int getIdMasLento() {
		return idMasLento;
	}

	public void setIdMasLento(int idMasLento) {
		this.idMasLento = idMasLento;
	}
}
