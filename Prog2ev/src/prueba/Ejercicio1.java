package prueba;

import java.util.ArrayList;

public class Ejercicio1 {
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			Coche coche = new Coche();
			for(int j = 0; j < 3; j++) {
				Pasajero pasajero = new Pasajero("Paco");
				coche.getPasajero().add(pasajero);
			}
		}
	}
}
