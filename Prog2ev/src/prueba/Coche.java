package prueba;

import java.util.ArrayList;

public class Coche {
	private String color;
	private String marca;
	private int km;
	private ArrayList<Pasajero> pasajero;
	
	public Coche(String color, String marca, int km) {
		this.color = color;
		this.marca = marca;
		this.km = km;
	}
	
	public Coche() {
		this.color = "Blanco";
		this.marca = "Audi";
		this.km = (int) Math.floor(Math.random()*(5-0)+0);
		this.pasajero = new ArrayList<>();
	}
	
	public ArrayList<Pasajero> getPasajero() {
		return pasajero;
	}

	public void setPasajero(ArrayList<Pasajero> pasajero) {
		this.pasajero = pasajero;
	}

	public String getColor() {
		return color;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int km() {
		return km;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setKm(int km) {
		this.km = km;
	}
}
