package E5;

public class Prueba {

	public static void main(String[] args) {
		String mensaje = "PN [“Alberto”, “?X”, “?Y”] ";
		String[] mensajeNuevo = mensaje.replaceAll("[“”\"\\[\\]]", "").replaceFirst("([^\\s]+)", "$1,").replace(" ", "")
				.split(",");
		System.out.println(mensajeNuevo);
		System.out.println(mensajeNuevo.length);
		StringBuilder respuesta = new StringBuilder();
		if (mensajeNuevo.length > 0) {
			respuesta.append(mensajeNuevo[0]);
			for (int i = 1; i < mensajeNuevo.length; i++) {
				respuesta.append(",").append(mensajeNuevo[i]);
			}
		}
		System.out.println(respuesta.toString());
	}
}
