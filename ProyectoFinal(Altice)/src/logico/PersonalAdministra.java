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
	
	public PersonalAdministra(String cedula, String nombre, String direccion, String telefono,  String contrase�a, float sueldo) {
		super(cedula, nombre, direccion, telefono,  contrase�a, 0);
		
		this.sueldo = sueldo;
		this.contrase�a = contrase�a;
	}
	
	

}
