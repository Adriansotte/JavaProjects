package Final.Linda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LindaCliente extends Thread {
    private Socket socketCliente;
    private Socket socketServidor; // Conexión con el servidor

    public LindaCliente(Socket socket) throws IOException {
        this.socketCliente = socket;
        socketServidor = new Socket("172.16.4.4", 81);
    }

    public void run() {
        try {
            // Streams para comunicarse con el cliente
            DataInputStream clienteIn = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream clienteOut = new DataOutputStream(socketCliente.getOutputStream());

            DataInputStream servidorIn = null;
            DataOutputStream servidorOut = null;

            while (true) {
                String mensajeCliente = null;
                String mensajeServidor = null;
                
                clienteOut.writeUTF("Mandame una orden (Fin para finalizar programa): /n");

                // Verificar si hay mensajes del cliente para enviar al servidor
                // if(clienteIn.available() > 0) {
                    mensajeCliente = clienteIn.readUTF();
                    System.out.println("Mensaje recibido del cliente para el servidor: " + mensajeCliente);
                    String [] mensajeDivido = mensajeCliente.split(",");
                    if(mensajeDivido.length - 1 <= 3) {
                  //      socketServidor = new Socket("172.16.4.4", 81);
                        socketServidor = new Socket("localhost", 81);
                        
                    } else if (mensajeDivido.length - 1 > 5) {
                  //      socketServidor = new Socket("172.16.4.4", 82);
                        socketServidor = new Socket("localhost", 82);
                    } else {
                  //      socketServidor = new Socket("172.16.4.4", 83);
                        socketServidor = new Socket("localhost", 83);
                    }

                    // Streams para comunicarse con el servidor1
                    servidorIn = new DataInputStream(socketServidor.getInputStream());
                    
                    servidorOut = new DataOutputStream(socketServidor.getOutputStream());

                    servidorOut.writeUTF(mensajeCliente);
                //}

//                if(clienteIn != null){
//                    if(clienteIn.available() > 0) {
//                        mensajeCliente = clienteIn.readUTF();
//                        System.out.println("Mensaje recibido del cliente para el servidor: " + mensajeCliente);
//                        servidorOut.writeUTF(mensajeCliente);
//                    }
//                }

                // Verificar si hay mensajes del servidor para enviar al cliente
             //   if(servidorIn != null){
             //       if(servidorIn.available() > 0) {
                        mensajeServidor = servidorIn.readUTF();
                        System.out.println("Mensaje recibido del servidor para el cliente: " + mensajeServidor);
                        clienteOut.writeUTF(mensajeServidor);
             //       }
             //   }

                // Opcional: terminar este hilo si se recibe un mensaje de finalización
             //   if(mensajeCliente != null){
                    if(mensajeCliente.equalsIgnoreCase("FIN")) {
                        break;
                    }
            //    }
            }
        } catch (IOException e) {
            System.out.println("Error en el hilo del servidor: " + e.getMessage());
        } finally {
            try {
                socketCliente.close(); // Asegúrate de cerrar el socket del cliente
                socketServidor.close(); // Asegúrate de cerrar el socket con el servidor
            } catch (IOException e) {
                // Manejar excepciones al cerrar los sockets
                e.printStackTrace();
            }
        }
    }
}