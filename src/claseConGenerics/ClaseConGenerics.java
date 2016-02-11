package claseConGenerics;

import java.util.ArrayList;

/**
 * Reproduce una clase con Generics. Ll�mala ClaseConGenerics . Entrega su
 * esqueleto donde: a. Definas una variable de objeto . Ha de ser una colecci�n
 * homog�nea (del tipo parametrizado de la clase) b. Definas un constructor
 * donde instancies el atributo anterior c. Definas un m�todo metodo1 cuyo
 * par�metro sea del tipo parametrizado d. Definas un m�todo metodo2 cuyo valor
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
