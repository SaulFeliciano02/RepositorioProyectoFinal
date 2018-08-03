package logico;



public class PersonalAdministra extends PersonalAuto {

	/**
	 * @param cedula
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param horasextras
	 * @param impuestos
	 * @param hrstrabajadas
	 */
	
	public PersonalAdministra(String cedula, String nombre, String direccion, String telefono,  char[] contraseņaConfirmar, float sueldo) {
		super(cedula, nombre, direccion, telefono,  contraseņaConfirmar, 0);
		
		this.sueldo = sueldo;
		this.contraseņa = contraseņaConfirmar;
	}
	
	

}
