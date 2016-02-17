package listaDeLaCompra;

import java.util.ArrayList;
import java.util.Iterator;

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
	/**
	 * ArrayList de la lista de la compra.
	 */
	ArrayList<Articulo> listaDeLaCompra = new ArrayList<Articulo>();

	/**
	 * añade un articulo a la lista de la compra.
	 * 
	 * @param articulo
	 *            articulo a añadir a la lista de la compra.
	 * @return Devuelve una cadena exitosa.
	 * @throws ArticuloYaExisteException
	 *             Cuando el articulo ya existe en la lista de la compra.
	 */
	String annadir(Articulo articulo) throws ArticuloYaExisteException {
		if (listaDeLaCompra.contains(articulo))
			throw new ArticuloYaExisteException();
		listaDeLaCompra.add(articulo);
		return "Artículo añadido con éxito.";
	}

	/**
	 * Elimina un articulo de la lista de la compra.
	 * 
	 * @param articulo
	 *            articulo a añadir a la lista.
	 * @return Devuelve un mensaje exitoso.
	 * @throws ArticuloNoExisteException
	 *             Cuando el articulo no existe.
	 */
	String eliminar(Articulo articulo) throws ArticuloNoExisteException {
		if (!listaDeLaCompra.contains(articulo))
			throw new ArticuloNoExisteException();
		listaDeLaCompra.remove(articulo);
		return "Artículo eliminado con éxito.";
	}

	/**
	 * Aumenta las existencias del articulo.
	 * 
	 * @param cantidad
	 *            cantidad que aumentara las existencias.
	 * @param articulo
	 *            articulo en cuestion.
	 * @return Devuelve una cadena concatenando el nombre del articulo y la
	 *         cantidad que se ha aumentado.
	 * @throws ExistenciasNegativasException
	 *             Cuando las existencias del articulo son negativas.
	 * @throws CantidadNegativaException
	 *             Cuando la cantidad introducida es negativa.
	 * @throws IndexOutOfBoundsException
	 *             Cuando no se encuentre el articulo.
	 * @throws ArticuloNoExisteException
	 *             Cuando no exista el articulo en la lista de la compra.
	 */
	String aumentarExistencias(int cantidad, Articulo articulo) throws ExistenciasNegativasException,
			CantidadNegativaException, IndexOutOfBoundsException, ArticuloNoExisteException {
		if (!listaDeLaCompra.contains(articulo)) {
			throw new ArticuloNoExisteException();
		}
		this.getArticulo(articulo).comprar(cantidad);
		return "Artículo " + articulo.getNombre() + " ha aumentado sus existencias en " + cantidad;
	}

	/**
	 * Consume un numero de existencias de un articulo determinado.
	 * 
	 * @param cantidad
	 *            cantidad que disminuira las existencias.
	 * @param articulo
	 *            articulo en cuestion.
	 * @return Devuelve una cadena con el articulo y la cantidad que se
	 *         disminuyo las existencias.
	 * @throws ArticuloNoExisteException
	 *             Cuando no exista el articulo en la lista de la compra.
	 * @throws ExistenciasNegativasException
	 *             Cuando las existencias del articulo son negativas.
	 * @throws IndexOutOfBoundsException
	 *             Cuando no se encuentre el articulo.
	 */
	String consumirExistencias(int cantidad, Articulo articulo)
			throws ArticuloNoExisteException, ExistenciasNegativasException, IndexOutOfBoundsException {
		if (!listaDeLaCompra.contains(articulo)) {
			throw new ArticuloNoExisteException();
		}
		this.getArticulo(articulo).consumir(cantidad);
		return "Se han consumido " + cantidad + " existencias de "
				+ listaDeLaCompra.get(listaDeLaCompra.indexOf(articulo)).getNombre();
	}

	/**
	 * devuelve el articulo en cuestion
	 * 
	 * @param articulo
	 *            articulo en cuestion.
	 * @return devuelve la busqueda del articulo en el ArrayList
	 * @throws ArticuloNoExisteException
	 *             Cuando no existe en articulo introducido.
	 * @throws IndexOutOfBoundsException
	 *             Cuando no se encuentra el articulo.
	 */
	Articulo getArticulo(Articulo articulo) throws ArticuloNoExisteException, IndexOutOfBoundsException {
		if (!listaDeLaCompra.contains(articulo))
			throw new ArticuloNoExisteException();
		return listaDeLaCompra.get(listaDeLaCompra.indexOf(articulo));
	}

	/**
	 * Altera el numero de existencias minimas que tiene que tener el articulo.
	 * 
	 * @param articulo
	 *            articulo a alterar.
	 * @param cantidadMinima
	 *            Nueva cantidad minima de existencias.
	 * @throws ArticuloNoExisteException
	 *             Cuando el articulo no existe.
	 * @throws MinimoExistenciasNegativasException
	 *             Cuando el numero de existencias negativas introducidas es
	 *             negativo.
	 */
	public void alterarExistenciasMinimas(Articulo articulo, int cantidadMinima)
			throws ArticuloNoExisteException, MinimoExistenciasNegativasException {
		if (!listaDeLaCompra.contains(articulo)) {
			throw new ArticuloNoExisteException();
		}
		if (cantidadMinima < 0) {
			throw new MinimoExistenciasNegativasException();
		}
		this.getArticulo(articulo).modificarExistenciasMinimas(cantidadMinima);
	}

	/**
	 * Muestra la lista de articulos.
	 * 
	 * @return Devuelve una cadena concatenada con todos los articulos de la
	 *         lista.
	 * @throws ListaDeLaCompraVaciaException
	 *             Cuando la lista de la compra esta vacia.
	 */
	public String mostrarListaArticulos() throws ListaDeLaCompraVaciaException {
		Iterator<Articulo> it = listaDeLaCompra.iterator();
		String cadena = "";
		int i = 1;
		if (listaDeLaCompra.isEmpty())
			throw new ListaDeLaCompraVaciaException();
		while (it.hasNext()) {
			cadena += "Articulo número " + i++ + ": " + it.next();
		}
		return cadena;
	}

	/**
	 * Muestra la lista de aquellos articulos cuyas existencias estan por debajo
	 * de las minimas.
	 * 
	 * @return Devuelve una cadena concatenada con cada articulo de la lista de
	 *         la compra.
	 * @throws ListaDeLaCompraVaciaException
	 *             Cuando la lista de la compra esta vacia.
	 */
	public String mostrarListaDeLaCompra() throws ListaDeLaCompraVaciaException {
		Iterator<Articulo> iterator = listaDeLaCompra.iterator();
		String cadena = "Lista de la compra:\n";
		int i = 1;
		int contador = 0;
		while (iterator.hasNext()) {
			Articulo articulo = iterator.next();
			if (articulo.getExistencias() < articulo.getCantidadMinima()) {
				cadena += "\tArticulo " + i++ + ": \t" + articulo;
				contador++;
			}
		}
		if (contador == 0) {
			throw new ListaDeLaCompraVaciaException();
		}
		return cadena;
	}
}
