package pila;

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
public class TestPila {

	public static void main(String[] args) {
		Pila<Persona> pila = new Pila<Persona>();
		pila.apilar(new Persona("Antonio", "Luque Bravo"));
		pila.apilar(new Persona("Estela", "Muñoz Cordón"));
		pila.apilar(new Persona("Alberto", "González Ruiz"));
		System.out.println(pila);
		try {
			System.out.println(pila.extraer() + " Desapilado..");
		} catch (PilaVaciaException e) {
			System.err.println("La pila está vacía..");
		} // Desapila el
			// último
			// elemento de
			// la pila.
		System.out.println(pila);
		try {
			System.out.println("En la cima de la pila está: " + pila.cima());
		} catch (PilaVaciaException e) {
			System.err.println("La pila está vacía..");
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
			// último
			// elemento
			// añadido.
		while (!pila.isEmpty())
			try {
				System.out.println("Desapilo de la pila: " + pila.extraer());
			} catch (PilaVaciaException e) {
				System.err.println("La pila está vacía..");
			}
		System.out.println(pila);
	}
}
