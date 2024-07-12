package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConversorDineroTest {

	@Test
	void testDollar() {
		double resultado = ConversorDinero.dollarToEuro(10.5);
		double esperado = 11.55; 
		System.out.println(resultado);
		System.out.println(esperado);
		assertEquals(esperado, resultado, 0.1); 
	}

	@Test
	void testEuro() {
		double resultado = ConversorDinero.euroToDollar(20.3);
		double esperado = 18.47; 
		System.out.println(resultado);
		System.out.println(esperado);
		assertEquals(esperado, resultado, 0.1); 
	}
}
