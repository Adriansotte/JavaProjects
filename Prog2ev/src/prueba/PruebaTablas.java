package prueba;

import java.util.HashMap;
import java.util.Map;

public class PruebaTablas {
	public static void main(String[] args) {
		String[] info = new String[] {"30201", "6.0", "1", "FB", "Fundamentos", "Administracion", "de", "Empresas"};
		String nombre = "";
		for(int i = 4; i < info.length; i++) {
			nombre += info[i] + " ";
		}
		System.out.println(nombre);
	}
}
