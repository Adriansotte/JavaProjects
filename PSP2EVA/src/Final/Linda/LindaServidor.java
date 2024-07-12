package Final.Linda;

import Final.ConexionLINSER;

import java.io.IOException;
import java.net.Socket;

public class LindaServidor extends ConexionLINSER { //Se hereda de conexión para hacer uso de los sockets y demás
    private LindaCliente lindaCliente;

    public LindaServidor() throws IOException {
        super("servidorLinda");
    }

    public void startServer() {
        try {
            System.out.println("Linda esperando...");
            while (true) {
                Socket socketCliente = ss.accept();
                System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress().getHostAddress());

                LindaCliente lindaCliente = new LindaCliente(socketCliente);
                lindaCliente.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}