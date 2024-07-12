package ejercicio2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)

//Lista de test que se van a realizar en la Suite
@SuiteClasses({ ConversorDineroTest.class, ConversorRomanoTest.class })

public class AllTests {
		
}
