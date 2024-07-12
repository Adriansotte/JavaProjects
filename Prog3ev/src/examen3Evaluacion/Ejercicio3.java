package examen3Evaluacion;

/**
 * Programa de casos de pruebas para comprobar el nodo.
 */
public class Ejercicio3 {

	/**
	 * Pre:---
	 * Post: metodo principal donde se hacen los casos de prueba para el metodo
	 * 		 creado para la llista simple.
	 */
	public static void main(String[] args) {
		SimpleLinkedList lista = new SimpleLinkedList();
		lista.add(1);
		lista.add(3);
		lista.add(4);
		lista.add(7);
		lista.add(1);
		lista.add(2);
		lista.add(6);
		lista.show();
		System.out.println("---------");
		Node numero = lista.deleteMiddle();
		lista.show();
		System.out.println("---------");
		SimpleLinkedList listaB = new SimpleLinkedList();
		listaB.add(1);
		listaB.add(2);
		listaB.add(3);
		listaB.add(4);
		listaB.show();
		System.out.println("---------");
		Node numeroB = listaB.deleteMiddle();
		listaB.show();
		System.out.println("---------");
		SimpleLinkedList listaC = new SimpleLinkedList();
		listaC.add(2);
		listaC.add(1);
		listaC.show();
		System.out.println("---------");
		Node numeroC = listaC.deleteMiddle();
		listaC.show();
	}
}
