package claseConGenerics;

import java.util.ArrayList;

/**
 * Reproduce una clase con Generics. Llámala ClaseConGenerics . Entrega su
 * esqueleto donde: a. Definas una variable de objeto . Ha de ser una colección
 * homogénea (del tipo parametrizado de la clase) b. Definas un constructor
 * donde instancies el atributo anterior c. Definas un método metodo1 cuyo
 * parámetro sea del tipo parametrizado d. Definas un método metodo2 cuyo valor
 * devuelto se a del tipo parametrizado
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class ClaseConGenerics {
	ArrayList<ClaseConGenerics> collectionParametrizada;

	public ClaseConGenerics() {
		collectionParametrizada = new ArrayList<ClaseConGenerics>();
	}

	void metodo1(ClaseConGenerics ccg) {
		collectionParametrizada.add(ccg);
	}

	ClaseConGenerics metodo2(ClaseConGenerics ccg) {
		return collectionParametrizada.get(0);
	}
}
