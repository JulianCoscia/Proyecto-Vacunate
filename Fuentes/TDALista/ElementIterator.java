package TDALista;

import java.util.NoSuchElementException;
/**
 * Clase ElementIterator, implementa la interfaz Iterator de Java.
 * 
 * @author Coscia Julian.
 *
 * @param <E> Tipo del elemento a almacenado en la lista.
 */
public class ElementIterator<E> implements java.util.Iterator<E> {
//Atributos de clase
private PositionList<E> lista; 	//Lista a iterar.
private Position<E> cursor; 	//Posición del elemento.
	
//____Constructor____
/**
 * Inicializa un ElementIterator con los datos pasados por parametro. 
 */
public ElementIterator(PositionList<E> l) {
	lista = l;
	
	if (lista.isEmpty()) 
		cursor = null;
	else
		try {
			
			cursor = lista.first();
			
		} catch (EmptyListException e) {
			e.printStackTrace();
		}		
}
	
//____Metodos____

@Override
public boolean hasNext() {
	return cursor != null;
}

@Override
public E next() throws NoSuchElementException{
	if (cursor == null)
		throw new NoSuchElementException("ElementIterator::Error: No hay siguiente.");
	
	E salida = cursor.element();
	
	try {
		//Si el cursor es la ultima posición en la lista, devuelve nulo.
		//Si el cursor es una posicion dentro de la lista, devuelve la posición siguiente.
		cursor = cursor==lista.last()? null : lista.next(cursor);
		
		
	} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {			
	}
	return salida;
}

}//Fin de la clase.