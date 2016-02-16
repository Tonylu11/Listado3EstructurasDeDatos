package pila;

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
public class TestPila {

	public static void main(String[] args) {
		Pila<Persona> pila = new Pila<Persona>();
		pila.apilar(new Persona("Antonio", "Luque Bravo"));
		pila.apilar(new Persona("Estela", "Mu�oz Cord�n"));
		pila.apilar(new Persona("Alberto", "Gonz�lez Ruiz"));
		System.out.println(pila);
		try {
			System.out.println(pila.extraer() + " Desapilado..");
		} catch (PilaVaciaException e) {
			System.err.println("La pila est� vac�a..");
		} // Desapila el
			// �ltimo
			// elemento de
			// la pila.
		System.out.println(pila);
		try {
			System.out.println("En la cima de la pila est�: " + pila.cima());
		} catch (PilaVaciaException e) {
			System.err.println("La pila est� vac�a..");
		} // Se
			// muestra
			// la
			// cima
			// de
			// la
			// pila,
			// es
			// decir
			// el
			// �ltimo
			// elemento
			// a�adido.
		while (!pila.isEmpty())
			try {
				System.out.println("Desapilo de la pila: " + pila.extraer());
			} catch (PilaVaciaException e) {
				System.err.println("La pila est� vac�a..");
			}
		System.out.println(pila);
	}
}
