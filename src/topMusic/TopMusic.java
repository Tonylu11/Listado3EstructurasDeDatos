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
	ArrayList<Cancion> topMusic;

	TopMusic() {
		topMusic = new ArrayList<Cancion>();
	}

	void annadirCancion(Cancion cancion) {
		topMusic.add(cancion);
	}

	void annadirCancion(Cancion cancion, int posicion) {
		topMusic.add(posicion, cancion);
	}

	void eliminarCancion(Cancion cancion) {
		topMusic.remove(cancion);
	}

	void subirPuesto(Cancion cancion) {
		// Cancion cancionAux = cancion;
		// topMusic.set(topMusic.indexOf(cancion),
		// topMusic.get(topMusic.indexOf(cancion) - 1));
		// topMusic.set(topMusic.indexOf(cancion) - 1, cancionAux);
		Collections.swap(topMusic, topMusic.indexOf(cancion), topMusic.indexOf(cancion) - 1);
	}

	void bajarPuesto(Cancion cancion) {
		// Cancion cancionAux = cancion;
		// topMusic.set(topMusic.indexOf(cancion),
		// topMusic.get(topMusic.indexOf(cancion) + 1));
		// topMusic.set(topMusic.indexOf(cancion) + 1, cancionAux);
		Collections.swap(topMusic, topMusic.indexOf(cancion), topMusic.indexOf(cancion) + 1);
	}

	String mostrarTopMusic() {
		Iterator<Cancion> iterator = topMusic.iterator();
		String cadena = "";
		int i = 1;
		while (iterator.hasNext()) {
			cadena += "Puesto " + (i++) + ": " + iterator.next();
		}
		return cadena;
	}

	public Cancion buscarElemento(Cancion cancion) {
		return topMusic.get(topMusic.indexOf(cancion));
	}
}
