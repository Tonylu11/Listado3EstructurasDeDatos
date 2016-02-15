package listaDeLaCompra;

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
	public static void main(String[] args) {
		ListaDeLaCompra listaDeLaCompra = new ListaDeLaCompra();
		try {
			listaDeLaCompra.annadir(new Articulo("latas de cerveza", 10, 14));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre no es válido.");
		}
		try {
			listaDeLaCompra.annadir(new Articulo("latas de fabada", 10, 14));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre no es válido.");
		}
		System.out.println(listaDeLaCompra);
		listaDeLaCompra.consumirExistencias(5, "latas de cerveza");
		System.out.println(listaDeLaCompra);
	}
}