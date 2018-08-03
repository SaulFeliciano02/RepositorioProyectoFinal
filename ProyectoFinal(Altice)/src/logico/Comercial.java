package logico;


public class Comercial extends PersonalAuto {

	public Comercial(String cedula, String nombre, String direccion, String telefono, char[] contraseñaConfirmar, Float sueldo) {
		super(cedula, nombre, direccion, telefono, contraseñaConfirmar, sueldo);
	
		this.sueldo= sueldo;
		this.contraseña = contraseñaConfirmar;
	}
	
	

	
	
}
