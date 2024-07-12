package interfaces;

public class Coche implements Vehiculo{

	private int velocidad;
	private String color;
	private String modelo;
	private int puertas;
	private int plazas;
	
	public Coche(String color, String modelo) {
		this.color = color;
		this.modelo = modelo;
		this.velocidad = 0;
		this.puertas = 4;
		this.plazas = 0;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	public int getPlazas() {
		return this.plazas;
	}

	@Override
	public String frenar(int cuanto) {
		this.velocidad -= cuanto;
		return "velocidad: " + this.velocidad;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String acelerar(int cuanto) {
		this.velocidad += cuanto;
		return "velocidad: " + this.velocidad;
		// TODO Auto-generated method stub
		
	}
	
}
