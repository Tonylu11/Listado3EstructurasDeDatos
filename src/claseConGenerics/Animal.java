package claseConGenerics;

/**
 * Reproduce una clase con Generics. Llámala ClaseConGenerics . Entrega su
 * esqueleto donde: a. Definas una variable de objeto . Ha de ser una colección
 * homogénea (del tipo parametrizado de la clase) b. Definas un constructor
 * donde instancies el atributo anterior c. Definas un método metodo1 cuyo
 * parámetro sea del tipo parametrizado d. Definas un método metodo2 cuyo valor
 * devuelto se a del tipo parametrizado
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class Animal {
	/**
	 * Nombre del animal.
	 */
	private String nombre;
	/**
	 * Raza del animal.
	 */
	private String raza;

	/**
	 * Constructor de Animal.
	 * 
	 * @param nombre
	 *            nombre del animal.
	 * @param raza
	 *            raza del animal.
	 * @throws NombreInvalidoException
	 *             Cuando el nombre es invalido.
	 * @throws RazaInvalidaException
	 *             Cuando la raza es invalida.
	 */
	Animal(String nombre, String raza) throws NombreInvalidoException, RazaInvalidaException {
		setNombre(nombre);
		setRaza(raza);
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el estado del campo nombre.
	 * 
	 * @param nombre
	 *            Nombre del animal.
	 * @throws NombreInvalidoException
	 *             Cuando el nombre no posee longitud.
	 */
	public void setNombre(String nombre) throws NombreInvalidoException {
		if (nombre.length() == 0)
			throw new NombreInvalidoException();
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	/**
	 * Modifica el estado del campo raza.
	 * 
	 * @param raza
	 *            Raza del animal.
	 * @throws RazaInvalidaException
	 *             Cuando la raza no posee longitud.
	 */
	public void setRaza(String raza) throws RazaInvalidaException {
		if (raza.length() == 0)
			throw new RazaInvalidaException();
		this.raza = raza;
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
		Animal other = (Animal) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n\tAnimal: " + nombre + "\n\tRaza: " + raza + "\n";
	}

}
