package Tarea1;

public class Lavadora  extends Electrodomestico{
	private double carga;

	public Lavadora(double precioBase, String color, String consumoElectrico,
			double peso) {
		super(precioBase, color, consumoElectrico, peso);
		this.carga = carga;
	}
	
	public Lavadora() {
		super();
	}
	
	public Lavadora(int precioBase, int peso) {
		
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
	
}
