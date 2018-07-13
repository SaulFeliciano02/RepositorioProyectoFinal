package logico;

import java.util.ArrayList;

public class PersonalAdministra extends PersonalAuto {
	
	
	
	        protected double sueldohora=0;
            
			protected int horasextras=0;
			protected double sueldohe=0;
			protected double impuestos=0;
			protected int hrstrabajadas=0;
			protected double sueldo=0;
			protected double sueldofinal=0;
			private ArrayList<Cliente> misClientes;
			private static int cantC;
			
			
	/**
			 * @param cedula
			 * @param nombre
			 * @param direccion
			 * @param telefono
			 * @param salario
			 * @param sueldohora
			 * @param horasextras
			 * @param sueldohe
			 * @param impuestos
			 * @param hrstrabajadas
			 * @param sueldo
			 * @param sueldofinal
			 * @param misClientes
			 */
			public PersonalAdministra(String cedula, String nombre, String direccion, String telefono, float salario,
					double sueldohora, int horasextras, double sueldohe, double impuestos, int hrstrabajadas,
					double sueldo, double sueldofinal, ArrayList<Cliente> misClientes) {
				super(cedula, nombre, direccion, telefono, salario);
				this.sueldohora = sueldohora;
				this.horasextras = horasextras;
				this.sueldohe = sueldohe;
				this.impuestos = impuestos;
				this.hrstrabajadas = hrstrabajadas;
				this.sueldo = sueldo;
				this.sueldofinal = sueldofinal;
				this.misClientes = misClientes;
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

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public static int getCantC() {
		return cantC;
	}
	
			
	
	
	public void insertCliente(Cliente aux){
		misClientes.add(aux);
	}
	
	public Cliente buscarCliente(String nombre){
		Cliente aux =null;
		boolean encontrado = false;
		int i=0;
        while (!encontrado && i<cantC) {
			if(misClientes.get(i).getCedula().equalsIgnoreCase(nombre)){
				aux=misClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	@Override
	float CalcularSalario() {
		// TODO Auto-generated method stub
		
      
			 float salariototal = 0;
			
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
			
			sueldofinal=sueldo-impuestos;
		
		
		return salariototal;
	}

	public boolean hacerPlan(String nombre){
		boolean hacer = false;
		Plan aux = buscarPlan(nombre);
		if(aux!=null){
		  if(aux.cedula() && aux.getmisClientes()){
			  hacer = true;
		  }
		}
				
		return hacer;		
		
	}

	



	

	
	
	

}
