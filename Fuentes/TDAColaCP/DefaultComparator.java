package TDAColaCP;
/**
 * Clase DefaultComparator extiende a Comparable e implementa a Comparator
 * devuelve cero si son iguales, menor a cero si a es mayor a b y mayor a cero si a es menor que b.
 * @author Coscia julián.
 */
public class DefaultComparator <E extends Comparable<E>> implements java.util.Comparator<E>{
	public int compare(E a, E b) {
		return a.compareTo(b);
	}
}
