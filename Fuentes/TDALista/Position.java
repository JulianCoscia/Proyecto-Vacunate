package TDALista;
/**
 * Interfaz Position.
 * Representa una posición y almacena un dato.
 * @author Coscia Julian.
 *
 * @param <E> Tipo del dato a almacenar.
 */
public interface Position<E> {
	
/**
 * Devuelve el elemento guardado en esta posicion.
 * @return Elemento guardado.
 */
public E element();	
}
