package topMusic;

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

	public static void main(String[] args) {
		TopMusic topMusic = new TopMusic();
		topMusic.annadirCancion(new Cancion("Aprendiz", "Mal�", "2006"));
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
