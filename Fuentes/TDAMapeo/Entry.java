package TDAMapeo;
/**
 * Interfaz Entry.
 * Representa una entrada y almacena una clave  y un valor.
 * @author Coscia Julian.
 *
 * @param <K> Tipo de la clave a almacenar.
 * @param <V> Tipo del valor a almacenar.
 */
public interface Entry<K, V> {
/**
 * Retorna la clave
 * @return	Clave
 */
public K getKey();

/**
 * Retorna el valor
 * @return	Valor
 */
public V getValue();

}
