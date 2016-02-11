package topMusic;

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

	public static void main(String[] args) {
		TopMusic topMusic = new TopMusic();
		topMusic.annadirCancion(new Cancion("Aprendiz", "Malú", "2006"));
		topMusic.annadirCancion(new Cancion("Scream", "Avenged Sevenfold", "2012"));
		topMusic.annadirCancion(new Cancion("Dear God", "Avenged Sevenfold", "2012"));
		System.out.println("Original!!!!: \n" + topMusic.mostrarTopMusic());
		topMusic.subirPuesto(new Cancion("Dear God"));
		System.out.println(
				"--------------------------------" + "\nSubido 1 puesto a Dear God....\n" + topMusic.mostrarTopMusic());
		topMusic.subirPuesto(new Cancion("Dear God"));
		System.out.println(
				"--------------------------------" + "\nSubido 1 puesto a Dear God....\n" + topMusic.mostrarTopMusic());
		topMusic.bajarPuesto(new Cancion("Aprendiz"));
		System.out.println(
				"--------------------------------" + "\nBajado 1 puesto a Aprendiz....\n" + topMusic.mostrarTopMusic());
	}
}
