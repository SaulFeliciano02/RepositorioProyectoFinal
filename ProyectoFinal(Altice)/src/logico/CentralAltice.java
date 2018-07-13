package logico;

import java.util.ArrayList;

public class CentralAltice {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<PersonalAuto> miPersonal;
	private ArrayList<Plan> planesDisponibles;
	
	public CentralAltice() {
		super();
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

	public ArrayList<Plan> getPlanesDisponibles() {
		return planesDisponibles;
	}
	
	public Cliente buscarCliente(String cedula)
	{
		boolean encontrado = false;
		Cliente buscado = null;
		int i = 0;
		
		while(!encontrado && i<misClientes.size)
		{
			if(misClientes.get(i).getCedula.equalsIgnoreCase(cedula))
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
		
		while(!encontrado && i<miPersonal.size)
		{
			if(miPersonal.get(i).getCedula.equalsIgnoreCase(cedula))
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
			System.out.println(aux.getClass.getSimpleName);
		}
	}
}
