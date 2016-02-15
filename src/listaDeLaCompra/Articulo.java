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
public class Articulo {
	private String nombre;
	private int cantidadMinima;
	private int existencias;

	Articulo(String nombre, int cantidadMinima, int existencias) throws NombreNoValidoException {
		setNombre(nombre);
		setCantidadMinima(cantidadMinima);
		setExistencias(existencias);
	}

//	private Articulo crearArticulo(String nombre, int cantidadMinima, int existencias) throws NombreNoValidoException {
//		if (nombre == null || cantidadMinima == 0 || existencias == 0)
//			return null;
//		setNombre(nombre);
//		setCantidadMinima(cantidadMinima);
//		setExistencias(existencias);
//		return null;
//	}

	Articulo(String nombre) throws NombreNoValidoException {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws NombreNoValidoException {
		if (nombre.length() == 0)
			throw new NombreNoValidoException();
		this.nombre = nombre;
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	private void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public int getExistencias() {
		return existencias;
	}

	private void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	void consumir(int cantidad) {
		setExistencias(getExistencias() - cantidad);
	}

	void comprar(int cantidad) {
		setExistencias(getExistencias() + cantidad);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", cantidadMinima=" + cantidadMinima + ", existencias=" + existencias
				+ "]";
	}
}
