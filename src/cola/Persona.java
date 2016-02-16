package cola;

/**
 * Clase persona.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 */
class Persona {
	/**
	 * Nombre de la persona.
	 */
	String nombre;
	/**
	 * Apellidos de la persona.
	 */
	String apellidos;

	/**
	 * Constructor de Persona.
	 * 
	 * @param nombre
	 *            Nombre de la persona.
	 * @param apellidos
	 *            Apellidos de la persona.
	 * @throws NombreNoValidoException
	 * @throws ApellidosInvalidosException
	 */
	Persona(String nombre, String apellidos) throws NombreNoValidoException, ApellidosInvalidosException {
		setNombre(nombre);
		setApellidos(apellidos);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws NombreNoValidoException {
		if (nombre.length() == 0)
			throw new NombreNoValidoException();
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) throws ApellidosInvalidosException {
		if (apellidos.length() == 0)
			throw new ApellidosInvalidosException();
		this.apellidos = apellidos;
	}

	/**
	 * Muestra a la persona.
	 */
	@Override
	public String toString() {
		return "" + nombre + " " + apellidos + "";
	}

}
