package logico;


public class Comercial extends PersonalAuto {

	public Comercial(String cedula, String nombre, String direccion, String telefono, char[] contraseņaConfirmar, Float sueldo) {
		super(cedula, nombre, direccion, telefono, contraseņaConfirmar, sueldo);
	
		this.sueldo= sueldo;
		this.contraseņa = contraseņaConfirmar;
	}
	
	

	
	
}
