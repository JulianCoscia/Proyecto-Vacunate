package TDALista;
/**
 * Clase DNodo, implementa la interfaz Position.
 * @author Coscia Julian
 *
 * @param <E> Tipo del elemento a almacenar.
 */
public class DNodo<E> implements Position<E>{
//Atributos de clase
protected DNodo<E> siguiente;
protected DNodo<E> anterior;
protected E elem;


//_____Constructores______
//Primer constructor
/**
 * Inicializa un DNodo con los datos pasados por parametro
 */
public DNodo(E elem, DNodo<E> sig, DNodo<E> prev) {
	siguiente = sig;
	anterior = prev;
	this.elem = elem;
}

//Segundo constructor
/**
 * Inicializa un DNodo con los datos pasados por parametro
 */
public DNodo (E elem) {
	siguiente = null;
	anterior = null;
	this.elem = elem;
}

//Tercer constructor
/**
 * Inicializa un DNodo vacio.
 */
public DNodo () {
	siguiente = null;
	anterior = null;
	elem = null;
}

//_______Setters________

/**
 * Asigna un nodo siguiente a esta posición.
 * @param sig Nodo siguiente.
 */
public void setSiguiente(DNodo<E> sig) {
	siguiente = sig;
}

/**
 * Asigna un nodo anterior a esta posición.
 * @param prev Nodo anterior.
 */
public void setAnterior(DNodo<E> prev) {
	anterior = prev;
}

/**
 * Almacena un elemento en esta posición.
 * @param x Elemento a guardar.
 */
public void setElemento(E x) {
	elem = x;
}

//_______Getters_______

/**
 * Devuelve el nodo siguiente a esta posición.
 * @return Nodo siguiente.
 */
public DNodo<E> getSiguiente(){
	return siguiente;
}

/**
 * Devuelve el nodo anterior a esta posición.
 * @return Nodo anterior.
 */
public DNodo<E> getAnterior(){
	return anterior;
}

@Override
public E element() {
	return elem;
}

}//Fin de la clase.