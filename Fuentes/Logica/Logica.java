package Logica;

import TDAColaCP.*;
import TDAColaCP.Entrada;
import TDAColaCP.Entry;
import TDAColaCP.InvalidKeyException;
import TDALista.*;
import TDAMapeo.*;
import TDAPila.*;

public class Logica {
//Atributos de clase
private CCP_Con_Lista<Integer, Persona> cola;
private MapeoConHashAbierto<Integer, Persona> historial;

//____Constructor____	
/**
 * Inicializa una nueva Logica vacia.
 */
public Logica () {
	cola = new CCP_Con_Lista<Integer, Persona>();
	historial = new MapeoConHashAbierto<Integer, Persona>();
}

//____Metodos____
/**
 * Inscribir. Agrega un nuevo paciente a la cola.
 * @param apellido Apellido del paciente.
 * @param nombre Nombre del paciente.
 * @param DNI DNI del paciente.
 * @param GdR Grupo de riesgo del paciente.
 * @return True si la inscripcion fue exitosa-False si el paciente ya estaba inscripto.
 */
public boolean inscribir(String apellido, String nombre, int DNI, int GdR) {
Persona nuevo = new Persona (apellido, nombre, DNI);
boolean salida = false;
TDAColaCP.Entry<Integer, Persona> entrada;

	try {
		entrada = cola.insert(GdR, nuevo);
		
		if (entrada != null)
			salida = true;
		} 
	catch (TDAColaCP.InvalidKeyException e) {
		e.printStackTrace();}

return salida;
}

/**
 * Devuelve al paciente mas riesgoso que se encuentre en la cola.
 * @return Paciente mas riesgoso.
 */
public Persona pacienteMasRiesgoso() {
Persona salida = null;

	try {
		if (!cola.isEmpty())			
			salida = cola.min().getValue();
		
	} catch (EmptyPriorityQueueException e) {
		e.printStackTrace();
	}
return salida;
}

/**
 * Elimina de la cola un paciente.
 * @param dni DNI del paciente.
 * @return Paciente eliminado
 */
public Persona eliminarPaciente (int dni) {
Persona salida = null;
boolean elimine = false;
Entrada<Integer, Persona> entrada = null;
PositionList<Entrada<Integer, Persona>> guardarDatos = new ListaDoblementeEnlazada<TDAColaCP.Entrada<Integer, Persona>>();

if (!cola.isEmpty())
{	try {
	//Busco a la persona con el dni en la cola con prioridad, eliminando entradas de la cola para almacenarlas en una lista y luego devolverlas a la cola.
	while (!elimine)
		{entrada = (Entrada<Integer, Persona>) cola.removeMin();
	
		if (entrada.getValue().getDNI() == dni)
			{elimine = true;
			 historial.put(entrada.getValue().getDNI(), entrada.getValue()); //Aca esta el error de eliminar
			  salida = entrada.getValue();}
		else
			guardarDatos.addLast(entrada);
		}
	
	//Devuelvo las entradas a la cola con prioridad
	while (!guardarDatos.isEmpty())
		cola.insert(guardarDatos.last().element().getKey(), guardarDatos.last().element().getValue());
	
	
	} catch (EmptyPriorityQueueException | InvalidKeyException | EmptyListException | TDAMapeo.InvalidKeyException e) {
		e.printStackTrace();
	}
}	
return salida;
}

/**
 * Devuelve una lista de los pacientes que estan en la cola segun su prioridad.
 * @return Lista con pacientes.
 */
public PositionList<Persona> listaDePacientes() {
PositionList<Persona> salida = new ListaDoblementeEnlazada<Persona>();
PositionList<Entry<Integer, Persona>> guardarDatos = new ListaDoblementeEnlazada<TDAColaCP.Entry<Integer, Persona>>();
Entry <Integer, Persona> entrada = new Entrada<Integer, Persona>(0, null);

if (!cola.isEmpty())
{	try {
	//Desarmo la cola con prioridad para agregar los pacientes a la lista de salida y a la lista que guarda los datos que elimino de la cola.
	while (entrada != null)
		{entrada = cola.removeMin();
		 guardarDatos.addLast(entrada);
		 salida.addLast(entrada.getValue());}
	
	//Devuelvo las entradas a la cola con prioridad
	while (!guardarDatos.isEmpty())
		cola.insert(guardarDatos.last().element().getKey(), guardarDatos.last().element().getValue());
	
	
	} catch (EmptyPriorityQueueException | InvalidKeyException | EmptyListException e) {
		e.printStackTrace();
	}
	
}
return salida;
}

/**
 * Devuelve una lista de pacientes que estan en la cola pero con su prioridad invertida
 * @return Lista con pacientes.
 */
public PositionList<Persona> listaDePacientesInvertida() {
Stack<Persona> pila = new PilaConEnlaces<Persona>();
PositionList<Persona> salida = new ListaDoblementeEnlazada<Persona>();
PositionList<Entry<Integer, Persona>> guardarDatos = new ListaDoblementeEnlazada<TDAColaCP.Entry<Integer, Persona>>();
Entry<Integer, Persona> entrada = new Entrada<Integer, Persona>(0, null);

if (!cola.isEmpty())
{	try {
	//Desarmo la cola con prioridad para agregar los pacientes a la pila y a la lista que guarda los datos que elimino de la cola.
		while (entrada != null)
			{entrada = cola.removeMin();
			 guardarDatos.addLast(entrada);
			 pila.push(entrada.getValue());}
		
		//Devuelvo las entradas a la cola con prioridad
		while (!guardarDatos.isEmpty())
			cola.insert(guardarDatos.last().element().getKey(), guardarDatos.last().element().getValue());
	
		//Guardo los datos de la pila en la lista de salida de forma que saldran invertidos.
		while (!pila.isEmpty())	
			salida.addLast(pila.pop());

	} catch (EmptyStackException | InvalidKeyException | EmptyListException | EmptyPriorityQueueException e1) {
		e1.printStackTrace();
	}
}
return salida;	
}

/**
 * Devuelve una lista con todos los pacientes que se han inscripto.
 * @return Historial con pacientes
 */
public PositionList<Persona> historialDePacientes() { //Es infinito porque no llega nunca. osea no sale nada en admin
PositionList<Persona> salida = new ListaDoblementeEnlazada<Persona>();

for (TDAMapeo.Entry<Integer, Persona> a:historial.entries())
	salida.addLast(a.getValue());
	
return salida;
}

}//Fin de la clase
