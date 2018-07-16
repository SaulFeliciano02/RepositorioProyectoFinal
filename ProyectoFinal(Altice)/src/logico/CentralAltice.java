package logico;

import java.util.ArrayList;

import planes.Plan;

public class CentralAltice {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<PersonalAuto> miPersonal;
	private ArrayList<Plan> planesDisponibles;
	
	public CentralAltice() {
		super();
		
		this.misClientes = new ArrayList<>();
		this.miPersonal = new ArrayList<>();
		this.planesDisponibles = new ArrayList<>();
	}
	
	public void agregarCliente(Cliente aux)
	{
		misClientes.add(aux);
	}
	
	public void agregarPersonal(PersonalAuto aux)
	{
		miPersonal.add(aux);
	}
	
	public void agregarPlan(Plan aux)
	{
		planesDisponibles.add(aux);
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public ArrayList<PersonalAuto> getMiPersonal() {
		return miPersonal;
	}

	
	
	public Cliente buscarCliente(String cedula)
	{
		boolean encontrado = false;
		Cliente buscado = null;
		int i = 0;
		
		while(!encontrado && i<misClientes.size())
		{
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula))
			{
				encontrado = true;
				buscado = misClientes.get(i);
			}
			i++;
		}
		
		return buscado;
	}
	
	public PersonalAuto buscarPersonal(String cedula)
	{
		boolean encontrado = false;
		PersonalAuto buscado = null;
		int i = 0;
		
		while( i<miPersonal.size() && !encontrado)
		{
			if(miPersonal.get(i).getCedula().equalsIgnoreCase(cedula))
			{
				encontrado = true;
				buscado = miPersonal.get(i);
			}
			i++;
		}
		
		return buscado;
	}
	
	public void mostrarPlanes()
	{
		for (Plan aux : planesDisponibles) {
			System.out.println(aux.getClass().getSimpleName());
		}
	}
	
	public Plan buscarPlan(String nombre)
	{
		int i = 0;
		boolean encontrado = false;
		Plan aux = null;
		
		while(i<planesDisponibles.size() && !encontrado)
		{
			if(planesDisponibles.get(i).getClass().getSimpleName().equalsIgnoreCase(nombre))
			{
				encontrado = true;
				aux = planesDisponibles.get(i);
			}
			i++;
		}
		return aux;
	}
	
	public void IngresarDinero(String cedula, float monto)
	{
		
		Cliente aux = buscarCliente(cedula);
		
		aux.saldarmontopendiente(monto);
		
	}
	
	public void agregarFacturaDelMes()
	{
		Factura nuevaFac= null;
		
		for (Cliente aux : misClientes) {
			
			nuevaFac = new Factura(aux, aux.getPlanesDisponibles());
			
			nuevaFac.calcularMontoTotal();
			
			aux.getMisFacturas().add(nuevaFac);
			
			aux.CalcularDeudaTotal();
		}
	}
	
}
