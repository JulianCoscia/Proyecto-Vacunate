package TDAPila;
/**
 * Clase EmptyStackException, extiende a Exception.
 * Maneja una excepción de tipo pila vacía.
 * @author Coscia Julian.
 */
public class EmptyStackException extends Exception{

//Constructor
	/**
	 * Inicializa una EmptyStackException con los datos pasados por parametro.
	 */
public EmptyStackException (String msg) {
	super(msg);
}

}//Fin de la clase.