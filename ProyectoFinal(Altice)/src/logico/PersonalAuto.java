package logico;

public abstract class PersonalAuto extends Persona {
	
	protected double sueldo=0;
	
	protected String contrase�a;

	/**
	 * @param cedula
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param salario
	 */
	
	
	public float CalcularSalario(){
		 
		 return 0;
	 }

	/**
	 * @param cedula
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param sueldohora
	 * @param horasextras
	 * @param sueldohe
	 * @param impuestos
	 * @param hrstrabajadas
	 * @param sueldo
	 * @param sueldofinal
	 */
	
	public PersonalAuto(String cedula, String nombre, String direccion, String telefono,
			 String contrase�a) {
		super(cedula, nombre, direccion, telefono);
		
		this.contrase�a = contrase�a;
	}

	
	public String getContrase�a() {
		return contrase�a;
	}



	public double getSueldo() {
		return sueldo;
	}

	

}
