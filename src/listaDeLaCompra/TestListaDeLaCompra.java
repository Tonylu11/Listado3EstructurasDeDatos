package listaDeLaCompra;

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
	public static void main(String[] args) {
		ListaDeLaCompra listaDeLaCompra = new ListaDeLaCompra();
		try {
			listaDeLaCompra.annadir(new Articulo("latas de cerveza", 10, 14));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre no es v�lido.");
		}
		try {
			listaDeLaCompra.annadir(new Articulo("latas de fabada", 10, 14));
		} catch (NombreNoValidoException e) {
			System.err.println("El nombre no es v�lido.");
		}
		System.out.println(listaDeLaCompra);
		listaDeLaCompra.consumirExistencias(5, "latas de cerveza");
		System.out.println(listaDeLaCompra);
	}
}