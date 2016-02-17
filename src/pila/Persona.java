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
	 * @throws NombreInvalidoException
	 * @throws ApellidosInvalidosException
	 */
	Persona(String nombre, String apellidos) throws NombreInvalidoException, ApellidosInvalidosException {
		setNombre(nombre);
		setApellidos(apellidos);
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el estado del campo nombre.
	 * 
	 * @param nombre
	 *            Nombre de la persona.
	 * @throws NombreInvalidoException
	 *             Cuando el nombre no es correcto.
	 */
	public void setNombre(String nombre) throws NombreInvalidoException {
		if (nombre.length() == 0)
			throw new NombreInvalidoException();
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Modifica el estado del campo apellidos.
	 * 
	 * @param apellidos
	 *            Apellidos de la persona.
	 * @throws ApellidosInvalidosException
	 *             Cuando los apellidos no son correctos.
	 */
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
