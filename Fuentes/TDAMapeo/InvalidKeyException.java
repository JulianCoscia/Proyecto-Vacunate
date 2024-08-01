package TDAMapeo;

/**
 * Clase InvalidKeyException, extiende la clase Exception de java.
 * Maneja una excepcion del tipo clave inválida.
 * 
 * @author Coscia julian.
 *
 */
public class InvalidKeyException extends Exception {

//____Constructor____
	/**
	 * Inicializa una InvalidKeyException con los datos pasados por parametro.
	 */
public InvalidKeyException (String msg) {
	super(msg);
}

}//Fin de la clase.