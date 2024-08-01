package Logica;
/**
 * Clase persona. Guarda los datos de una persona inscripta.
 * @author Coscia julian.
 *
 */
public class Persona {
//Atributos de clase
private String apellido;
private String nombre;
private int DNI;

//____Constructores____
/**
 * Inicializa una nueva Persona con los datos pasados por parametro.
 */
public Persona (String ap, String nom, int dni) {
apellido = ap;
nombre = nom;
DNI = dni;
}

/**
 * Inicializa una Persona vacia.
 */
public Persona() {
	this(null, null, 0);
}



//____Metodos____

//__Setters__
/**
 * Establece el apellido del paciente.
 * @param ap apellido del paciente.
 */
public void setApellido(String ap) {
	apellido = ap;
}

/**
 * Establece el nombre del paciete.
 * @param nom Nombre del paciente.
 */
public void setNombre(String nom) {
	nombre = nom;
}

/**
 * Establece el DNI del paciente.
 * @param dni DNI del paciente.
 */
public void setDNI(int dni) {
	DNI = dni;
}

//__Getters__
/**
 * Devuelve el apellido del paciente.
 * @return Apellido del paciente.
 */
public String getApellido() {
	return apellido;
}

/**
 * Devuelve el nombre del paciente.
 * @return Nombre del paciente.
 */
public String getNombre() {
	return nombre;
}

/**
 * Devuelve el DNI del paciente.
 * @return DNI del paciente.
 */
public int getDNI() {
	return DNI;
}

/**
 * Devuelve una cadena de caracteres con la informacion de la persona inscripta.
 * @return Cadena de caracteres con los datos de la persona.
 */
public String toString() {
	return "Apellido: "+apellido+", Nombre: "+nombre+"\n"+"DNI: "+DNI+"."+"\n";
}

}//Fin de la clase.