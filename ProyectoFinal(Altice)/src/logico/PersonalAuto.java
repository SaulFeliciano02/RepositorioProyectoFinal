package logico;

public abstract class PersonalAuto extends Persona {
	
	protected double sueldohora=0;
	protected int horasextras=0;
	protected double sueldohe=0;
	protected double impuestos=0;
	protected int hrstrabajadas=0;
	protected double sueldo=0;
	protected double sueldofinal=0;
	protected String contraseña;

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
			int horasextras, double impuestos, int hrstrabajadas, String contraseña) {
		super(cedula, nombre, direccion, telefono);
		this.horasextras = horasextras;
		this.impuestos = impuestos;
		this.hrstrabajadas = hrstrabajadas;
		this.contraseña = contraseña;
	}

	public String getContraseña() {
		return contraseña;
	}

	public double getSueldohora() {
		return sueldohora;
	}

	public int getHorasextras() {
		return horasextras;
	}

	public double getSueldohe() {
		return sueldohe;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public int getHrstrabajadas() {
		return hrstrabajadas;
	}

	public double getSueldo() {
		return sueldo;
	}

	public double getSueldofinal() {
		return sueldofinal;
	}
		
	

}
