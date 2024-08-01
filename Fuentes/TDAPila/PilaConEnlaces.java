package TDAPila;
/**
 * Clase PilaConEnlaces.
 * Implementa la interfaz Stack con una estructura de nodos simplemente enlazados.
 * @author Coscia Julian.
 *
 * @param <E> Tipo del elemento a guardar en la pila.
 */
public class PilaConEnlaces<E> implements Stack<E>{
//Atributos de clase
protected Nodo<E> head;
protected int tam;

//___Constructor___
/**
 * Inicializa una pila vacia.
 */
public PilaConEnlaces () {        
	head = null;
	tam = 0;
}
		
//_______Metodos_______
@Override
public int size() {
	return tam;		
}

@Override
public boolean isEmpty() {
	return tam == 0;
}

@Override
public E top() throws EmptyStackException{
if (head == null)
	throw new EmptyStackException("La pila esta vacia.");

return head.getElemento();
}

@Override
public void push(E element) {
Nodo<E> nuevo = new Nodo<E>(element);

//Si ya hay un nodo en el tope de la pila, apilo el nuevo nodo sobre este.
if (head != null)
	nuevo.setSiguiente(head);

head = nuevo;
tam++;
}

@Override
public E pop() throws EmptyStackException{
if (head == null)
	throw new EmptyStackException("La pila esta vacia.");	

//Guardo los datos del nodo a eliminar.
Nodo<E> salida = head;

//Elimino el nodo en el tope de la pila.
head = head.getSiguiente();
tam--;

//Devuelvo el nodo que elimine.
return salida.getElemento();
}

}//Fin de la clase