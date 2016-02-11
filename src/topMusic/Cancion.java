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
 * @version 1.0
 *
 */
public class Cancion {
	private String nombre;
	private String artista;
	private String annoGrabacion;

	Cancion(String nombre, String artista, String annoGrabacion) {
		this.nombre = nombre;
		this.artista = artista;
		this.annoGrabacion = annoGrabacion;
	}

	public Cancion(String nombre) {
		this.nombre = nombre;
	}

	String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	String getArtista() {
		return artista;
	}

	private void setArtista(String artista) {
		this.artista = artista;
	}

	String getAnnoGrabacion() {
		return annoGrabacion;
	}

	private void setAnnoGrabacion(String annoGrabacion) {
		this.annoGrabacion = annoGrabacion;
	}

	@Override
	public String toString() {
		return "\n\tCancion: " + nombre + "\n\tArtista: " + artista + "\n\tAño de grabación: " + annoGrabacion + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
