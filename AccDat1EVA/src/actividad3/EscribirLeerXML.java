package actividad3;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Actividad 3. Crear una aplicación que cree, escriba y lea un archivo XML.
 * @author Adrian Valdivieso
 */
public class EscribirLeerXML {

	/**
	 * Pre:---
	 * Post: metodo principal el cual llama al metodo que crea el archivo XML,
	 * 		 tras unos segundos lee el archivo creado anteriormente.
	 * @param args
	 */
    public static void main(String[] args) {
        try {
            crearXML();
            Thread.sleep(2000);
            System.out.println("-------------");
            leerXML();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pre:---
     * Post: metodo el cual lee el archivo XML que ha sido creado.
     */
    public static void leerXML() {
        try {
            System.out.println("Leyendo archivo XML");
            File xmlFile = new File("concesionarioGenerador.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            NodeList coches = document.getElementsByTagName("coche");
            for (int i = 0; i < coches.getLength(); i++) {
                Element coche = (Element) coches.item(i);
                String matricula = coche.getElementsByTagName("matricula").item(0).getTextContent();
                String marca = coche.getElementsByTagName("marca").item(0).getTextContent();
                String precio = coche.getElementsByTagName("precio").item(0).getTextContent();
                System.out.println("Matrícula: " + matricula);
                System.out.println("Marca: " + marca);
                System.out.println("Precio: " + precio);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Pre: ---
     * Post: metodo el cual crea un archivo XML
     */
    public static void crearXML() {
        try {
            System.out.println("Creando el archivo XML");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document documento = implementation.createDocument(null, "coches", null);
            documento.setXmlVersion("1.0");
            Element coches = documento.getDocumentElement();
            Element coche1 = crearCoche(documento, "1234ABC", "AUDI", "3000");
            coches.appendChild(coche1);
            Element coche2 = crearCoche(documento, "5678DEF", "PORSCHE", "410000");
            coches.appendChild(coche2);
            Element coche3 = crearCoche(documento, "9012GHI", "MINI", "22000");
            coches.appendChild(coche3);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("concesionarioGenerador.xml"));
            transformer.transform(source, result);
            System.out.println("Archivo creado.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pre:---
     * Post: metodo el cual recibe los datos necesarios para crear un objeto en el documetno que se va a crear.
     * @param documento
     * @param matricula
     * @param marca
     * @param precio
     * @return
     */
    private static Element crearCoche(Document documento, String matricula, String marca, String precio) {
    	Element coche = documento.createElement("coche");
        Element matriculaElemento = documento.createElement("matricula");
        matriculaElemento.appendChild(documento.createTextNode(matricula));
        coche.appendChild(matriculaElemento);
        Element marcaElemento = documento.createElement("marca");
        marcaElemento.appendChild(documento.createTextNode(marca));
        coche.appendChild(marcaElemento);
        Element precioElemento = documento.createElement("precio");
        precioElemento.appendChild(documento.createTextNode(precio));
        coche.appendChild(precioElemento);
        return coche;
    }
}
