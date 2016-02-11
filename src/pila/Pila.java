package pila;

import java.util.ArrayList;

/**
 * Crea una clase gen�rica Pila (debe de aceptar cualquier tipo de objeto
 * concreto , utiliza generics ) . Recuerda que has de evitar la interacci�n con
 * el usuario dentro de Pila . Implementa las operaciones b�sicas de una
 * estructura de da tos pila. Una pila es una estructura LIFO donde el �ltimo
 * elemento en entrar es el primero en salir. Un ejemplo b�sico de pila es la
 * forma de almacenamiento de procesos en la memoria. Las operaciones a
 * implementar son: a. Crear una pila. b. Introducir elemento en la pila (apilar
 * o push) c. Sacar elemento de la pila (extraer o pop) d. Cima de la pila
 * (devuelve el elemento de la cima de la pila o top) Implementa los m�todos
 * necesarios, y recuerda hacer las pruebas precisas. Para ello, crea una clase
 * TestPila donde se a�adan muchos elementos de una clase creada en el mismo
 * fichero (Persona, Paciente, Cartas...) y se invoquen a todos los m�todos. Al
 * final, vac�a la pila con un bucle de este estilo: while (!pila.IsEmpty())
 * System.out.println("Desapilo de la pila: " + p .pop());
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 * @param <T>
 */
public class Pila<T> {
	/**
	 * pila de tipo ArrayList.
	 */
	ArrayList<T> pila;

	/**
	 * Inicializaci&oacute;n de la pila.
	 */
	public Pila() {
		pila = new ArrayList<T>();
	}

	/**
	 * Apila elementos en la pila.
	 * 
	 * @param elemento
	 *            elemento.
	 */
	void apilar(T elemento) {
		pila.add(elemento);
	}

	/**
	 * Elimina elementos de la pila.
	 * 
	 * @return Devuelve el elemento eliminado.
	 */
	T extraer() {
		if (pila.size() == 0)
			return null;
		return pila.remove(pila.size() - 1);
	}

	/**
	 * Muestra la cima de la pila(El &ueacute;ltimo a&ntilde;adido).
	 * 
	 * @return Devuelve la cima de la pila.
	 */
	T cima() {
		if (pila.size() == 0)
			return null;
		return pila.get(pila.size() - 1);
	}

	/**
	 * Comprueba si la pila est&aacute; vac&iacute;a.
	 * 
	 * @return Devuelve true si est&aacute; vac&iacute;a, false si no.
	 */
	public boolean IsEmpty() {
		if (pila.isEmpty())
			return true;
		return false;
	}

	/**
	 * M&eacute;todo para mostrar la pila.
	 */
	@Override
	public String toString() {
		return "" + pila + "";
	}

}
