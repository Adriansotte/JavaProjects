package prueba;

import java.util.ArrayList;

public class EjemploArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(9);
		mostrarArrayList(l);
		l.add(0, 20);
		mostrarArrayList(l);
		l.remove(1);
		mostrarArrayList(l);
	}
	
	public static void mostrarArrayList(ArrayList<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		System.out.println(l);
	}
}
