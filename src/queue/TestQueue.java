package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Busca en la API de Java la collection Queue . Indica su nombre completo, e
 * xplica su utilidad y entrega un código donde demuestres su uso.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class TestQueue {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		String elemento1 = new String("Elemento 1.");
		String elemento2 = new String("Elemento 2.");
		String elemento3 = new String("Elemento 3.");
		System.out.println("Encolando Elemento 1. ¿Elemento añadido?: " + queue.add(elemento1));
		System.out.println("Encolando Elemento 2. ¿Elemento añadido?: " + queue.add(elemento2));
		System.out.println("Encolando Elemento 3. ¿Elemento añadido?: " + queue.add(elemento3));
		System.out.println("Mostrando la cola: " + queue);
		System.out.println("Mostrando el principio de la cola: " + queue.peek());
		System.out.println("Comprueba si la cola está vacía, ¿La cola esta vacía?: " + queue.isEmpty());

		System.out.println("Mostrando la cola: " + queue);
		System.out.println("Desencolando con while(!queue.isEmpty()):");
		while (!queue.isEmpty()) {
			System.out.println("\tDesencolando (" + queue.poll() + ") de la cola.");
		}
		System.out.println("Mostrando la cola: " + queue);
	}
}
