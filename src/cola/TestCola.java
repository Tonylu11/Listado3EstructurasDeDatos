package cola;

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
 *
 */
public class TestCola {

	public static void main(String[] args) {
		Cola<Persona> cola = new Cola<Persona>();
		cola.annadir(new Persona("Antonio", "Luque Bravo"));
		cola.annadir(new Persona("Estela", "Mu�oz Cord�n"));
		cola.annadir(new Persona("Alberto", "Gonz�lez Ruiz"));
		System.out.println("1. Mostrando la cola: " + cola);// 1. Mostrando la
															// cola: [Antonio
															// Luque Bravo,
															// Estela Mu�oz
															// Cord�n, Alberto
															// Gonz�lez Ruiz]
		System.out.println("1. Extrayendo a.. " + cola.extraer());// Extrayendo
																	// a..
																	// Antonio
																	// Luque
																	// Bravo
		System.out.println("1. El primero de la cola es: " + cola.cabeza());// La
																			// cabeza
																			// de
																			// la
																			// cola
																			// es
																			// Estela
																			// Mu�oz
																			// Cord�n.
		System.out.println("2. Mostrando la cola: " + cola);// Estela Mu�oz
															// Cord�n, Alberto
															// Gonz�lez Ruiz
		System.out.println("2. Extrayendo a.. " + cola.extraer());// Extrayendo
																	// a..
																	// Estela
																	// Mu�oz
																	// Cord�n
		System.out.println("2. El primero de la cola es: " + cola.cabeza());// El
																			// primero
																			// de
																			// la
																			// cola
																			// es:
																			// Alberto
																			// Gonz�lez
																			// Ruiz
		System.out.println("3. Mostrando la cola: " + cola);// 3. Mostrando la
															// cola: [Alberto
															// Gonz�lez Ruiz]
		cola.annadir(new Persona("Alejandro", "Leo Ramirez"));
		cola.annadir(new Persona("Tony", "Martinez"));
		cola.annadir(new Persona("Florentino", "P�rez"));
		cola.annadir(new Persona("Nadia", "Gutierrez"));
		System.out.println("4. Mostrando la cola: " + cola);// 4. Mostrando la
															// cola: [Alberto
															// Gonz�lez Ruiz,
															// Alejandro Leo
															// Ramirez, Tony
															// Martinez,
															// Florentino P�rez,
															// Nadia Gutierrez]
		while (!cola.IsEmpty()) {// Desencolando hasta que la cola est� vac�a..
			System.out.println("Desapilo de la pila con while: " + cola.extraer());
			System.out.println(cola);
		}
	}

}
