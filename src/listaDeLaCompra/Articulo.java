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
