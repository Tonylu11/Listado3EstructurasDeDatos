package pila;

import cola.ColaVaciaException;
import utiles.Menu;
import utiles.Teclado;

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
 */
public class TestPilaConMenu {
	static Pila<Persona> pila = new Pila<Persona>();
	static Menu menuPila = new Menu("Pila.", new String[] { "Apilar personas..", "Extraer personas..",
			"�Quien est� en la cima?", "Desapilar completamente..", "Mostrar pila..", "Salir." });

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = menuPila.gestionar();
			switch (opcion) {
			case 1:
				apilarPersonas();
				break;
			case 2:
				extraerPersonas();
				break;
			case 3:
				mostrarCima();
				break;
			case 4:
				desapilarCompletamente();
				break;
			case 5:
				mostrarPila();
				break;
			case 6:
				System.out.println("Adiooos..");
				break;
			}
		} while (opcion != 6);
	}

	/**
	 * Muestra la pila, si est&aacute; vac&iacute;a mostrar&aacute; un mensaje
	 * diciendo que est&aacute; vac&iacute;a.
	 * 
	 * @return
	 */
	private static void mostrarPila() {
		try {
			System.out.println(pila.mostrar());
		} catch (PilaVaciaException e) {
			System.err.println("La pila est� vac�a..");
		}
	}

	/**
	 * Comprueba si la pila est&aacute; vac&iacute;a, si no lo est&aacute;,
	 * elimina personas de la pila.
	 */
	private static void extraerPersonas() {
		try {
			System.out.println("Eliminado " + pila.extraer());
		} catch (PilaVaciaException e) {
			System.err.println("La pila est� vac�a..");
		}
	}

	/**
	 * Comprueba si la pila est&aacute; vac&iacute;a, si no lo est&aacute;,
	 * muestra la cima de la pila.
	 */
	private static void mostrarCima() {
		try {
			System.out.println("En la cima de la pila est� " + pila.cima());
		} catch (PilaVaciaException e) {
			System.err.println("La pila est� vac�a..");
		}

	}

	/**
	 * A&ntilde;ade personas a la pila.
	 */
	private static void apilarPersonas() {
		try {
			pila.apilar(new Persona(Teclado.leerCadena("Nombre de la persona."),
					Teclado.leerCadena("Apellidos de la persona.")));
		} catch (NombreInvalidoException e) {
			System.err.println("El nombre no es v�lido..");
		} catch (ApellidosInvalidosException e) {
			System.err.println("Los apellidos no son v�lidos..");
		}
	}

	/**
	 * Elimina a todas las personas de la pila hasta que &eacute;sta est&eacute;
	 * vac&iacute;a
	 */
	private static void desapilarCompletamente() {
		try {
			System.out.println(pila.extraerCompletamente());
		} catch (PilaVaciaException e) {
			System.err.println("La pila est� vac�a..");

		}
	}
}
