package TDALista;
/**
 * Clase EmptyListException, extiende a Exception.
 * Maneja una excepci�n de tipo lista vac�a.
 * @author Coscia Julian.
 */
public class EmptyListException extends Exception {
	
//Constructor
	/**
	 * Inicializa una EmptyListException con los datos pasados por parametro.
	 */
public EmptyListException(String msg) {
	super(msg);
}

}//Fin de la clase.