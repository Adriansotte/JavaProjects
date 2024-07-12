package Final;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexionServidor {
    // Puertos para la conexión. Deben ser diferentes para evitar conflictos.
//    private final int PUERTO_CLIENTE_LINDA = 1234; // Puerto para que los clientes se conecten a Linda
    public static int PUERTO_LINDA_SERVIDOR = 84; // Puerto para que Linda se conecte al servidor
    private final String HOST = "localhost"; // Host para la conexión
    protected ServerSocket ss; // Socket del servidor
    protected Socket cs; // Socket del cliente

    public ConexionServidor(String tipo) throws IOException { // Constructor
//        if (tipo.equalsIgnoreCase("servidorLinda")) {
//            // LindaServidor escucha en este puerto para aceptar clientes.
//            ss = new ServerSocket(PUERTO_CLIENTE_LINDA);
            if (tipo.equalsIgnoreCase("servidor")) {
                // Servidor escucha en este puerto para aceptar conexiones de Linda.
                ss = new ServerSocket(PUERTO_LINDA_SERVIDOR);
//        } else if (tipo.equalsIgnoreCase("cliente")) {
//            // Cliente se conecta a LindaServidor.
//            cs = new Socket(HOST, PUERTO_CLIENTE_LINDA);
//        } else if (tipo.equalsIgnoreCase("clienteLinda")) {
//            // LindaCliente se conecta al Servidor.
//            cs = new Socket(HOST, PUERTO_LINDA_SERVIDOR);
//        }
            } else if (tipo.equalsIgnoreCase("servidorReplica")) {
                // ServidorReplica se conecta al Servidor.
                cs = new Socket(HOST, PUERTO_LINDA_SERVIDOR);
            }
    }
}
