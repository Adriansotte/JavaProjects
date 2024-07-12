package actividad2;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Actividad 2. Leer archivo de configuracion.
 * @author Adri
 */
public class LeerConfiguracion {
	
	/**
	 * Pre:---
	 * Post: metodo el cual lee las propiedades de un archivo.
	 */
	public static void main(String[] args) {
		Properties configuration = new Properties();
		try {
			configuration.load(new FileInputStream("configuracion.props"));
			String usuario = configuration.getProperty("user");
			String password = configuration.getProperty("password");
			String servidor = configuration.getProperty("server");
			Integer puerto = Integer.valueOf(configuration.getProperty("port"));
			// Mostramos las propiedades por consola.
			System.out.println("El usuario es: " + usuario);
			System.out.println("El password es: " + password);
			System.out.println("El servidor es: " + servidor);
			System.out.println("El password es: " + puerto);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
