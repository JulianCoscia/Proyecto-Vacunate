package TDAColaCP;

/**
 * Clase EmptyPriorityQueueException.
 * Extiende la clase Exception.
 * Maneja un error de tipo cola con prioridad vacía
 * @author Coscia Julian.
 */
public class EmptyPriorityQueueException extends Exception {
//____Constructores____
/**
 * Inicializa una EmptyPriorityQueueException con los datos pasados por parametro.
 */
public EmptyPriorityQueueException(String msg) {
	super(msg);
}
}
