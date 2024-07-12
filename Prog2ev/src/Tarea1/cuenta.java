package Tarea1;

public class cuenta {
	private String titular;
	private double cantidad;
	
	public cuenta(String titular) {
		this.titular = titular;
		this.cantidad = 0;
	}
	public cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	public String getTitular() {
		return titular;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Titular: " + titular + " Cantidad: " + cantidad; 
	}
	public void show() {
		System.out.println(toString());
	}
	public void ingresar(double cantidad) {
		if(cantidad >= 0) {
			this.cantidad = this.cantidad + cantidad;
		}
	}
	public void retirar(double cantidad) {
		this.cantidad -= cantidad;
		if(this.cantidad == 0) {
			this.cantidad = 0;
		}
	}
}
