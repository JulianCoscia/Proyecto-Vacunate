package TDACola;
/**
 * Clase EmptyQueueException, extiende a Exception.
 * Maneja una excepción de tipo cola vacía.
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