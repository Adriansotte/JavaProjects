package tarea10;
/**
 * Tenemos la siguiente tabla multidimensional, la cual almacena
 * por cada una de sus filas el salario trimestral de cada uno de los
 * empleados de la empresa:
 * int salarios[][] = { {700, 900, 1300} , {1000, 950, 1080}, {1300, 930, 1200} }
 * A su vez, disponemos también de una tabla empleados, con los nombres
 * de los trabajadores:
 * String empleados[] = {&quot;Javier Marías&quot;, &quot;Antonio Muñoz&quot;, &quot;Isabel Allende&quot;}
 * Implementa un programa Java que muestre por pantalla lo siguiente:
 * Javier Marías -&gt; 700 + 900 + 1300 = 2900€
 * Antonio Muñoz -&gt; 1000 + 950 + 1080 = 3030€
 * Isabel Allende -&gt; 1300 + 930 + 1200 = 3430€
 */
public class ejercicio1 {
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		int salarios[][] = { {700, 900, 1300} , {1000, 950, 1080}, {1300, 930, 1200} };
		String empleados[] = {"Javier María", "Antonio Muñoz", "Isabel Allende"};
		for(int i = 0; i < salarios.length; i++) {
			System.out.print(empleados[i] + "-> ");
			int suma = 0;
			for(int j = 0; j < salarios[i].length; j++) {
				if(j < salarios[i].length) {
				System.out.print(salarios[i][j] + " + " );
				} else {
					System.out.print(salarios[i][j]);
				}
				int sumando = salarios[i][j];
				suma += sumando;
			} System.out.println(" = " + suma + "€.");
		}
	}
}
