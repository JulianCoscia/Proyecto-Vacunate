package TDALista;
/**
 * Clase BoundaryViolationException, extiende a Exception.
 * Maneja una excepci�n de tipo violacion de l�mites.
 * @author Coscia Julian.
 */
public class BoundaryViolationException extends Exception {

//Constructor
	/**
	 * Inicializa una BoundaryViolationException con los datos pasados por parametro.
	 */
public BoundaryViolationException (String msg) {
	super(msg);
}

}//Fin de la clase