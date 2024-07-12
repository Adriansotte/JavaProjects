package ejercicios;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Anotación de Junit para utilizar valores parametrizados
@RunWith(value = Parameterized.class)

public class Ejercicio1Test {

	//Anotación de Junit para indicar cuales son los valores de las variables parametrizadas.
	@Parameters
	public static Iterable<Object[]> getData() {
		return Arrays.asList(new Object[][]{
			{-5, 23},{0, 32},{15, 59}});
	}
			
	private double a;
	//Variables para guardar los parámetros que se iran introduciendo en las incógnitas de la prueba
	private double exp;
	public Ejercicio1Test(double a, double exp) {
		this.a = a;
		this.exp = exp;		
	}
	
	//Prueba que se va a realizar varias veces utilizando parámetros.
	//Esta prueba tiene 3 incógnitas: a, b, exp (expected)
	
	public void testAdd() {
		Ejercicio1 test= new Ejercicio1();
		double resul = test.celsiustofahrenheit(a); //Resultado
		//Assert de Comparación
		assertEquals(resul, this.exp, 1);
	}

}
