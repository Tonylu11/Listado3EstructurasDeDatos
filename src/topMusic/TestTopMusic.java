package topMusic;

import utiles.Menu;
import utiles.Teclado;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones m�s
 * escuchadas. El usuario podr�: a. A�adir una canci�n (en una posici�n) al
 * TopMusic. b. Sacar un elemento del TopMusic. c. Subir un puesto en el
 * TopMusic. d. Bajar un puesto en el TopMusic. e. Mostrar la lista TopMusic. f.
 * Mostrar la canci�n m�s escuchada. Sobre la canci�n se almacenar� el t�tulo,
 * artista o grupo y a�o de grabaci�n
 * 
 * @author Antonio Luque Bravo
 *
 */
public class TestTopMusic {
	static TopMusic topMusic = new TopMusic();

	public static void main(String[] args) {
		int opcion;
		Menu menuTopMusic = new Menu("Top Music.",
				new String[] { "A�adir una canci�n..", "Eliminar canci�n..", "Subir de puesto una canci�n..",
						"Bajar de puesto una canci�n..", "Mostrar Top Music..", "Mostrar la canci�n m�s escuchada..",
						"Salir." });

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
				mostrarMasEscuchada();
				break;
			case 7:
				System.out.println("Adiooooos..");
				break;
			}
		} while (opcion != 7);
	}

	/**
	 * Muestra la canci&oacute;n que est&aacute; en la primera posici&oacute;n
	 * del Top.
	 */
	private static void mostrarMasEscuchada() {
		try {
			System.out.println(topMusic.masEscuchada());
		} catch (TopVacioException e) {
			System.err.println("El Top no contiene ninguna canci�n..");
		} // Mostrar canci�n
			// del top m�s
			// escuchada
	}

	/**
	 * Baja de puesto a una canci�n en el Top Music.
	 */
	private static void bajarPuesto() {
		try {
			System.out.println(
					topMusic.bajarPuesto(new Cancion(pedirNombreCancion("Introduce el nombre de la canci�n: "))));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre de la canci�n no es v�lido..");
		} catch (PuestoInvalidoException e) {
			System.out.println("El puesto de esa canci�n no puede disminuir m�s..");
		} catch (CancionNoExisteException e) {
			System.err.println("La canci�n no existe..");
		}
	}

	/**
	 * Sube de puesto a una canci�n en el Top Music.
	 */
	private static void subirPuesto() {
		try {
			System.out.println(
					topMusic.subirPuesto(new Cancion(pedirNombreCancion("Introduce el nombre de la canci�n: "))));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre de la canci�n no es v�lido..");
		} catch (PuestoInvalidoException e) {
			System.err.println("El puesto de esa canci�n no puede aumentar m�s..");
		} catch (CancionNoExisteException e) {
			System.err.println("La canci�n no existe..");
		}
	}

	/**
	 * Elimina una canci&oacute;n del Top Music.
	 */
	private static void sacarCancion() {
		try {
			System.out.println(
					topMusic.eliminarCancion(new Cancion(pedirNombreCancion("Introduce el nombre de la canci�n: "))));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre de la canci�n no es v�lido..");
		} catch (CancionNoExisteException e) {
			System.err.println("La canci�n no existe..");
		}
	}

	/**
	 * A&ntilde;ade una canci&oacute;n al Top Music.
	 */
	private static void annadirCancion() {
		try {
			System.out.println(topMusic.annadirCancion(
					new Cancion(pedirNombreCancion("Introduce el nombre de la canci�n: "),
							pedirArtistaCancion("Introduce el artista o grupo autor: "),
							pedirAnnoGrabacionCancion("Introduce el a�o de grabaci�n de la canci�n: ")),
					pedirPosicion("Dame la posici�n donde se a�adir� la canci�n.")));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre de la canci�n no es v�lido..");
		} catch (ArtistaNoValidoException e) {
			System.err.println("El artista de la canci�n no es v�lido..");
		} catch (AnnoGrabacionNoValidoException e) {
			System.err.println("El a�o de grabaci�n de la canci�n no es v�lido..");
		} catch (PosicionNoValidaException e) {
			System.err.println("La posici�n de la canci�n no es v�lida..");
		}
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
		return Teclado.leerEntero(msj) - 1;
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