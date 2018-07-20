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
	
	public PersonalAdministra(String cedula, String nombre, String direccion, String telefono, int horasextras,
			double impuestos, int hrstrabajadas, String contraseña) {
		super(cedula, nombre, direccion, telefono, horasextras, impuestos, hrstrabajadas, contraseña);
		
		this.sueldo = 20000;
	}
	
	

}
