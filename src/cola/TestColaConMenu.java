package cola;

import utiles.Menu;
import utiles.Teclado;

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
 */
public class TestColaConMenu {
	/**
	 * Campo de tipo Cola.
	 */
	static Cola<Persona> cola = new Cola<Persona>();
	/**
	 * Men&uacute; para la gesti&oacute;n de la cola.
	 */
	static Menu menuCola = new Menu("Cola.", new String[] { "Añadir personas..", "Extraer personas..",
			"¿Quien está a la cabeza?", "Extraer completamente..", "Mostrar cola..", "Salir." });

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = menuCola.gestionar();
			switch (opcion) {
			case 1:
				annadirPersonas();
				break;
			case 2:
				extraerPersonas();
				break;
			case 3:
				mostrarCabeza();
				break;
			case 4:
				extraerCompletamente();
				break;
			case 5:
				mostrarCola();
				break;
			case 6:
				System.out.println("Adiooos..");
				break;
			}
		} while (opcion != 6);
	}

	/**
	 * Muestra la cola, si est&aacute; vac&iacute;a mostrar&aacute; un mensaje
	 * diciendo que est&aacute; vac&iacute;a.
	 */
	private static void mostrarCola() {
		if (cola.IsEmpty())
			System.out.println("La cola está vacía..");
		else
			System.out.println(cola);
	}

	/**
	 * Elimina personas de la cola.
	 */
	private static void extraerPersonas() {
		if (!cola.IsEmpty()) {
			System.out.println("Eliminado " + cola.extraer());
		} else
			System.out.println("No hay ningún elemento en la cola..");

	}

	/**
	 * Muestra el primer elemento de la cola (cabeza de la cola).
	 */
	private static void mostrarCabeza() {
		if (!cola.IsEmpty()) {
			System.out.println("En la cabeza de la cola está " + cola.cabeza());
		} else
			System.out.println("No hay ningún elemento en la cola..");

	}

	/**
	 * A&ntilde;ade personas a la cola.
	 */
	private static void annadirPersonas() {
		cola.annadir(new Persona(Teclado.leerCadena("Nombre de la persona."),
				Teclado.leerCadena("Apellidos de la persona.")));
	}

	/**
	 * Elimina a todas las personas de la cola hasta que &eacute;sta est&eacute;
	 * vac&iacute;a
	 */
	private static void extraerCompletamente() {
		if (cola.IsEmpty())
			System.out.println("La cola está vacía..");
		while (!cola.IsEmpty())
			System.out.println("Extraigo de la cola: " + cola.extraer());
	}
}
