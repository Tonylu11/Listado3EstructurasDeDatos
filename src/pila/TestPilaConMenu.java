package pila;

import utiles.Menu;
import utiles.Teclado;

/**
 * Crea una clase genérica Pila (debe de aceptar cualquier tipo de objeto
 * concreto , utiliza generics ) . Recuerda que has de evitar la interacción con
 * el usuario dentro de Pila . Implementa las operaciones básicas de una
 * estructura de da tos pila. Una pila es una estructura LIFO donde el último
 * elemento en entrar es el primero en salir. Un ejemplo básico de pila es la
 * forma de almacenamiento de procesos en la memoria. Las operaciones a
 * implementar son: a. Crear una pila. b. Introducir elemento en la pila (apilar
 * o push) c. Sacar elemento de la pila (extraer o pop) d. Cima de la pila
 * (devuelve el elemento de la cima de la pila o top) Implementa los métodos
 * necesarios, y recuerda hacer las pruebas precisas. Para ello, crea una clase
 * TestPila donde se añadan muchos elementos de una clase creada en el mismo
 * fichero (Persona, Paciente, Cartas...) y se invoquen a todos los métodos. Al
 * final, vacía la pila con un bucle de este estilo: while (!pila.IsEmpty())
 * System.out.println("Desapilo de la pila: " + p .pop());
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 */
public class TestPilaConMenu {
	static Pila<Persona> pila = new Pila<Persona>();
	static Menu menuPila = new Menu("Pila.", new String[] { "Apilar personas..", "Extraer personas..",
			"¿Quien está en la cima?", "Desapilar completamente..", "Mostrar pila..", "Salir." });

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
				System.out.println(pila);
				break;
			case 6:
				System.out.println("Adiooos..");
				break;
			}
		} while (opcion != 6);
	}

	/**
	 * Comprueba si la pila est&aacute; vac&iacute;a, si no lo est&aacute;,
	 * elimina personas de la pila.
	 */
	private static void extraerPersonas() {
		if (!pila.IsEmpty()) {
			System.out.println("Eliminado " + pila.extraer());
		} else
			System.out.println("No hay ningún elemento en la pila..");
	}

	/**
	 * Comprueba si la pila est&aacute; vac&iacute;a, si no lo est&aacute;,
	 * muestra la cima de la pila.
	 */
	private static void mostrarCima() {
		if (!pila.IsEmpty()) {
			System.out.println("En la cima de la pila está " + pila.cima());
		} else
			System.out.println("No hay ningún elemento en la pila..");

	}

	/**
	 * A&ntilde;ade personas a la pila.
	 */
	private static void apilarPersonas() {
		pila.apilar(new Persona(Teclado.leerCadena("Nombre de la persona."),
				Teclado.leerCadena("Apellidos de la persona.")));
	}

	/**
	 * Elimina a todas las personas de la pila hasta que &eacute;sta est&eacute;
	 * vac&iacute;a
	 */
	private static void desapilarCompletamente() {
		if (pila.IsEmpty())
			System.out.println("La pila está vacía..");
		while (!pila.IsEmpty())
			System.out.println("Desapilo de la pila: " + pila.extraer());
	}
}
