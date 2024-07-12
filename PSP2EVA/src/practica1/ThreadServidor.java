package practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.TreeMap;

/**
 * Clase la cual representa el servidor que gestiona las peticiones del usuario,
 * se encarga de reservar plazas de avion segun el codigo que es pasado por parte
 * del cliente
 */
public class ThreadServidor extends Thread{

	private DataInputStream in;
	
	private DataOutputStream out;
	
	private Socket cs;
	
	public Avion avion;
	
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
	
	public Socket getSocket() {
		return cs;
	}
	
	public void setSocket(Socket cs) {
		this.cs = cs;
	}
	
	public Avion getAvion() {
		return this.avion;
	}
	
	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public ThreadServidor(DataInputStream in, DataOutputStream out, Socket cs, Avion avion) {
		this.in = in;
		this.out = out;
		this.cs = cs;
		this.avion = avion;
	}

	public void run() {
		try {
			out.writeUTF("BIENVENIDO AL SERVICIO");
			String bienvenida = in.readUTF();
			System.out.println("INICIO COMPRA: " + bienvenida);
			while(true) {
				String mensaje = in.readUTF();
				System.out.println("-------------------------------");
				System.out.println("Alquilar Plaza -> " + mensaje);
				System.out.println("-------------------------------");
				
				if(avion.reservarAsiento(mensaje)) {
					out.writeUTF("RESERVADA:" + mensaje);
				} else {
					out.writeUTF("PLAZA OCUPADA:" + avion.mostrarPlazas());
				}
				if(!avion.comprobarPlazas()) {
					out.writeUTF("VUELO COMPLETO.");
					break;
				} else {
					out.writeUTF("AUN QUEDAN PLAZAS EN EL AVION.");
				}
				
			}
			cs.close();//Se finaliza la conexión con el cliente
			//Se le envía un mensaje al cliente usando su flujo de salida
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
