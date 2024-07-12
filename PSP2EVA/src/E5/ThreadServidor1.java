package E5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServidor1 extends Thread {

	private DataInputStream in;

	private DataOutputStream out;

	private Socket cs;

	public ShareDataServidor1 baseDeDatos;

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public Socket getCs() {
		return cs;
	}

	public void setCs(Socket cs) {
		this.cs = cs;
	}

	public ShareDataServidor1 getBaseDeDatos() {
		return baseDeDatos;
	}

	public void setBaseDeDatos(ShareDataServidor1 baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}

	public ThreadServidor1(DataInputStream in, DataOutputStream out, Socket cs, ShareDataServidor1 baseDeDatos) {
		this.in = in;
		this.out = out;
		this.cs = cs;
		this.baseDeDatos = baseDeDatos;
	}

	public void run() {
		try {
			while (true) {
				// Mensaje enviado del servidor 1
				out.writeUTF("Dame una orden(Para parar pon FIN):");

				// Mensaje recibido del cliente 2 esta es la orden
				String orden = in.readUTF();
				System.out.println("Mensaje: " + orden);
				// Esta es la orden recibida separada en una tabla
				String[] ordenOrganizada = orden.split(", ");
				// hacer orden
				String[] datos = organizarDatos(ordenOrganizada);

				if (ordenOrganizada[0].equalsIgnoreCase("PN")) {
					añadirNota(datos);
				} else if (ordenOrganizada[0].equalsIgnoreCase("RN")) {
					eliminarNota(datos);
				} else {
					leerNota(datos);
				}
			}
			// cs.close();//Se finaliza la conexión con el cliente
			// Se le envía un mensaje al cliente usando su flujo de salida
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pre:--- Post:
	 */
	public void añadirNota(String[] datos) {
		try {
			boolean aceptada = baseDeDatos.insertarTupla(datos);
			String respuesta = "";
			if (aceptada) {
				respuesta = "Tupla implementada";
			} else {
				respuesta = "La tupla no se ha podido añadir";
			}
			out.writeUTF(respuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pre:--- Post:
	 */
	public void leerNota(String[] datos) {
		try {
			System.out.println("Entra en la lectura");

			String[] tuplaRecibida = baseDeDatos.buscarTupla(datos);
			String respuesta = "";

			// A borrar
			String prueba = gestionarTupla(tuplaRecibida);
			System.out.println(prueba);

			if (tuplaRecibida != null) {
				String tuplaAEnviar = gestionarTupla(tuplaRecibida);
				respuesta = "Se ha encontrado la siguiente tupla: " + tuplaAEnviar;
			} else {
				respuesta = "No se ha encotrado ninguna tupla con esas caracteristicas.";
			}
			out.writeUTF(respuesta);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	/**
	 * Pre:--- Post:
	 */
	public void eliminarNota(String[] datos) {
		try {
			System.out.println("Entra en eliminar tupla");
			String[] ordenEliminada = baseDeDatos.eliminarNota(datos);
			String respuesta = "";
			if (ordenEliminada != null) {
				String tuplaEliminada = gestionarTupla(ordenEliminada);
				respuesta = "Se ha eliminado la tupla: " + tuplaEliminada;
			} else {
				respuesta = "No se ha podido eliminar ninguna tupla.";
			}
			out.writeUTF(respuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pre:--- Post:
	 */
	public String[] organizarDatos(String[] datos) {
		String[] nuevosDatos = new String[datos.length - 1];
		for (int i = 0; i < nuevosDatos.length; i++) {
			nuevosDatos[i] = datos[i + 1];
		}
		return nuevosDatos;
	}

	/**
	 * Pre:--- 
	 * Post:
	 */
	public String gestionarTupla(String[] tupla) {
		if(tupla == null) {
			return "No se ha encontrado la tupla";
		}
		StringBuilder respuesta = new StringBuilder();
		if (tupla.length > 0) {
			respuesta.append(tupla[0]);
			for (int i = 1; i < tupla.length; i++) {
				respuesta.append(",").append(tupla[i]);
			}
		}
		return respuesta.toString();
	}
}
