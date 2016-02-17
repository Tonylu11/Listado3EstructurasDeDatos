package listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

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

public class TestListaDeLaCompra {
	/**
	 * Envoltorio de Lista de la Compra.
	 */
	static ListaDeLaCompra listaDeLaCompra = new ListaDeLaCompra();

	public static void main(String[] args) {
		int opcion;
		Menu menuListaDeLaCompra = new Menu("Lista de la compra.",
				new String[] { "Añadir producto", "Eliminar producto", "Incrementar existencias",
						"Decrementar existencias", "Modificar cantidad mínima", "Mostrar todos los artículos",
						"Mostrar lista de la compra", "Salir" });
		do {
			opcion = menuListaDeLaCompra.gestionar();
			switch (opcion) {
			case 1:
				annadirProducto();
				break;
			case 2:
				eliminarProducto();
				break;
			case 3:
				incrementarExistencias();
				break;
			case 4:
				decrementarExistencias();
				break;
			case 5:
				modificarExistenciasMinimas();
				break;
			case 6:
				mostrarListaArticulos();
				break;
			case 7:
				mostrarListaDeLaCompra();
				break;
			case 8:
				System.out.println("Adioooos");
				break;
			}
		} while (opcion != 8);
	}

	/**
	 * Muestra la lista de la compra.
	 */
	private static void mostrarListaDeLaCompra() {
		try {
			System.out.println(listaDeLaCompra.mostrarListaDeLaCompra());
		} catch (ListaDeLaCompraVaciaException e) {
			System.err.println("No hay ningún articulo por debajo de sus mínimos.");
		}
	}

	/**
	 * Muestra la lista de articulos.
	 */
	private static void mostrarListaArticulos() {
		try {
			System.out.println(listaDeLaCompra.mostrarListaArticulos());
		} catch (ListaDeLaCompraVaciaException e) {
			System.err.println("La lista no contiene ningún artículo.");
		}
	}

	/**
	 * Modifica las existencias minimas de un articulo.
	 */
	private static void modificarExistenciasMinimas() {
		try {
			listaDeLaCompra.alterarExistenciasMinimas(
					new Articulo(
							Teclado.leerCadena("Introduce el nombre del artículo a modificar la cantidades mínimas:")),
					Teclado.leerEntero("Introduce la nueva cantidad mínima del artículo:"));
		} catch (ArticuloNoExisteException e) {
			System.err.println("El artículo no existe.");
		} catch (MinimoExistenciasNegativasException e) {
			System.err.println("El mínimo de existencias no pueden ser negativas.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre del artículo no es válido.");
		}
	}

	/**
	 * Decrementa las existencias de un articulo.
	 */
	private static void decrementarExistencias() {
		try {
			System.out.println(
					listaDeLaCompra.consumirExistencias(Teclado.leerEntero("Introduce la cantidad a consumir:"),
							new Articulo(Teclado.leerCadena("Introduce el nombre del artículo:"))));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("No se encuentra el artículo.");
		} catch (ArticuloNoExisteException e) {
			System.err.println("El artículo no existe.");
		} catch (ExistenciasNegativasException e) {
			System.err.println("La existencias no pueden ser negativas.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es válido.");
		}
	}

	/**
	 * Incrementa las existencias de un articulo.
	 */
	private static void incrementarExistencias() {
		try {
			System.out
					.println(listaDeLaCompra.aumentarExistencias(Teclado.leerEntero("Introduce la cantidad a comprar:"),
							new Articulo(Teclado.leerCadena("Introduce el nombre del artículo:"))));
		} catch (ExistenciasNegativasException e) {
			System.err.println("La existencias no pueden ser negativas.");
		} catch (CantidadNegativaException e) {
			System.err.println("La cantidad introducida no puede ser negativa.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es válido.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("El articulo no se encuentra.");
		} catch (ArticuloNoExisteException e) {
			System.err.println("Ese articulo no existe.");
		}
	}

	/**
	 * Elimina el producto de la lista.
	 */
	private static void eliminarProducto() {
		try {
			System.out.println(listaDeLaCompra
					.eliminar(new Articulo(Teclado.leerCadena("Introduce el nombre del artículo a eliminar:"))));
		} catch (ArticuloNoExisteException e) {
			System.err.println("Este artículo no existe.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es válido.");
		}
	}

	/**
	 * Añade un producto a la lista.
	 */
	private static void annadirProducto() {
		try {
			System.out.println(listaDeLaCompra.annadir(new Articulo(Teclado.leerCadena("Nombre del artículo:"),
					Teclado.leerEntero("Cantidad mínima del artículo:"),
					Teclado.leerEntero("Existencias iniciales del artículo:"))));
		} catch (ArticuloYaExisteException e) {
			System.err.println("Este artículo ya existe.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es válido.");
		} catch (ExistenciasNegativasException e) {
			System.err.println("Las existencias no pueden ser negativas.");
		} catch (MinimoExistenciasNegativasException e) {
			System.err.println("La existencias mínimas no pueden ser negativas.");
		}
	}
}