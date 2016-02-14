package listaDeLaCompra;

import java.util.ArrayList;

/**
 * ListaDeLaCompra . Implementa un programa que gestione una lista de la compra
 * de forma automática. Se dispond rá de una lista de artículos y de sus
 * existencias. En el momento en el que la cantidad de artículos llegue a un
 * límite mínimo, dicho artículo aparecerá en la lista de la compra. Cada vez
 * que el usuario utilice uno de los artículos se decrementarán las exis tencias
 * de dicho artículo. De igual forma, cada vez que el usuario compre el
 * artículo, se incrementarán las existencias de dicho artículo. A modo de
 * ejemplo, supongamos que del artículo "latas de cerveza" se establece a un
 * mínimo de 10 cervezas. Actualmen te hay 14 y se consumen de golpe 5 cervezas.
 * a. Artículo: [nombre = latas de cerveza, cantidad mínima= 10, existencias =
 * 14] b. articulo.consumir(5) c. Artículo: [nombre = latas de cerveza, cantidad
 * mínima= 10, existencias = 9] d. Como (articulo.getExistencias() <= ar
 * ticulo.getCantidadMin()) hay que comprar latas de cerveza. Quizás sea
 * interesante añadir un campo código del artículo para facilitar la gestión de
 * la lista. Este código ha de ser único (static...) Para ello, genera un
 * interfaz con el usuario que permita en tre otras acciones: e. Añadir un
 * producto nuevo a la lista. f. Eliminar un elemento de la lista. g.
 * Incrementar las existencias de un artículo. h. Decrementar las existencias de
 * un artículo. i. Modificar la cantidad mínima del artículo. j. Mostrar la
 * lista de todos los artí culos. k. Mostrar la lista de la compra. Comienza
 * analizando el diseño. Piensa en el total de clases que vas a utilizar y
 * aprovecha aquellas clases que puedas.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class ListaDeLaCompra {
	ArrayList<Articulo> listaDeLaCompra = new ArrayList<Articulo>();

	String annadir(Articulo articulo) {
		if (listaDeLaCompra.contains(articulo)) {
			return "Ese artículo ya existe..";
		}
		listaDeLaCompra.add(articulo);
		return "Artículo añadido con éxito.";
	}

	String eliminar(Articulo articulo) {
		if (!listaDeLaCompra.contains(articulo)) {
			return "Ese artículo no existe..";
		}
		listaDeLaCompra.remove(articulo);
		return "Artículo eliminado con éxito.";
	}

	// String aumentarExistencias(int cantidad, Articulo articulo) {
	// if (!listaDeLaCompra.contains(articulo)) {
	// return "Ese artículo no existe..";
	// }
	// articulo.comprar(cantidad);
	// return "Artículo " + articulo.getNombre() + " ha aumentado sus
	// existencias en " + cantidad;
	// }

	String consumirExistencias(int cantidad, String articulo) {
		if (!listaDeLaCompra.contains(articulo)) {
			return "Ese artículo no existe..";
		}

		this.getArticulo(articulo).consumir(5);
		return "Se han consumido " + cantidad + " existencias de "
				+ listaDeLaCompra.get(listaDeLaCompra.indexOf(articulo)).getNombre();
	}

	Articulo getArticulo(String articulo) {
		return listaDeLaCompra.get(listaDeLaCompra.indexOf(articulo));
	}

	@Override
	public String toString() {
		return "ListaDeLaCompra [\n" + listaDeLaCompra + "\n]";
	}

}
