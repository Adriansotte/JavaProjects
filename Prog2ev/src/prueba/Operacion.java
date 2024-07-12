package prueba;

public class Operacion {
	private int numero1;
	private int numero2;
	private int suma;
	private int resta;
	private int multiplicacion;
	private int division;
	
	public Operacion() {
		this.numero1 = 12;
		this.numero2 = 3;
		this.suma = 15;
		this.resta = 9;
		this.multiplicacion = 36;
		this.division = 4;
	}
	
	public Operacion(int numero1, int numero2, int suma, int resta,
			int multiplicacion, int division) {
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.suma = suma;
		this.resta = resta;
		this.multiplicacion = multiplicacion;
		this.division = division;
	}
	
	public int getNumero1() {
		return numero1;
	}
	
	public int getNumero2() {
		return numero2;
	}
	
	public int getSuma() {
		return suma;
	}
	
	public int getResta() {
		return resta;
	}
	
	public int getMultiplicacion() {
		return multiplicacion;
	}
	
	public int getDivision() {
		return division;
	}
	
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}
	
	
	public void leerNumeros() {
		
	}
}
