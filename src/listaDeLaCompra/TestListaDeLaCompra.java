package listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

/**
 * ListaDeLaCompra . Implementa un programa que gestione una lista de la compra
 * de forma autom�tica. Se dispond r� de una lista de art�culos y de sus
 * existencias. En el momento en el que la cantidad de art�culos llegue a un
 * l�mite m�nimo, dicho art�culo aparecer� en la lista de la compra. Cada vez
 * que el usuario utilice uno de los art�culos se decrementar�n las exis tencias
 * de dicho art�culo. De igual forma, cada vez que el usuario compre el
 * art�culo, se incrementar�n las existencias de dicho art�culo. A modo de
 * ejemplo, supongamos que del art�culo "latas de cerveza" se establece a un
 * m�nimo de 10 cervezas. Actualmen te hay 14 y se consumen de golpe 5 cervezas.
 * a. Art�culo: [nombre = latas de cerveza, cantidad m�nima= 10, existencias =
 * 14] b. articulo.consumir(5) c. Art�culo: [nombre = latas de cerveza, cantidad
 * m�nima= 10, existencias = 9] d. Como (articulo.getExistencias() <= ar
 * ticulo.getCantidadMin()) hay que comprar latas de cerveza. Quiz�s sea
 * interesante a�adir un campo c�digo del art�culo para facilitar la gesti�n de
 * la lista. Este c�digo ha de ser �nico (static...) Para ello, genera un
 * interfaz con el usuario que permita en tre otras acciones: e. A�adir un
 * producto nuevo a la lista. f. Eliminar un elemento de la lista. g.
 * Incrementar las existencias de un art�culo. h. Decrementar las existencias de
 * un art�culo. i. Modificar la cantidad m�nima del art�culo. j. Mostrar la
 * lista de todos los art� culos. k. Mostrar la lista de la compra. Comienza
 * analizando el dise�o. Piensa en el total de clases que vas a utilizar y
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
				new String[] { "A�adir producto", "Eliminar producto", "Incrementar existencias",
						"Decrementar existencias", "Modificar cantidad m�nima", "Mostrar todos los art�culos",
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
			System.err.println("No hay ning�n articulo por debajo de sus m�nimos.");
		}
	}

	/**
	 * Muestra la lista de articulos.
	 */
	private static void mostrarListaArticulos() {
		try {
			System.out.println(listaDeLaCompra.mostrarListaArticulos());
		} catch (ListaDeLaCompraVaciaException e) {
			System.err.println("La lista no contiene ning�n art�culo.");
		}
	}

	/**
	 * Modifica las existencias minimas de un articulo.
	 */
	private static void modificarExistenciasMinimas() {
		try {
			listaDeLaCompra.alterarExistenciasMinimas(
					new Articulo(
							Teclado.leerCadena("Introduce el nombre del art�culo a modificar la cantidades m�nimas:")),
					Teclado.leerEntero("Introduce la nueva cantidad m�nima del art�culo:"));
		} catch (ArticuloNoExisteException e) {
			System.err.println("El art�culo no existe.");
		} catch (MinimoExistenciasNegativasException e) {
			System.err.println("El m�nimo de existencias no pueden ser negativas.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre del art�culo no es v�lido.");
		}
	}

	/**
	 * Decrementa las existencias de un articulo.
	 */
	private static void decrementarExistencias() {
		try {
			System.out.println(
					listaDeLaCompra.consumirExistencias(Teclado.leerEntero("Introduce la cantidad a consumir:"),
							new Articulo(Teclado.leerCadena("Introduce el nombre del art�culo:"))));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("No se encuentra el art�culo.");
		} catch (ArticuloNoExisteException e) {
			System.err.println("El art�culo no existe.");
		} catch (ExistenciasNegativasException e) {
			System.err.println("La existencias no pueden ser negativas.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es v�lido.");
		}
	}

	/**
	 * Incrementa las existencias de un articulo.
	 */
	private static void incrementarExistencias() {
		try {
			System.out
					.println(listaDeLaCompra.aumentarExistencias(Teclado.leerEntero("Introduce la cantidad a comprar:"),
							new Articulo(Teclado.leerCadena("Introduce el nombre del art�culo:"))));
		} catch (ExistenciasNegativasException e) {
			System.err.println("La existencias no pueden ser negativas.");
		} catch (CantidadNegativaException e) {
			System.err.println("La cantidad introducida no puede ser negativa.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es v�lido.");
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
					.eliminar(new Articulo(Teclado.leerCadena("Introduce el nombre del art�culo a eliminar:"))));
		} catch (ArticuloNoExisteException e) {
			System.err.println("Este art�culo no existe.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es v�lido.");
		}
	}

	/**
	 * A�ade un producto a la lista.
	 */
	private static void annadirProducto() {
		try {
			System.out.println(listaDeLaCompra.annadir(new Articulo(Teclado.leerCadena("Nombre del art�culo:"),
					Teclado.leerEntero("Cantidad m�nima del art�culo:"),
					Teclado.leerEntero("Existencias iniciales del art�culo:"))));
		} catch (ArticuloYaExisteException e) {
			System.err.println("Este art�culo ya existe.");
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre introducido no es v�lido.");
		} catch (ExistenciasNegativasException e) {
			System.err.println("Las existencias no pueden ser negativas.");
		} catch (MinimoExistenciasNegativasException e) {
			System.err.println("La existencias m�nimas no pueden ser negativas.");
		}
	}
}