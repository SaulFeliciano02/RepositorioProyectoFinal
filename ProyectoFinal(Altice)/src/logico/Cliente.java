package logico;

import java.util.ArrayList;

import planes.Plan;

public class Cliente extends Persona {
	
	
	private Plan planesDisponibles;
	private ArrayList<Factura> misFacturas;
	private boolean estado;
	private float deudaTotal;
	
	/**
	 * @param cedula
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param planesDisponibles
	 * @param misFacturas
	 * @param estado
	 * @param pagar
	 */
	public Cliente(String cedula, String nombre, String direccion, String telefono, 
			float deudaTotal) {
		super(cedula, nombre, direccion, telefono);
		this.estado = true;
		this.deudaTotal=0;
	}




	public Plan getPlanesDisponibles() {
		return planesDisponibles;
	}




	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}




	public boolean isEstado() {
		return estado;
	}



	public float getDeudaTotal() {
		return deudaTotal;
	}




	public void agregarPlan(Plan aux)
	{
		planesDisponibles = aux;
	}
	
	
	
	
	public float calcularMora(){
		
		float mora = 0;
		float montosAPagar = 0;
		int cantFacPendientes = 0;
		
		if(misFacturas.size()!=0)
		{
			for (Factura factura : misFacturas) {
				if(factura.isEstado()==false)
				{
					montosAPagar = getDeudaTotal();
					cantFacPendientes++;
				}
			}
			
			mora = (montosAPagar*5)/100;
		}
		
		if(cantFacPendientes>=3)
		{
			planesDisponibles = null;
			setEstado(false);
		}
		
		return mora;
		
		}
	 
	public  void CalcularDeudaTotal(){
		
		
		for(Factura aux: misFacturas)
			 if(!aux.isEstado())
			 {
				deudaTotal += aux.getMontoTotal();
			 }
		     
	}
		
		
	
	
	public void saldarmontopendiente(float pagar)
	{
		
		if(deudaTotal!=0 && pagar<=deudaTotal)
		{
			deudaTotal-=pagar;
			
			if(deudaTotal==0){
				
				setEstado(true);;
			}
		}
	}
	

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	




		
	
	}
	

	
	

	

	


	


	
	
	
	
	

	
	
	