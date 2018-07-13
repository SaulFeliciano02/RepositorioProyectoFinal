package logico;

public class Persona {
	
	protected String cedula;
	protected String nombre;
	protected String direccion;
	protected String telefono;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Persona(String cedula, String nombre, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	float CalcularSalario() {
		// TODO Auto-generated method stub
		
		
		
		public static void main(String[]args){
			
			double sueldohora=0;
			int horasextras=0;
			double sueldohe=0;
			double impuestos=0;
			int hrstrabajadas=0;
			double sueldo=0;
			double sueldofinal=0;
			
			if(hrstrabajadas>40){
				horasextras=hrstrabajadas-40;
			}
			sueldohe=horasextras*sueldohora*2;
			sueldo=sueldohora*(hrstrabajadas+horasextras);
			
			if(sueldo>=20000){
				impuestos=sueldo*0.25;
			}
			
			if(sueldo>=15000){
				impuestos=sueldo*0.20;
			}
			
			if(sueldo>=10000){
				impuestos=sueldo*0.15;
			}
			
			sueldofinal=
		}
		return 0;
	}

}
