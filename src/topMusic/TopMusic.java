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
	ArrayList<Cancion> topMusic;

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
	 */
	String annadirCancion(Cancion cancion, int posicion) {
		topMusic.add(posicion, cancion);
		return "La canción se ha añadido con éxito.";
	}

	/**
	 * Elimina una canci&oacute;n del Top.
	 * 
	 * @param cancion
	 *            Canci&oacute;n.
	 * @return Devuelve un mensaje exitoso.
	 */
	String eliminarCancion(Cancion cancion) {
		topMusic.remove(cancion);
		return "La canción se ha eliminado con éxito.";
	}

	/**
	 * Sube de puesto una canci&oacute;n del TopMusic.
	 * 
	 * @param cancion
	 *            Canci&oacute;n.
	 * @return Devuelve un mensaje exitoso, de lo contrario indica un error.
	 */
	String subirPuesto(Cancion cancion) {
		if (topMusic.indexOf(cancion) == 0 || !topMusic.contains(cancion)) {
			return "La canción no puede subir más de posición o no existe.";
		}
		Collections.swap(topMusic, topMusic.indexOf(cancion), topMusic.indexOf(cancion) - 1);
		return "La canción ha subido de puesto satisfactoriamente.";
	}

	/**
	 * Baja de puesto a una canci&oacute;n.
	 * 
	 * @param cancion
	 *            Canci&oacte;n.
	 * @return Devuelve un mensaje exitoso, de lo contrario indicar&aacute; un
	 *         error.
	 */
	String bajarPuesto(Cancion cancion) {
		if (topMusic.indexOf(cancion) == topMusic.size() - 1 || !topMusic.contains(cancion)) {
			return "La canción no puede bajar más de posición o no existe.";
		}
		Collections.swap(topMusic, topMusic.indexOf(cancion), topMusic.indexOf(cancion) + 1);
		return "La canción ha bajado de puesto satisfactoriamente.";
	}

	/**
	 * Muestra el Top Music.
	 * 
	 * @return Devuelve una cadena concatenada mostrando con un iterador todo el
	 *         Top Music.
	 */
	String mostrarTopMusic() {
		Iterator<Cancion> iterator = topMusic.iterator();
		String cadena = "";
		int i = 1;
		while (iterator.hasNext()) {
			cadena += "Puesto " + (i++) + ": " + iterator.next();
		}
		return cadena;
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
	 */
	public String masEscuchada() {
		if (topMusic.size() == 0) {
			return "No se encuentran canciones en el top..";
		}
		return " La canción mas escuchada es " + topMusic.get(0);
	}

	/**
	 * Muestra el tama&ntilde;o del Top Music.
	 * 
	 * @return Devuelve el tama&ntilde;o del Top Music.
	 */
	int size() {
		return topMusic.size();
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
