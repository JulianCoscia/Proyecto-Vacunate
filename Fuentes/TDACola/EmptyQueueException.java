package TDACola;
/**
 * Clase EmptyQueueException, extiende a Exception.
 * Maneja una excepci�n de tipo cola vac�a.
 * @author Coscia Julian.
 */
public class EmptyQueueException extends Exception {
	
//Constructor
/**
 * Inicializa una EmptyQueueException con los datos pasados por parametro.
 * @param msg
 */
public 	EmptyQueueException(String msg) {
	super(msg);
}

}//Fin de la clase.