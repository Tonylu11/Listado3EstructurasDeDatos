package claseConGenerics;

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
public class TestClaseConGenerics {
	static Animal animal;

	public static void main(String[] args) {
		ClaseConGenerics<Animal> zoologico = new ClaseConGenerics<Animal>();
		try {
			animal = new Animal("Pico", "Akita");
			zoologico.metodo1(animal);
			System.out.println(zoologico);
			System.out.println("Mostrando al animal en la posición 1: " + zoologico.metodo2());
		} catch (NombreInvalidoException e) {
			System.err.println("El nombre no es válido..");
		} catch (RazaInvalidaException e) {
			System.err.println("La raza no es válida..");
		} catch (AnimalYaExisteException e) {
			System.err.println("El animal ya existe en el zoológico..");
		} catch (ZoologicoVacioException e) {
			System.err.println("El zoológico no contiene ningún animal..");
		}
	}
}