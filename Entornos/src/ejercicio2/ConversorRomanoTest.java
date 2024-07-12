package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class ConversorRomanoTest {
	
	@BeforeClass //Se Ejecuta al principio del conjunto de pruebas, se ejecuta solo 1 vez.
	public static void beforeclass() {
		System.out.println("BeforeClass()");
	}
	
	@Before	//Se ejecuta antes de CADA prueba.
	public void before() {
		System.out.println("Before()");
	}
	
	@After // Se ejecuta despues de CADA prueba.
	public void after() {
		System.out.println("After()");
	}
	
	@Test
	void testDollar() {
		int resultado = ConversorRomano.romanToDec("XXI");
		int esperado = 21; 
		assertEquals(esperado, resultado); 
	}
	
	@Test
	void testEuro() {
		String resultado = ConversorRomano.decToRoman(2016);
		String esperado = "MMXVI"; 
		assertEquals(esperado, resultado); 
	}

	@AfterClass //Se Ejecuta al final del conjunto de pruebas, se ejecuta solo 1 vez.
	public static void afterclass() {
		System.out.println("AfterClass()");
	}
}
