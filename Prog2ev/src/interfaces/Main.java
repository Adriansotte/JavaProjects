package interfaces;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		Moto moto1 = new Moto(2, "Yamaha");
		vehiculos.add(moto1);
		Coche coche1 = new Coche("Negro", "Volvo");
		vehiculos.add(coche1);
		System.out.println(coche1.acelerar(2));
		System.out.println(moto1.acelerar(50));
		System.out.println(moto1.frenar(7));
	}
}
