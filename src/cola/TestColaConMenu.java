package cola;

import utiles.Menu;
import utiles.Teclado;

/**
 * Crea una clase gen�rica Cola (debe de aceptar cualquier tipo de objeto
 * concreto , utiliza generics ) . Recuerda que has de evitar la interacci�n con
 * el usuario dentro de Cola. Utilizando generics, implementa las operaciones
 * b�sicas de una estructura de datos cola. Recuerda que una cola es una
 * estructura FIFO donde el primer elemento en entrar es el primero en salir. Un
 * ejemplo b�sico de cola es la de la t aquilla de un cine. Las operaciones a
 * implementar son: a. Crear una cola. b. Introducir elemento en la cola
 * (a�adir/enqueue) c. Sacar elemento de la cola (extraer/dequeue) d. Cabeza de
 * la cola. (devuelve el primer elemento de la cola, cabeza o front) Implementa
 * los m�todos necesarios, y recuerda hacer las pruebas precisas. Para ello,
 * crea una clase TestCola donde se a�adan muchos elementos de una clase creada
 * en el mismo fichero (Persona, Paciente, Cartas...) y se invoquen a todos los
 * m�todos. Al final , vac�a la cola con un bucle while que extraiga de la cola
 * hasta que se vac�e.
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
	static Menu menuCola = new Menu("Cola.", new String[] { "A�adir personas..", "Extraer personas..",
			"�Quien est� a la cabeza?", "Extraer completamente..", "Mostrar cola..", "Salir." });

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
	 * 
	 * @return
	 */
	private static void mostrarCola() {
		try {
			System.out.println(cola.mostrar());
		} catch (ColaVaciaException e) {
			System.err.println("La cola est� vac�a..");
		}
	}

	/**
	 * Elimina personas de la cola.
	 */
	private static void extraerPersonas() {
		try {
			System.out.println("Eliminado " + cola.extraer());
		} catch (ColaVaciaException e) {
			System.err.println("La cola est� vac�a..");
		}
	}

	/**
	 * Muestra el primer elemento de la cola (cabeza de la cola).
	 */
	private static void mostrarCabeza() {
		try {
			System.out.println("En la cabeza de la cola est� " + cola.cabeza());
		} catch (ColaVaciaException e) {
			System.err.println("La cola est� vac�a..");
		}
	}

	/**
	 * A&ntilde;ade personas a la cola.
	 */
	private static void annadirPersonas() {
		try {
			cola.annadir(new Persona(Teclado.leerCadena("Nombre de la persona."),
					Teclado.leerCadena("Apellidos de la persona.")));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre de la persona no es v�lido..");
		} catch (ApellidosInvalidosException e) {
			System.err.println("Los apellidos de la persona no son v�lidos..");
		}
	}

	/**
	 * Elimina a todas las personas de la cola hasta que &eacute;sta est&eacute;
	 * vac&iacute;a
	 */
	private static void extraerCompletamente() {
		while (!cola.IsEmpty())
			try {
				System.out.println("Extraigo de la cola: " + cola.extraer());
			} catch (ColaVaciaException e) {
				System.err.println("La cola est� vac�a..");
			}
	}
}
