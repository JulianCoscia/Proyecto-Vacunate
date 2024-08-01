package TDAPila;
/**
 * Clase EmptyStackException, extiende a Exception.
 * Maneja una excepci�n de tipo pila vac�a.
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