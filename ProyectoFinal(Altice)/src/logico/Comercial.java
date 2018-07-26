package logico;


public class Comercial extends PersonalAuto {

	public Comercial(String cedula, String nombre, String direccion, String telefono, String contraseña, Float sueldo) {
		super(cedula, nombre, direccion, telefono, contraseña, sueldo);
	
		this.sueldo= sueldo;
		this.contraseña = contraseña;
	}
	
	

	
	
}
