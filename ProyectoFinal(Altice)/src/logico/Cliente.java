package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import planes.Plan;

public class Cliente extends Persona implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plan planesDisponibles;
	private ArrayList<Factura> misFacturas;
	private boolean estado;
	private float deudaTotal;
	private Calendar fechaDeIngreso;
	
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
	public Cliente(String cedula, String nombre, String direccion, String telefono) {
		super(cedula, nombre, direccion, telefono);
		this.estado = true;
		this.deudaTotal=0;
		this.misFacturas = new ArrayList<>();
		this.planesDisponibles = null;
		this.fechaDeIngreso = Calendar.getInstance();
	}

	


	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}




	public Plan getPlanesDisponibles() {
		return planesDisponibles;
	}




	public void setPlanesDisponibles(Plan planesDisponibles) {
		this.planesDisponibles = planesDisponibles;
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
			setPlanesDisponibles(null);
			setEstado(false);
		}
		
		return mora;
		
		}
	 
	public  void CalcularDeudaTotal(){
		
		deudaTotal = 0;
		
		for(Factura aux: misFacturas)
			 if(!aux.isEstado())
			 {
				deudaTotal += aux.getMontoTotal();
			 }    
	}
		
		
	
	
	public void saldarmontopendiente()
	{
		
		if(deudaTotal!=0)
		{
			deudaTotal=0;
										
			setEstado(true);
			
			for (Factura factura : misFacturas) {
				factura.setEstado(true);
			}
		}
	}
	

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	




		
	
	}
	

	
	

	

	


	


	
	
	
	
	

	
	
	