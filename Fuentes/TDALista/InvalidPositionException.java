package TDALista;
/**
 * Clase InvalidPositionException, extiende a Exception.
 * Maneja una excepción de tipo posición inválida.
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