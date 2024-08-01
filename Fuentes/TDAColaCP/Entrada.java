package TDAColaCP;

/**
 * Clase Entrada, implementa la interfaz Entry.
 * @author Coscia julian.
 *
 * @param <K> Tipo de la clave almacenada.
 * @param <V> Tipo del valor almacenado.
 */
public class Entrada<K, V> implements Entry<K, V> {
//Atributos de clase
private K key;
private V value;

//____Constructor____
/**
 * Inicializa una nueva entrada con los datos pasados por parametro.
 */
public Entrada (K clave, V valor) {
	key = clave;
	value = valor;
}

//___Setters___
/**
 * Guarda una clave en una entrada.
 * @param clave Clave a guardar.
 */
public void setKey(K clave) {
	key = clave;
}

/**
 * Guarda un valor en una entrada.
 * @param valor Valor a guardar.
 */
public void setValue(V valor) {
	value = valor;
}

//___Getters___

/**
 * Devuelve la clave de una entrada.
 * @return Clave de la entrada.
 */
public K getKey() {
	return key;
}

/**
 * Devuelve el valor de una entrada.
 * @return Valor de la entrada.
 */
public V getValue() {
	return value;
}

/**
 * Devuelve una cadena de caracteres con la informacion de la entrada.
 * @return Cadena de caracteres con la clave y el valor de la entrada. 
 */
public String toString() {
	return "("+key+", "+value+")";
}

}//Fin de la clase