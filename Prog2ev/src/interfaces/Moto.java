package interfaces;

public class Moto implements Vehiculo{

	private int velocidad;
	private int ruedas;
	private String modelo;
	
	public Moto(int ruedas, String modelo) {
		this.ruedas = ruedas;
		this.modelo = modelo;
		this.velocidad = 0;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String frenar(int cuanto) {
		this.velocidad -= cuanto;
		return "velocidad: " + this.velocidad;
	}

	@Override
	public String acelerar(int cuanto) {
		this.velocidad += cuanto;
		return "velocidad: " + this.velocidad;
	}

}
