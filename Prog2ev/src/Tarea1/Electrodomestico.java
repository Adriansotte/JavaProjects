package Tarea1;

public class Electrodomestico {
	private double precioBase;
	private String color;
	private String consumoElectrico;
	private double peso;
	
	public Electrodomestico() {
		this.color = "Blanco";
		this.consumoElectrico = "F";
		this.precioBase = 100;
		this.peso = 5;
	}
	
	public Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = "Blanco";
		this.consumoElectrico = "F";
	}
	
	public Electrodomestico(double precioBase, String color,
			String consumoElectrico, double peso) {
		this.precioBase = precioBase;
		this.color = color;
		this.consumoElectrico = consumoElectrico;
		this.peso = peso;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getConsumoElectrico() {
		return consumoElectrico;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setConsumoElectrico(String consumoElectrico) {
		this.consumoElectrico = consumoElectrico;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String comprobarConsumoElectrico(String letra) {
		String[] letras = {"A", "B", "C", "D", "F"};
		for(int i = 0; i < letras.length; i++) {
			if(letra.toUpperCase().equals(letras[i])) {
				return letra;
			} 
		} return "F";
	}
	
	public String comprobarColir(String color) {
		String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
		for(int i = 0; i < colores.length; i++) {
			if(color.toLowerCase().equals(colores[i])) {
				return color;
			}
		} return "Blanco";
	}
	
	public void precioFinal(String consumoElectrico, double peso) {
		double suma = 0;
		String[][] consumoPrecio = {{"a", "b", "c", "d" ,"e" ,"f"}, 
				{"100", "80", "60", "50", "30", "10"}};
		if(peso > 0 && peso < 20) {
			suma += 10;
		} else if(peso >= 20 && peso < 50) {
			suma += 50;
		} else if(peso >= 50 && peso < 80) {
			suma += 80;
		} else suma += 100;
		for(int i = 0; i < consumoPrecio.length; i++) {
			for(int j = 0; j < consumoPrecio[i].length; j++) {
				if(consumoElectrico.toLowerCase().equals(consumoPrecio[j])) {
					suma += Integer.parseInt(consumoPrecio[1][j]);
				}
			}
		} System.out.println(suma);
	}
}
