package RepasoFicheros1;

/**
 * 
 */
public class Par {
	
	private String palabra;
	private int ocurrencia;
	
	public Par(String palabra) {
		this.palabra = palabra;
		this.ocurrencia = 0;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getOcurrencia() {
		return ocurrencia;
	}

	public void setOcurrencia(int ocurrencia) {
		this.ocurrencia = ocurrencia;
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public void aumentarOcurrencia() {
		this.ocurrencia += 1;
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public String toString() {
		return "Palabra:  " + getPalabra() + "         ocurrencias: " + getOcurrencia();
	}
	

	
}
