package actividad2;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Actividad 2.Crear archivo de configuracion.
 * @author Adrian Valdivieso
 */
public class CrearConfiguracion {

	/**
	 * Pre:---
	 * Post: metodo principal el cual crea un archivo de configuracion.
	 */
	public static void main(String[] args) {
		try {
			String user = "Rosana";
			String pass = "Rosana01";
			String server = "SERVER";
			String port = "80";
			// Asignamos las configuraciones
			Properties configuration = new Properties();
			configuration.setProperty("user", user);
			configuration.setProperty("password", pass);
			configuration.setProperty("server", server);
			configuration.setProperty("port", port);
			// Las almacenamos
			configuration.store(new FileOutputStream("configuracion.props"), "Fichero de configuracion");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
