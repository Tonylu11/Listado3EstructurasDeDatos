package cola;

import java.util.ArrayList;

/**
 * Crea una clase genérica Cola (debe de aceptar cualquier tipo de objeto
 * concreto , utiliza generics ) . Recuerda que has de evitar la interacción con
 * el usuario dentro de Cola. Utilizando generics, implementa las operaciones
 * básicas de una estructura de datos cola. Recuerda que una cola es una
 * estructura FIFO donde el primer elemento en entrar es el primero en salir. Un
 * ejemplo básico de cola es la de la t aquilla de un cine. Las operaciones a
 * implementar son: a. Crear una cola. b. Introducir elemento en la cola
 * (añadir/enqueue) c. Sacar elemento de la cola (extraer/dequeue) d. Cabeza de
 * la cola. (devuelve el primer elemento de la cola, cabeza o front) Implementa
 * los métodos necesarios, y recuerda hacer las pruebas precisas. Para ello,
 * crea una clase TestCola donde se añadan muchos elementos de una clase creada
 * en el mismo fichero (Persona, Paciente, Cartas...) y se invoquen a todos los
 * métodos. Al final , vacía la cola con un bucle while que extraiga de la cola
 * hasta que se vacíe.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 * @param <T>
 */
public class Cola<T> {
	/**
	 * Cola de tipo ArrayList
	 */
	ArrayList<T> cola;

	/**
	 * Constructor para la inicializaci&oacute;n de la cola.
	 */
	Cola() {
		cola = new ArrayList<T>();
	}

	/**
	 * A&ntilde;ade un elemento a la cola.
	 * 
	 * @param elemento
	 *            elemento.
	 */
	void annadir(T elemento) {
		cola.add(elemento);
	}

	/**
	 * Extrae/Elimina un elemento de la cola.
	 * 
	 * @return Devuelve el elemento borrado.
	 */
	T extraer() {
		if (cola.size() == 0)
			return null;
		return cola.remove(0);
	}

	/**
	 * Muestra el elemento de la primera posici&oacute;n de la cola.
	 * 
	 * @return Devuelve el elemento.
	 */
	T cabeza() {
		if (cola.size() == 0)
			return null;
		return cola.get(0);
	}

	/**
	 * Comprueba si la cola est&aacute; vac&iacute;a.
	 * 
	 * @return Devuelve true si est&aacute; vac&iacute;a, false si no.
	 */
	public boolean IsEmpty() {
		if (cola.isEmpty())
			return true;
		return false;
	}

	/**
	 * Muestra la cola.
	 */
	@Override
	public String toString() {
		return "" + cola + "";
	}

}
