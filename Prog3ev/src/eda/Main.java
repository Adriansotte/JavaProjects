package eda;

public class Main {

	public static void main(String[] args) {
		Pila p = new Pila();
		Nodo n = new Nodo(30);
		p.push(n);
		Nodo n2 = new Nodo(40);
		p.push(n2);
		Nodo n3 = new Nodo(-300);
		p.push(n3);
		p.show();
		System.out.println("-------");
		p.pop();
		p.show();
		System.out.println("-------");
		p.pop();
		p.show();
		System.out.println("-------");
		p.pop();
		p.show();
	}
}
