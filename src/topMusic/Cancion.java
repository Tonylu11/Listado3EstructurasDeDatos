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
	/**
	 * Nombre de la canci&oacute;n.
	 */
	private String nombre;
	/**
	 * Artista de la canci&oacute;n.
	 */
	private String artista;
	/**
	 * A&ntilde;o de grabaci&oacute;n de la cancioacute;n.
	 */
	private String annoGrabacion;

	/**
	 * Constructor para la creaci&oacute;n de una canci&oacute;n.
	 * 
	 * @param nombre
	 *            Nombre de la canci&oacute;n.
	 * @param artista
	 *            Artista de la canci&oacute;n.
	 * @param annoGrabacion
	 *            A&ntilde;o de grabaci&oacute;n de la cancioacute;n.
	 */
	Cancion(String nombre, String artista, String annoGrabacion) {
		setNombre(nombre);
		setArtista(artista);
		setAnnoGrabacion(annoGrabacion);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	private void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAnnoGrabacion() {
		return annoGrabacion;
	}

	private void setAnnoGrabacion(String annoGrabacion) {
		this.annoGrabacion = annoGrabacion;
	}

	/**
	 * Constructor para la eliminaci&oacute;n de una canci&oacute;n del top
	 * mediante su nombre.
	 * 
	 * @param nombre
	 *            Nombre de la canci&oacute;n.
	 */
	public Cancion(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M&eacute;todo para mostrar tanto el nombre como el artista/grupo y el
	 * a&ntilde;o de grabaci&oacute;n de la canci&oacute;n.
	 */
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
