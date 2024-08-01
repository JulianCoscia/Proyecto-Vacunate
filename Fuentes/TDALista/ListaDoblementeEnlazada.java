package TDALista;
import java.util.Iterator;
/**
 * Clase ListaDoblementeEnlazada, implementa la interfaz PositionList
 * con una estructura de nodos doblemente enlazados y sin nodos centinelas.
 * 
 * @author Coscia Julian.
 *
 * @param <E> Tipo del elemento a almacenar en la lista.
 */
public class ListaDoblementeEnlazada<E> implements PositionList<E>{
//Atributos de clase
protected DNodo<E> head;
protected DNodo<E> tail;
protected int cant;

//____Constructor_____
/**
 * Inicializa una lista vacia.
 */
public ListaDoblementeEnlazada() {
	head = null;
	tail = null;
	cant = 0;
}

//_____Metodos_____
@Override
public int size() {
	return cant;
}

@Override
public boolean isEmpty() {
	return head == null;
}

@Override
public Position<E> first() throws EmptyListException{
if (cant == 0)
	throw new EmptyListException("La lista está vacía.");

return head;
}

@Override
public Position<E> last() throws EmptyListException{
if (cant == 0)
	throw new EmptyListException("La lista está vacía.");

return tail;	
}

@Override
public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
DNodo<E> nodo = checkPosition(p);

if (nodo == tail)
	throw new BoundaryViolationException("No se puede pedir el siguiente a el ultimo elemento.");

return nodo.getSiguiente();
}

@Override
public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
DNodo<E> nodo = checkPosition(p);

if (nodo == head)
	throw new BoundaryViolationException("No se puede pedir el anterior a el primer elemento.");

return nodo.getAnterior();	
}

@Override
public void addFirst(E element) {
DNodo<E> nuevo = new DNodo<E>(element, head, null);

//Si la lista tiene elementos, lo agrego primero en la lista.
if (head != null)
	{head.setAnterior(nuevo);
	 head = nuevo;}
else	//Si la lista no tiene elementos, lo agrego como unico elemento.
	{head = nuevo;
	tail = nuevo;}

cant++;
}

@Override
public void addLast(E element) {
DNodo<E> nuevo = new DNodo<E>(element, null, tail);

//Si la lista tiene elementos, lo agrego ultimo en la lista.
if (tail != null)
	{tail.setSiguiente(nuevo);
	tail = nuevo;}
else
	//Si la lista no tiene elementos, lo agrego como unico elemento.
	{tail = nuevo;
	 head = nuevo;}

cant++;
}

@Override
public void addAfter(Position<E> p, E element) throws InvalidPositionException{
DNodo<E> nodo = checkPosition(p);
DNodo<E> nuevo = new DNodo<E>(element, nodo.getSiguiente(), nodo);

//Si la posicion hace referencia a la cola de la lista, lo agrego como ultimo elemento.
if (nodo == tail) {
	tail.setSiguiente(nuevo);
	tail = nuevo;}
else 
	//Si la posicion hace referencia a un elemento dentro de la lista, lo agrego en su posicion correspondiente.
   {nodo.getSiguiente().setAnterior(nuevo);
	nodo.setSiguiente(nuevo);}

cant++;
}

@Override
public void addBefore(Position<E> p, E element) throws InvalidPositionException{
DNodo<E> nodo = checkPosition(p);
DNodo<E> nuevo = new DNodo<E>(element, nodo, nodo.getAnterior());

//Si la posicion hace referencia a la cabeza de la lista, lo agrego como primer elemento.
if (nodo == head)
	{head.setAnterior(nuevo);
	 head = nuevo;}
else 
	//Si la posicion hace referencia a un elemento dentro de la lista, lo agrego en su posicion correspondiente.
   {nodo.getAnterior().setSiguiente(nuevo);
	nodo.setAnterior(nuevo);}

cant++;
}

@Override
public E remove(Position<E> p) throws InvalidPositionException{
if (cant == 0)
	throw new InvalidPositionException("La lista está vacía.");
	
DNodo<E> nodo = checkPosition(p);

//Si la lista tiene un unico elemento, elimino ese elemento.
if (cant == 1) {
	head = null;
	tail = null;}
else
	//Si la posicion a eliminar es la cola de la lista, elimino el ultimo elemento de la lista.
	if (nodo == tail) {
		nodo.getAnterior().setSiguiente(nodo.getSiguiente());
		tail = nodo.getAnterior();
		nodo.setAnterior(null);}
	else
		//Si la posicion a eliminar es la cabeza de la lista, elimino el primer elemento de la lista.
		if (nodo == head) {
			nodo.getSiguiente().setAnterior(nodo.getAnterior());
			head = nodo.getSiguiente();
			nodo.setSiguiente(null);}
		else
			//Si la posicion a eliminar esta en medio de la lista, elimino el elemento y actualizo los enlaces.
			{nodo.getAnterior().setSiguiente(nodo.getSiguiente());
			nodo.getSiguiente().setAnterior(nodo.getAnterior());}


E salida = nodo.element();
cant--;

//Elimino los datos de la posicion removida.
nodo.setSiguiente(null);
nodo.setAnterior(null);
nodo.setElemento(null);
return salida;
}

@Override
public E set(Position<E> p, E element) throws InvalidPositionException{
DNodo<E> nodo = checkPosition(p);	

E salida = nodo.element();
nodo.setElemento(element);

return salida;	
}

@Override
public Iterator<E> iterator(){
	return new ElementIterator<E>(this);
}

@Override
public Iterable<Position<E>> positions(){
PositionList<Position<E>> salida = new ListaDoblementeEnlazada<Position<E>>();

//Si la lista está vacía, devuelvo una lista vacía.
if (cant == 0) 
   return salida;

DNodo<E> puntero = head;

//Recorro toda la lista agregando las posiciones al final de la lista de salida.
while(puntero != null) {
	salida.addLast(puntero);
	puntero = puntero.getSiguiente();
}

return salida;
}

//____Metodos privados_____
/**
 * Comprueba si una posición pasada por parametro es válida.
 * @param p Posición a analizar.
 * @return Posición p casteada a DNodo.
 * @throws InvalidPositionException Si la posición es inválida.
 */
private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
if (p == null)
	throw new InvalidPositionException("La posicion no existe.");

if (p.element() == null)
	throw new InvalidPositionException("La posicion no guarda ningun dato.");

DNodo<E> salida;

try {
	
	salida = (DNodo<E>)p;}

catch (ClassCastException e) {
	throw new InvalidPositionException("Posicion invalida.");}

return salida;
}

}//Fin de la clase.