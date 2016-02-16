package claseConGenerics;

import java.util.ArrayList;
import java.util.Iterator;

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
