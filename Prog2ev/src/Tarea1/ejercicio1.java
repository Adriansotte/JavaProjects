package Tarea1;

public class ejercicio1 {
	public static void main(String[] args) {
		cuenta a = new cuenta("Adrian", 10);
		cuenta b = new cuenta("Santi");
		System.out.println(a);
		b.show();
		a.ingresar(300);
		b.ingresar(500);
		a.show();
		b.show();
	}
}
