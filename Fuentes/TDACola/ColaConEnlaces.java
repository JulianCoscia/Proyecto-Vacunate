package TDACola;
/**
 * Clase ColaConEnlaces, implementa la interfaz Queue con una estructura de nodos simplemente enlazados.
 * @author Coscia Julian.
 *
 * @param <E> Tipo del elemento a guardar en la estructura.
 */
public class ColaConEnlaces<E> implements Queue<E>{
//Atributos de clase
protected Nodo<E> head;
protected Nodo<E> tail;
protected int cant;

//____Constructor____
/**
 * Inicializa una nueva cola vacia.
 */
public ColaConEnlaces() {
cant = 0;
head = null;
tail = null;
}

//____Metodos____
@Override
public int size() {
	return cant;}

@Override
public boolean isEmpty() {
	return head == null;}

@Override
public E front () throws EmptyQueueException{
if (head == null)
	throw new EmptyQueueException("La cola está vacía.");
			
return head.getElemento();	
}

@Override
public void enqueue (E element) {
Nodo<E> nuevo = new Nodo<E>(element);

//Si la cola está vacía, el elemento nuevo será el primero.
if (cant == 0)
	head = nuevo;
else	//Sino, sera el siguiente al ultimo elemento en la cola.
    tail.setSiguiente(nuevo);

tail = nuevo;
cant++;
}

@Override
public E dequeue() throws EmptyQueueException{
if (head == null)
	throw new EmptyQueueException("La cola esta vacia.");
		
//Guardo los datos del nodo a eliminar.
Nodo<E> salida = head;

//Elimino el nodo.
head = head.getSiguiente();
cant--;

//Si no quedan elementos en la estructura, la cola no referenciará ningún objeto.
if (cant == 0)
	tail = null;

//Retorno los datos guardados.
return salida.getElemento();
}

}//Fin de la clase