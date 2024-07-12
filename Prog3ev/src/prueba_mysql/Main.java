package prueba_mysql;

/**
 * 1. Crea una nueva base de datos, la cual tiene que estar formada por una única tabla 
 * que debe contener al menos 2 columnas, una de ellas de tipo entero y la otra de tipo string.
 * 2. Ejecuta las siguientes consultas sobre dicha tabla: select, insert, update y delete.
 * 3. Muestra por pantalla los resultados de todas las consultas y comprueba que sean correctos.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		PracticaMySQL bbdd = new PracticaMySQL();
		bbdd.readDataBase();
		bbdd.showUsers();
//		bbdd.addUser("Samu", 30);
//		bbdd.addUser("Adrian", 20);
//		bbdd.addUser("Oana", 10);
//		bbdd.showUsers();
//		bbdd.updateUser("Adrian", 100);
//		bbdd.showUsers();
//		bbdd.removeUser("Samu");
//		bbdd.showUsers();
		bbdd.close();
	}
}
