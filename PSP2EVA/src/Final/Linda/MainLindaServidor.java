package Final.Linda;

import java.io.IOException;

//Clase principal que hará uso del servidor
public class MainLindaServidor {
    public static void main(String[] args) throws IOException {
        LindaServidor serv = new LindaServidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}