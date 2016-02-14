package stack;

import java.util.Stack;

/**
 * Busca en la API de Java la collection Stack . Indica su nombre completo,
 * explica su utilidad y entre ga un código donde demuestres su uso
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> pila = new Stack<String>();
		String elemento1 = new String("Elemento 1.");
		String elemento2 = new String("Elemento 2.");
		String elemento3 = new String("Elemento 3.");
		System.out.println("Apilando (" + pila.push(elemento1) + ") a la pila.");
		System.out.println("Apilando (" + pila.push(elemento2) + ") a la pila.");
		System.out.println("Apilando (" + pila.push(elemento3) + ") a la pila.");
		System.out.println("Mostrando la pila: " + pila);
		System.out.println("Mostrando la cima de la pila: " + pila.peek());
		System.out.println("Buscando el elemento (" + elemento1 + ") para conocer su posición en la pila: "
				+ pila.search(elemento1));
		System.out.println("Buscando el elemento (" + elemento2 + ") para conocer su posición en la pila: "
				+ pila.search(elemento2));
		System.out.println("Buscando el elemento (" + elemento3 + ") para conocer su posición en la pila: "
				+ pila.search(elemento3));
		System.out.println("Comprueba si la pila está vacía, ¿La pila esta vacía?: " + pila.empty());

		System.out.println("Mostrando la pila: " + pila);
		System.out.println("Desapilando con while(!pila.isEmpty()):");
		while (!pila.isEmpty()) {
			System.out.println("\tDesapilando (" + pila.pop() + ") de la pila.");
		}
		System.out.println("Mostrando la pila: " + pila);
	}
}