package ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Programa que convierte de romano a decimal y viceversa.
 */
public class ConversorRomano {

	private static Map<String, Integer> equivalenciasRomanas;
	private static TreeMap<Integer, String> equivalenciasDecimales;
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se llaman a los conversores.
	 */
	public static void main(String[] args) {
		System.out.println(decToRoman(1999));
		System.out.println(romanToDec("MCMXCIX"));
	}
	
	/**
	 * Pre:---
	 * Post: metodo donde se almacenan las equivalencias romanas.
	 */
	public static void datosRomanos() {
		equivalenciasRomanas = new HashMap<>();	
		equivalenciasRomanas.put("I", 1);
		equivalenciasRomanas.put("V", 5);
		equivalenciasRomanas.put("X", 10);
		equivalenciasRomanas.put("L", 50);
		equivalenciasRomanas.put("C", 100);
		equivalenciasRomanas.put("D", 500);
		equivalenciasRomanas.put("M", 1000);		
	}
	
	/**
	 * Pre:---
	 * Post: metodo donde se almacenan las equivalencias decimales.
	 */
	public static void datosDecimales() {
		equivalenciasDecimales = new TreeMap<>();
		equivalenciasDecimales.put(1, "I");
		equivalenciasDecimales.put(4, "IV");
		equivalenciasDecimales.put(5, "V");
		equivalenciasDecimales.put(9, "IX");
		equivalenciasDecimales.put(10, "X");
		equivalenciasDecimales.put(40, "XL");
		equivalenciasDecimales.put(50, "L");
		equivalenciasDecimales.put(90, "XC");
		equivalenciasDecimales.put(100, "C");
		equivalenciasDecimales.put(400, "CD");
		equivalenciasDecimales.put(500, "D");
		equivalenciasDecimales.put(900, "CM");
		equivalenciasDecimales.put(1000, "M");
	}
	
	/**
	 * Pre:---
	 * Post: metodo donde se convierte de romano a decimal.
	 */
	public static int romanToDec(String n) {
		int[] numero = aDecimal(n);
		int resultado = 0;
		int anterior = numero[0];
		int posterior = 0;
		for(int i = 1; i < numero.length; i++) {
			posterior = numero[i];
			if(anterior < posterior) {
				resultado -= anterior;
			} else {
				resultado += anterior;
			}
			anterior = posterior;
		}
		resultado += anterior;
		return resultado;
	}
	
	/*
	 * Pre:---
	 * Post: metodo donde se  genera una tabla con las equivalencias romanas a decimales.
	 */
	public static int[] aDecimal(String n) {
		datosRomanos();
		int[] numero = new int[n.length()];
		for(int i = 0; i < numero.length; i++) {
			numero[i] = equivalenciasRomanas.get(n.substring(i, i + 1));			
		}
		return numero;
	}
	/**
	 * Pre:---
	 * Post: metodo donde se convierte de decimal a romano.
	 */
	public static String decToRoman(int n) {
		datosDecimales();
		String numero = "";
		while(n > 0) {
			int l = equivalenciasDecimales.floorKey(n);
			String letra = equivalenciasDecimales.get(l);
			n -= l;
			numero += letra;
		}
		return numero;
	}
}
