package pila;

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
	 */
	Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreInvalidoException {
		if (nombre.length() == 0)
			throw new NombreInvalidoException();
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) throws ApellidosInvalidosException {
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
