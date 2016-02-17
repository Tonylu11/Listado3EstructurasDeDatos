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
	/**
	 * Nombre del art&iacute;culo.
	 */
	private String nombre;
	/**
	 * Cantidad m&iacute;nima de existencias en el art&iacute;culo.
	 */
	private int cantidadMinima;
	/**
	 * Existencias del art&iacute;culo en la despensa.
	 */
	private int existencias;

	/**
	 * Constructor de art&iacute;culo.
	 * 
	 * @param nombre
	 *            Nombre del art&iacute;culo.
	 * @param cantidadMinima
	 *            Cantidad m&iacute;nima de existencias en el art&iacute;culo.
	 * @param existencias
	 *            Existencias del art&iacute;culo en la despensa.
	 * @throws NombreNoValidoException
	 *             Cuando el nombre no es v&aacute;lido.
	 * @throws ExistenciasNegativasException
	 *             Cuando las existencias son negativas.
	 * @throws MinimoExistenciasNegativasException
	 *             Cuando el m&iacute;nimo de existencias son negativas.
	 */
	Articulo(String nombre, int cantidadMinima, int existencias)
			throws NombreNoValidoException, ExistenciasNegativasException, MinimoExistenciasNegativasException {
		setNombre(nombre);
		setCantidadMinima(cantidadMinima);
		setExistencias(existencias);
	}

	/**
	 * Constructor de articulo.
	 * 
	 * @param nombre
	 *            Nombre del art&iacute;culo.
	 * @throws NombreNoValidoException
	 *             Cuando el nombre no es v&aacute;lido.
	 */
	Articulo(String nombre) throws NombreNoValidoException {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el estado del campo nombre.
	 * 
	 * @param nombre
	 *            Nombre del art&iacute;culo.
	 * @throws NombreNoValidoException
	 *             Cuando el nombre no es v&aacute;lido.
	 */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if (nombre.length() == 0)
			throw new NombreNoValidoException();
		this.nombre = nombre;
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	/**
	 * Modifica el estado del campo cantidadMinima.
	 * 
	 * @param cantidadMinima
	 *            Cantidad minima del producto.
	 * @throws MinimoExistenciasNegativasException
	 *             Cuando el minimo de existencias es negativo.
	 */
	private void setCantidadMinima(int cantidadMinima) throws MinimoExistenciasNegativasException {
		if (cantidadMinima < 0)
			throw new MinimoExistenciasNegativasException();
		this.cantidadMinima = cantidadMinima;
	}

	public int getExistencias() {
		return existencias;
	}

	/**
	 * Modifica el estado del campo Existencias del articulo.
	 * 
	 * @param existencias
	 *            existencias del articulo.
	 * @throws ExistenciasNegativasException
	 *             Cuando las existencias son negativas.
	 */
	private void setExistencias(int existencias) throws ExistenciasNegativasException {
		if (existencias < 0)
			throw new ExistenciasNegativasException();
		this.existencias = existencias;
	}

	/**
	 * Disminuye la cantidad de existencias que posee el articulo.
	 * 
	 * @param cantidad
	 *            cantidad la cual disminuira las existencias del articulo.
	 * @throws ExistenciasNegativasException
	 *             Cuando las existencias son negativas.
	 */
	void consumir(int cantidad) throws ExistenciasNegativasException {
		setExistencias(getExistencias() - cantidad);
	}

	/**
	 * Comprar existencias.
	 * 
	 * @param cantidad
	 *            cantidad a comprar.
	 * @throws ExistenciasNegativasException
	 *             Cuando las existencias son negativas.
	 * @throws CantidadNegativaException
	 *             Cuando la cantidad introducida es negativa.
	 */
	void comprar(int cantidad) throws ExistenciasNegativasException, CantidadNegativaException {
		if (cantidad < 0)
			throw new CantidadNegativaException();
		setExistencias(getExistencias() + cantidad);
	}

	/**
	 * Modifica las existencias minimas del articulo.
	 * 
	 * @param minimoExistencias
	 *            Nuevas existencias minimas.
	 * @throws MinimoExistenciasNegativasException
	 *             Cuando las existencias minimas introducidas son negativas.
	 */
	void modificarExistenciasMinimas(int minimoExistencias) throws MinimoExistenciasNegativasException {
		if (minimoExistencias < 0)
			throw new MinimoExistenciasNegativasException();
		setCantidadMinima(minimoExistencias);
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

	/**
	 * Muestra el articulo.
	 */
	@Override
	public String toString() {
		return "\n\tNombre: " + nombre + "\n\tCantidad m�nima: " + cantidadMinima + "\n\tExistencias: " + existencias;
	}
}
