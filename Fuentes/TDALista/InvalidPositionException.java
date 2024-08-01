package TDALista;
/**
 * Clase InvalidPositionException, extiende a Exception.
 * Maneja una excepci�n de tipo posici�n inv�lida.
 * @author Coscia Julian.
 */
public class InvalidPositionException extends Exception {
	
//Constructor	
	/**
	 * Inicializa una InvalidPositionException con los datos pasados por parametro.
	 */
public InvalidPositionException (String msg) {
	super(msg);
}

}//Fin de la clase.