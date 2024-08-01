package TDACola;
/**
 * Clase Nodo
 * @author Coscia Julian
 */
public class Nodo<E> {
	
//Atributos de clase
private E elemento;
private Nodo<E> sig;

//________Constructores________

//Primer constructor
/**
 * Inicializa un nuevo nodo con los datos pasados por parametro.
 */
public Nodo(E elem, Nodo<E> siguiente){
	elemento = elem;
	sig = siguiente;
}

//Segundo constructor
/**
 * Inicializa un nuevo nodo con los datos pasados por parametro.
 */
public Nodo(E elem){
	elemento = elem;
	sig = null;
}

//Tercer contructor
/**
 * Inicializa un nuevo nodo vacio.
 */
public Nodo(){
	elemento = null;
	sig = null;
}

//_____Metodos______


//_____Setters______
/**
 * Guarda un elemento en el nodo.
 * @param elem Elemento a guardar.
 */
public void setElemento(E elem) {
	elemento = elem;
}

/**
 * Asigna el nodo siguiente a este nodo.
 * @param siguiente Nodo siguiente.
 */
public void setSiguiente(Nodo<E> siguiente) {
	sig = siguiente;
}



//_____Getters_______
/**
 * Devuelve el elemento guardado en el nodo.
 * @return Elemento guardado en el nodo
 */
public E getElemento() {
	return elemento;
}

/**
 * Devuelve el nodo siguiente a este nodo.
 * @return Nodo siguiente.
 */
public Nodo<E> getSiguiente(){
	return sig;
}

}//Fin de la clase