package topMusic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones más
 * escuchadas. El usuario podrá: a. Añadir una canción (en una posición) al
 * TopMusic. b. Sacar un elemento del TopMusic. c. Subir un puesto en el
 * TopMusic. d. Bajar un puesto en el TopMusic. e. Mostrar la lista TopMusic. f.
 * Mostrar la canción más escuchada. Sobre la canción se almacenará el título,
 * artista o grupo y año de grabación
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 */
public class TopMusic {
	/**
	 * ArrayList para el almacenamiento de un Top de M&uacute;sica.
	 */
	private ArrayList<Cancion> topMusic;

	/**
	 * Constructor que inicializa el Top Music.
	 */
	TopMusic() {
		topMusic = new ArrayList<Cancion>();
	}

	/**
	 * A&ntilde;ade una canci&oacute;n al Top.
	 * 
	 * @param cancion
	 *            Canci&oacute;n.
	 * @param posicion
	 *            Posici&oacute;n donde se establecer&aacute; la canci&oacute;n.
	 * @return Devuelve un mensaje exitoso.
	 * @throws PosicionNoValidaException
	 *             Cuando la posici&oacute;n no es v&aacute;lida.
	 */
	String annadirCancion(Cancion cancion, int posicion) throws PosicionNoValidaException {
		if (posicion > topMusic.size() || posicion < 0)
			throw new PosicionNoValidaException();
		topMusic.add(posicion, cancion);
		return "La canción se ha añadido con éxito.";
	}

	/**
	 * Elimina una canci&oacute;n del Top.
	 * 
	 * @param cancion
	 *            Canci&oacute;n.
	 * @return Devuelve un mensaje exitoso.
	 * @throws CancionNoExisteException
	 *             Cuando la canci&oacute;n no existe en el top.
	 */
	String eliminarCancion(Cancion cancion) throws CancionNoExisteException {
		if (!topMusic.contains(cancion))
			throw new CancionNoExisteException();
		topMusic.remove(cancion);
		return "La canción se ha eliminado con éxito.";
	}

	/**
	 * Sube de puesto una canci&oacute;n del TopMusic.
	 * 
	 * @param cancion
	 *            Canci&oacute;n.
	 * @return Devuelve un mensaje exitoso, de lo contrario indica un error.
	 * @throws PuestoInvalidoException
	 *             Cuando el puesto de la canci&oacute;n en el top es el maximo.
	 * @throws CancionNoExisteException
	 *             Cuando la canci&oacute;n no existe en el top.
	 * @throws NombreNoValidoException
	 *             Cuando el nombre no es v&aacute;lido.
	 */
	String subirPuesto(Cancion cancion) throws PuestoInvalidoException, CancionNoExisteException {
		if (topMusic.indexOf(cancion) == 0) {
			throw new PuestoInvalidoException();
		} else if (!topMusic.contains(cancion)) {
			throw new CancionNoExisteException();
		}
		Collections.swap(topMusic, topMusic.indexOf(cancion), topMusic.indexOf(cancion) - 1);
		return "La canción ha subido de puesto satisfactoriamente.";
	}

	/**
	 * Baja de puesto a una canci&oacute;n.
	 * 
	 * @param cancion
	 *            Canci&oacte;n.
	 * @return Devuelve un mensaje exitoso.
	 * @throws PuestoInvalidoException
	 *             Cuando el puesto de la canci&oacute;n en el top es el maximo.
	 * @throws CancionNoExisteException
	 *             Cuando la canci&oacute;n no existe en el top.
	 */
	String bajarPuesto(Cancion cancion) throws PuestoInvalidoException, CancionNoExisteException {
		if (topMusic.indexOf(cancion) == topMusic.size() - 1) {
			throw new PuestoInvalidoException();
		} else if (!topMusic.contains(cancion)) {
			throw new CancionNoExisteException();
		}
		Collections.swap(topMusic, topMusic.indexOf(cancion), topMusic.indexOf(cancion) + 1);
		return "La canción ha bajado de puesto satisfactoriamente.";
	}

	/**
	 * Busca una canci&oacute;n en el Top Music.
	 * 
	 * @param cancion
	 *            Canci&aocute;n objetivo.
	 * @return Devuelve la canci&oacute;n encontrada.
	 */
	public Cancion buscarElemento(Cancion cancion) {
		return topMusic.get(topMusic.indexOf(cancion));
	}

	/**
	 * Muestra la canci&oacute;n m&aacute;s escuchada junto a un mensaje.
	 * 
	 * @return Devuelve un mensaje con la canci&oacute;n concatenada.
	 * @throws TopVacioException
	 *             Cuando el top est&aacute; vac&iacute;o.
	 */
	public String masEscuchada() throws TopVacioException {
		if (topMusic.size() == 0) {
			throw new TopVacioException();
		}
		return " La canción mas escuchada es " + topMusic.get(0);
	}

	/**
	 * Muestra el Top Music.
	 */
	@Override
	public String toString() {
		Iterator<Cancion> iterator = topMusic.iterator();
		String cadena = "";
		int i = 1;
		while (iterator.hasNext()) {
			cadena += "Puesto " + (i++) + ": " + iterator.next();
		}
		return cadena;
	}
}
