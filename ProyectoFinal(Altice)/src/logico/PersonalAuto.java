package logico;

public abstract class PersonalAuto extends Persona {
	
	protected double sueldo=0;
	
	protected char[] contrase�a;

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
			 char[] contrase�aConfirmar, float sueldo) {
		super(cedula, nombre, direccion, telefono);
		
		this.sueldo = 0;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void setContrase�a(char[] contrase�a) {
		this.contrase�a = contrase�a;
	}

	public char[] getContrase�a() {
		return contrase�a;
	}


	public double getSueldo() {
		return sueldo;
	}

	

}
