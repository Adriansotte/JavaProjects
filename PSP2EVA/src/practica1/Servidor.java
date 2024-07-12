package practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Clase servidor la cual espera clientes para recibir sus peticiones
 * y realizar los trabajos pertinentes. Esta clase esta habilitada para
 * recibir varios clientes a la vez y gestionar sus peticiones creando Threads. 
 */
public class Servidor extends Conexion {
	
	public Avion avion;
	
    public Servidor() throws IOException {
    	super("servidor");
    }

    public void startServer() {
        try {
        	avion = new Avion();
        	System.out.println("Esperando...");
        	while(true) {
        		cs = ss.accept();
        		DataInputStream in = new DataInputStream(cs.getInputStream());
        		DataOutputStream out = new DataOutputStream(cs.getOutputStream());
        		ThreadServidor nuevo = new ThreadServidor(in, out, cs, avion);
        		nuevo.start();	
        	}
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
