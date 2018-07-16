package logico;



public class Comercial extends PersonalAuto {

	/**
	 * @param cedula
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param horasextras
	 * @param impuestos
	 * @param hrstrabajadas
	 */
	public Comercial(String cedula, String nombre, String direccion, String telefono, int horasextras, double impuestos,
			int hrstrabajadas) {
		super(cedula, nombre, direccion, telefono, horasextras, impuestos, hrstrabajadas);
		
		this.sueldo = 15000;
	}
	
}
