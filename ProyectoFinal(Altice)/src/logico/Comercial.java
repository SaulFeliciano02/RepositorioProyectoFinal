package logico;


public class Comercial extends PersonalAuto {

	public Comercial(String cedula, String nombre, String direccion, String telefono, char[] contrase�aConfirmar, Float sueldo) {
		super(cedula, nombre, direccion, telefono, contrase�aConfirmar, sueldo);
	
		this.sueldo= sueldo;
		this.contrase�a = contrase�aConfirmar;
	}
	
	

	
	
}
