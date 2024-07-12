package nodos;

public class Main {
	public static void main(String[] args) {
		SimpleLinkedList l = new SimpleLinkedList();
		System.out.println(l.getSize());
		l.add(30);
		System.out.println(l.getSize());
		l.add(40);
		System.out.println(l.getSize());
		l.add(50);
		System.out.println(l.getSize());
		l.show();
		l.add(50);
		System.out.println("-------");
		l.add(34, -10);
		l.show();
		System.out.println("----------");
//		System.out.println(l.get(0));
//		System.out.println(l.get(1));
//		System.out.println(l.get(2));
		l.get(0, false);
		l.addComplex(40);
		l.show();
	}
}
