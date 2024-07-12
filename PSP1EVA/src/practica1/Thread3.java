package practica1;

/**
 * Thread el cual muestra por pantalla un mensaje cuando es recorrido.
 */
public class Thread3 extends Thread {

	private int veces;
	private int retraso;
	
	public Thread3(int random, int retraso) {
		this.veces = random;
		this.retraso = retraso;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pinta por pantalla el mensaje por pantalla.
	 */
	public void run() {
		for(int i = 1; i <= veces; i++) {
			System.out.println("Soy " + i);
			try {
				Thread.sleep(retraso);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
