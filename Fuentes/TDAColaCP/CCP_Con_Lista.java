package TDAColaCP;

import TDALista.*;
/**
 * Clase Cola con prioridad. Implementa la interfaz PriorityQueue con una estructura de nodos enlazados.
 * @author Coscia Julian.
 *
 * @param <K> Clave a almacenar.
 * @param <V> Valor a almacenar.
 */
public class CCP_Con_Lista<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
//Atributos de clase
private PositionList<Entrada<K, V>> ccp;
private DefaultComparator<K> comparador;

//____Constructor____
/**
 * Inicializa una cola con prioridad con los datos pasados por parametro.
 */
public CCP_Con_Lista (DefaultComparator<K> d) {
	ccp = new ListaDoblementeEnlazada<Entrada<K, V>>();
	comparador = d;
}

/**
 * Inicializa una cola con prioridad vacia.
 */
public CCP_Con_Lista () {
	ccp = new ListaDoblementeEnlazada<Entrada<K, V>>();
	comparador = new DefaultComparator<K>();
}

@Override
public int size() {
	return ccp.size();
}

@Override
public boolean isEmpty() {
	return ccp.size() == 0;
}
@Override
public Entry<K, V> min() throws EmptyPriorityQueueException {
if (ccp.size() == 0)
	throw new EmptyPriorityQueueException("La cola esta vacia.");

Entrada<K, V> salida = null;

try {
	salida = ccp.first().element();
	
} catch (EmptyListException e) {
	e.printStackTrace();}

return salida;
}

@Override
public Entry<K,V> insert(K key, V value) throws InvalidKeyException
{
	if (key == null)
		throw new InvalidKeyException("insert(): clave nula.");
	
	Entrada<K,V> res = new Entrada<K,V>(key,value);
	
	for (Position<Entrada<K,V>> e : ccp.positions())
	{
		try
		{
			if (comparador.compare(key, e.element().getKey()) < 0)
			{
				ccp.addBefore(e, res);
				return res;
			}
		}
		catch (InvalidPositionException m)
		{
			System.out.println(m.getMessage());
		}
	}
	ccp.addLast(res);
return res;
	
}


@Override
public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
if (ccp.size() == 0)
	throw new EmptyPriorityQueueException("La cola esta vacia.");
Entry<K, V> salida = null;

	try {
		salida = ccp.remove(ccp.first());
	} catch (EmptyListException | InvalidPositionException e) {
		e.printStackTrace();}

	return salida;
}

}//Fin de la clase.