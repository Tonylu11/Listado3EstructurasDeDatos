package claseConGenerics;

import java.util.ArrayList;
import java.util.Iterator;

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
public class ClaseConGenerics<Animal> {
	ArrayList<Animal> zoologico;

	ClaseConGenerics() {
		zoologico = new ArrayList<Animal>();
	}

	void metodo1(Animal animal) throws AnimalYaExisteException {
		if (zoologico.contains(animal))
			throw new AnimalYaExisteException();
		zoologico.add(animal);
	}

	Animal metodo2() throws ZoologicoVacioException {
		if (zoologico.isEmpty())
			throw new ZoologicoVacioException();
		return zoologico.get(0);
	}

	@Override
	public String toString() {
		Iterator<Animal> it = zoologico.iterator();
		String cadena = "";
		int i = 1;
		while (it.hasNext()) {
			cadena += "Animal " + (i++) + ": " + it.next();
		}
		return cadena;
	}

}
