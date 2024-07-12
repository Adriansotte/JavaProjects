package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ThreadCliente extends Thread{

	public Socket cs;

	public ThreadCliente(Socket cs) {
		this.cs = cs;
	}
	
	public Socket getCs() {
		return cs;
	}

	public void setCs(Socket cs) {
		this.cs = cs;
	}

	/**
	 * Pre:---
	 * Post:
	 */
	public void run() {
		 System.out.println("Cliente en línea");
         try {
			DataInputStream in = new DataInputStream(cs.getInputStream());
			DataOutputStream out = new DataOutputStream(cs.getOutputStream());
			out.writeUTF("Petición recibida y aceptada");
            while(true) {
	            String mensaje = in.readUTF();
	            if(mensaje.equalsIgnoreCase("END OF SERVICE")) break;
	            System.out.println("Mensaje recibido -> " + mensaje);
	            //System.out.println("Vocales en: \"" + mensaje + "\" : " + calcularVocales(mensaje));
	            out.writeUTF("Vocales en: \"" + mensaje + "\" : " + calcularVocales(mensaje));
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int calcularVocales(String cadena) {
    	int vocales = 0;
    	for (int x = 0; x < cadena.length(); x++) {
    	    char letraActual = cadena.charAt(x);
    	    if (esVocal(letraActual)) vocales++;
    	}
    	return vocales;
    }
    
    private static boolean esVocal(char letra) {
        return "aeiou".contains(String.valueOf(letra).toLowerCase());
    }
}
