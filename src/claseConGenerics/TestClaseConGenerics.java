package claseConGenerics;

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
public class TestClaseConGenerics {
	static Animal animal;

	public static void main(String[] args) {
		ClaseConGenerics<Animal> zoologico = new ClaseConGenerics<Animal>();
		try {
			animal = new Animal("Pico", "Akita");
			zoologico.metodo1(animal);
			System.out.println(zoologico);
			System.out.println("Mostrando al animal en la posici�n 1: " + zoologico.metodo2());
		} catch (NombreInvalidoException e) {
			System.err.println("El nombre no es v�lido..");
		} catch (RazaInvalidaException e) {
			System.err.println("La raza no es v�lida..");
		} catch (AnimalYaExisteException e) {
			System.err.println("El animal ya existe en el zool�gico..");
		} catch (ZoologicoVacioException e) {
			System.err.println("El zool�gico no contiene ning�n animal..");
		}
	}
}