package TDAMapeo;

import TDALista.*;

/**
 * Clase MapeoConHashAbierto, implementa la interfaz Map con un hash abierto.
 * @author Coscia Julian.
 *
 * @param <K> Tipo de la clave almacenada.
 * @param <V> Tipo del valor almacenado.
 */
public class MapeoConHashAbierto<K, V> implements Map<K, V> {
//Atributos de clase
protected PositionList<Entrada<K, V>> [] arreglo;
protected int tamanio;
protected int cant;
private static final float factor= 0.5f;
	
//____Constructor____	
@SuppressWarnings("unchecked")
/**
 * Inicializa un mapeo vacio.
 */
public MapeoConHashAbierto () {
	cant = 0;
	tamanio = 29;
	
	arreglo = new PositionList[tamanio];
	
	for (int i = 0; i < tamanio; i++)
		arreglo[i] = new ListaDoblementeEnlazada<Entrada<K, V>>();
}
//____Constructor____	
@SuppressWarnings("unchecked")
/**
 * Inicializa un mapeo con una entrada.
 */
public MapeoConHashAbierto (K key, V value) {
	cant = 0;
	tamanio = 29;
	
	arreglo = new PositionList[tamanio];
	
	for (int i = 0; i < tamanio; i++)
		arreglo[i] = new ListaDoblementeEnlazada<Entrada<K, V>>();
	
try {
	put(key, value);
} catch (InvalidKeyException e) {
		e.printStackTrace();}
}

//______Metodos______

@Override
public int size() {
	return cant;
}

@Override
public boolean isEmpty() {
	return cant == 0;
}

@Override
public V get(K key) throws InvalidKeyException {
checkKey(key);	

boolean termine = false;
PositionList<Entrada<K, V>> lista = arreglo[key.hashCode() % tamanio];
V salida = null;
Position <Entrada<K, V>> puntero = null;
try {
	//Si la lista en el bucket no está vacía, la recorro para buscar la clave.
	if (!lista.isEmpty())
		{puntero = lista.first();
	
		//Mientras no encontre la clave
		while (!termine && puntero.element().getKey().equals(key))
			//Si no lei el ultimo elemento de la lista, avanzo al siguiente.
			if (puntero != lista.last())
				puntero = lista.next(puntero);
			else
				termine = true;
		
		//Si la clave encontrada en la lista coincide con la pasada por parametro, devuelvo su valor.
		if (puntero.element().getKey().equals(key))
			salida = puntero.element().getValue();

		}

}
catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
	e.printStackTrace();}

return salida;
}

@Override
public V put(K key, V value) throws InvalidKeyException {
checkKey(key);
PositionList<Entrada<K, V>> lista = arreglo[key.hashCode() % tamanio];
boolean termine = false;
Entrada<K, V> nuevo = new Entrada<K, V>(key, value);
Position <Entrada<K, V>> puntero = null;
V salida = null;

//Si la clave a insertar no existia antes en la lista, la agrego al final.
if (get(key) == null)
	{lista.addLast(nuevo);
	 cant++;}
else
	//Si la clave ya existia antes en la lista, la busco y reemplazo su valor.
	try {
		if (!lista.isEmpty())
		{	puntero = lista.first();
		
			//Mientras no encontre la clave
			while (!termine && puntero.element().getKey().equals(key))
				//Si no lei el ultimo elemento de la lista, avanzo al siguiente.
				if (puntero != lista.last())
					puntero = lista.next(puntero);
				else
					termine = true;
		

	
			//Si encontre la clave, reemplazo su valor.
			if (puntero.element().getKey().equals(key))
				{salida = puntero.element().getValue();
				puntero.element().setValue(value);}

		}
		
	}
	catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
		e.printStackTrace();}
	
if (cant/tamanio > factor)
	reHash();

return salida;
}

@Override
public V remove(K key) throws InvalidKeyException {
checkKey(key);
V salida = null;
boolean termine = false;
PositionList<Entrada<K, V>> lista = arreglo[key.hashCode() % tamanio];

Position <Entrada<K, V>> puntero = null;

try {//Si el mapeo no esta vacio, lo recorro para buscar la clave.
	if (!lista.isEmpty())
		{puntero = lista.first();
		
		//Mientras no encontre la clave
		while (!termine && puntero.element().getKey().equals(key))
			//Si no lei el ultimo elemento de la lista, avanzo al siguiente.
			if (puntero != lista.last())
				puntero = lista.next(puntero);
			else
				termine = true;

		
		//Si encontre la clave, guardo su valor y la elimino de la lista
		if (puntero.element().getKey().equals(key))
			{salida = puntero.element().getValue();
			 lista.remove(puntero);
			 cant--;}

		}
	
}
catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
	e.printStackTrace();}
	
return salida;
}

@Override
public Iterable<K> keys() {
PositionList<K> salida = new ListaDoblementeEnlazada<K>();

for (PositionList<Entrada<K, V>> a: arreglo)
	for (Position<Entrada<K, V>> b: a.positions())
		salida.addLast(b.element().getKey());

return salida;
}

@Override
public Iterable<V> values() {
PositionList<V> salida = new ListaDoblementeEnlazada<V>();

for (PositionList<Entrada<K, V>> a: arreglo)
	for (Position<Entrada<K, V>> b: a.positions())
		salida.addLast(b.element().getValue());

return salida;
}

@Override
public Iterable<Entry<K, V>> entries() {
PositionList<Entry<K, V>> salida = new ListaDoblementeEnlazada<Entry<K, V>>();

  if (cant != 0) 
  {
	for (PositionList<Entrada<K, V>> a: arreglo)
		for (Position<Entrada<K, V>> b: a.positions())
			salida.addLast(b.element());
   }
  
return salida;
}

//___Metodos privados___

/**
 * Metodo privado checkKey, chequea si una clave es válida.
 * @param key Clave.
 * @throws InvalidKeyException Si la clave es inválida.
 */
private void checkKey(K key) throws InvalidKeyException{
	if (key == null)
		throw new InvalidKeyException("La clave no es válida.");
	
}


/**
 * Metodo privado reHash. Incrementa la cantidad de buckets en el arreglo y copia los datos.
 */
@SuppressWarnings("unchecked")
private void reHash	() {
Iterable <Entry<K,V>> entradas= entries();
tamanio= primoSiguiente(tamanio);
cant= 0;
arreglo = new PositionList[tamanio];

	for (int i=0; i < tamanio; i++) 
		arreglo [i]= new ListaDoblementeEnlazada<Entrada<K,V>>();
	
	try {
		for (Entry<K,V> e: entradas) 
			 put(e.getKey(), e.getValue());
	
		}
	catch (InvalidKeyException e) {
		e.printStackTrace();}
}

/**
 * Metodo privado primoSiguiente. Busca el siguiente numero primo de un numero pasado por parametro.
 * @param p Numero primo.
 * @return Primo siguiente.
 */
private int primoSiguiente(int p) {
boolean primo= false;
int i= p;

	while (!primo) 
		primo= !primo(++i);
	
return i;
}

/**
 * Metodo privado primo. Chequea si un numero es primo o no.
 * @param p Numero de arranque.
 * @return True si el numero es primo. False si el numero no es primo.
 */
private boolean primo (int p) {
boolean es= false;
int i= 2;

	while ( i<= Math.sqrt(p) && !es) 
		if (p % i== 0)	
			es= true;
		else
			i++;
	
return es;
}

}//Fin de la clase.