package topMusic;

import utiles.Menu;
import utiles.Teclado;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones más
 * escuchadas. El usuario podrá: a. Añadir una canción (en una posición) al
 * TopMusic. b. Sacar un elemento del TopMusic. c. Subir un puesto en el
 * TopMusic. d. Bajar un puesto en el TopMusic. e. Mostrar la lista TopMusic. f.
 * Mostrar la canción más escuchada. Sobre la canción se almacenará el título,
 * artista o grupo y año de grabación
 * 
 * @author Antonio Luque Bravo
 *
 */
public class TestTopMusic {
	static TopMusic topMusic = new TopMusic();
	static Menu menuTopMusic = new Menu("Top Music.",
			new String[] { "Añadir una canción..", "Eliminar canción..", "Subir de puesto una canción..",
					"Bajar de puesto una canción..", "Mostrar Top Music..", "Mostrar la canción más escuchada..",
					"Salir." });

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = menuTopMusic.gestionar();
			switch (opcion) {
			case 1:
				annadirCancion();
				break;
			case 2:
				sacarCancion();
				break;
			case 3:
				subirPuesto();
				break;
			case 4:
				bajarPuesto();
				break;
			case 5:
				System.out.println(topMusic);// Mostrar el top.
				break;
			case 6:
				System.out.println(topMusic.masEscuchada());// Mostrar canción
															// del top más
															// escuchada
				break;
			case 7:
				System.out.println("Adiooooos..");
				break;
			}
		} while (opcion != 7);
	}

	/**
	 * Baja de puesto a una canción en el Top Music.
	 */
	private static void bajarPuesto() {
		System.out.println(
				topMusic.bajarPuesto(new Cancion(pedirAnnoGrabacionCancion("Introduce el nombre de la canción: "))));
	}

	/**
	 * Sube de puesto a una canción en el Top Music.
	 */
	private static void subirPuesto() {
		System.out
				.println(topMusic.subirPuesto(new Cancion(pedirNombreCancion("Introduce el nombre de la canción: "))));
	}

	/**
	 * Elimina una canci&oacute;n del Top Music.
	 */
	private static void sacarCancion() {
		topMusic.eliminarCancion(new Cancion(pedirNombreCancion("Introduce el nombre de la canción: ")));
	}

	/**
	 * A&ntilde;ade una canci&oacute;n al Top Music.
	 */
	private static void annadirCancion() {
		topMusic.annadirCancion(
				new Cancion(pedirNombreCancion("Introduce el nombre de la canción: "),
						pedirArtistaCancion("Introduce el artista o grupo autor: "),
						pedirAnnoGrabacionCancion("Introduce el año de grabación de la canción: ")),
				pedirPosicion("Dame la posición donde se añadirá la canción."));
	}

	/**
	 * Pide la posici&oacute;n donde se introducir&aacute; la cancioacute;n.
	 * 
	 * @param msj
	 *            Mensaje.
	 * @return Devuelve la posici&oacute;n donde se introducir&aacute; la
	 *         canci&oacute;n.
	 */
	private static int pedirPosicion(String msj) {
		int opcion = 0;
		do {
			opcion = Teclado.leerEntero(msj);
		} while (opcion > topMusic.size());
		return opcion;
	}

	/**
	 * Pide por teclado el a&ntilde;o de grabaci&oacute;n de la canci&oacute;n.
	 * 
	 * @param string
	 *            Mensaje que se mostrar&aacute;.
	 * @return Devuelve la pedida por teclado del a&ntilde;o de
	 *         grabaci&oacute;n.
	 */
	private static String pedirAnnoGrabacionCancion(String string) {
		return Teclado.leerCadena(string);
	}

	/**
	 * Pide por teclado el artista o grupo de la canci&oacute;n.
	 * 
	 * @param string
	 *            Mensaje.
	 * @return Devuelve la pedida por teclado.
	 */
	private static String pedirArtistaCancion(String string) {
		return Teclado.leerCadena(string);
	}

	/**
	 * Pide por teclado el nombre que tendr&aacute; la canci&oacute;n.
	 * 
	 * @param string
	 *            Mensaje.
	 * @return Devuelve la pedida por teclado.
	 */
	private static String pedirNombreCancion(String string) {
		return Teclado.leerCadena(string);
	}
}