package logico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import persistivos.ArchivarCentral;
import planes.Altice1;
import planes.Altice2;
import planes.Altice3;
import planes.Altice4;
import planes.Altice5;
import planes.Altice6;
import planes.Ilimitado1;
import planes.Ilimitado2;
import planes.Ilimitado3;
import planes.Ilimitado4;
import planes.IlimitadoApp;
import planes.IlimitadoApp2;
import planes.IlimitadoAppFull;
import planes.IlimitadoAppPlus;
import planes.PaqueticoYApp;
import planes.Plan;
import planes.PlanBasico1MBPS;
import planes.PlanBasico3MBPS;
import planes.PlanBasico5MBPS;
import planes.PlanFull1MBPS;
import planes.PlanFull5MBPS;
import planes.ProHD;
import planes.ProStandard;
import planes.ProUltraHD;
import planes.TriplePlayBasico;
import planes.TriplePlayMax;
import planes.TriplePlayMaxPlus;
import planes.TriplePlayPlus;
import planes.TriplePlaySuperior;
import planes.ilimitadoPROUltraHD;

public class CentralAltice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> misClientes;
	private ArrayList<PersonalAuto> miPersonal;
	private ArrayList<Plan> planesNoDisponibles;
	private ArrayList<Plan> planesDisponibles;
	private ArrayList<Plan> todosLosPlanes;
	private static CentralAltice central = null;
	
	private CentralAltice(){
		super();
		this.misClientes = new ArrayList<>();
		this.miPersonal = new ArrayList<>();
		this.planesDisponibles = new ArrayList<>();
		this.planesNoDisponibles = new ArrayList<>();
		this.todosLosPlanes = new ArrayList<>();
	}
	
	public static CentralAltice getInstance()
	{
		if (central == null)
		{
			central = new CentralAltice();
			central.agregarLosPlanesAlInicio();
		}
		
		return central;
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
		planesNoDisponibles.add(aux);
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public ArrayList<PersonalAuto> getMiPersonal() {
		return miPersonal;
	}

	public ArrayList<Plan> getPlanesNoDisponibles() {
		return planesNoDisponibles;
	}

	public void setPlanesNoDisponibles(ArrayList<Plan> planesNoDisponibles) {
		this.planesNoDisponibles = planesNoDisponibles;
	}

	public ArrayList<Plan> getPlanesDisponibles() {
		return planesDisponibles;
	}

	public void setPlanesDisponibles(ArrayList<Plan> planesDisponibles) {
		this.planesDisponibles = planesDisponibles;
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
		
		while(i<todosLosPlanes.size() && !encontrado)
		{
			if(todosLosPlanes.get(i).getClass().getSimpleName().equalsIgnoreCase(nombre))
			{
				encontrado = true;
				aux = todosLosPlanes.get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	/*public void IngresarDinero(String cedula, float monto)
	{
		
		Cliente aux = buscarCliente(cedula);
		
		aux.saldarmontopendiente(monto);
		
	}*/
	
	public void agregarFacturaDelMes()
	{
		Factura nuevaFac= null;
		
		for (Cliente aux : misClientes) {
			
			if(aux.getPlanesDisponibles()!=null)
			{
				nuevaFac = new Factura(aux, aux.getPlanesDisponibles());
			
				nuevaFac.calcularMontoTotal();
			
				aux.getMisFacturas().add(nuevaFac);
			
				aux.CalcularDeudaTotal();
			}
			
		}
	}
	
	public boolean chequeoDeCedula(String cedula)
	{
		boolean permiso = true;
		
		for (Cliente aux : misClientes) {
			if(aux.getCedula().equalsIgnoreCase(cedula))
			{
				permiso = false;
			}
		}
		
		if(permiso == true)
		{
			for (PersonalAuto personalAuto : miPersonal) {
				if(personalAuto.getCedula().equalsIgnoreCase(cedula))
				{
					permiso = false;
				}
			}
		}
		
		return permiso;
	}
	
	public void agregarLosPlanesAlInicio()
	{
		Plan altice1 = new Altice1();
		Plan altice2 = new Altice2();
		Plan altice3 = new Altice3();
		Plan altice4 = new Altice4();
		Plan altice5 = new Altice5();
		Plan altice6 = new Altice6();
		Plan ilimitado1 = new Ilimitado1();
		Plan ilimitado2 = new Ilimitado2();
		Plan ilimitado3 = new Ilimitado3();
		Plan ilimitado4 = new Ilimitado4();
		Plan ilimitadoApp = new IlimitadoApp2();
		Plan ilimitadoAppFull = new IlimitadoAppFull();
		Plan ilimitadoAppPlus = new IlimitadoAppPlus();
		Plan ilimitadoProUltraHD = new ilimitadoPROUltraHD();
		Plan paqueticoYApp = new PaqueticoYApp();
		Plan proHD = new ProHD();
		Plan proStandard = new ProStandard();
		Plan proUltraHD = new ProUltraHD();
		Plan basico1 = new PlanBasico1MBPS();
		Plan basico3 = new PlanBasico3MBPS();
		Plan basico5 = new PlanBasico5MBPS();
		Plan planFull1 = new PlanFull1MBPS();
		Plan planFull5 = new PlanFull5MBPS();
		Plan tpBasico = new TriplePlayBasico();
		Plan tpMax = new TriplePlayMax();
		Plan tpMaxPlus = new TriplePlayMaxPlus();
		Plan tpPlus = new TriplePlayPlus();
		Plan tpSuperior = new TriplePlaySuperior();
		
		todosLosPlanes.add(altice1);
		todosLosPlanes.add(altice2);
		todosLosPlanes.add(altice3);
		todosLosPlanes.add(altice4);
		todosLosPlanes.add(altice5);
		todosLosPlanes.add(altice6);
		todosLosPlanes.add(ilimitado1);
		todosLosPlanes.add(ilimitado2);
		todosLosPlanes.add(ilimitado3);
		todosLosPlanes.add(ilimitado4);
		todosLosPlanes.add(ilimitadoApp);
		todosLosPlanes.add(ilimitadoAppFull);
		todosLosPlanes.add(ilimitadoAppPlus);
		todosLosPlanes.add(ilimitadoProUltraHD);
		todosLosPlanes.add(paqueticoYApp);
		todosLosPlanes.add(proHD);
		todosLosPlanes.add(proStandard);
		todosLosPlanes.add(proUltraHD);
		todosLosPlanes.add(basico1);
		todosLosPlanes.add(basico3);
		todosLosPlanes.add(basico5);
		todosLosPlanes.add(planFull1);
		todosLosPlanes.add(planFull5);
		todosLosPlanes.add(tpBasico);
		todosLosPlanes.add(tpMax);
		todosLosPlanes.add(tpMaxPlus);
		todosLosPlanes.add(tpPlus);
		todosLosPlanes.add(tpSuperior);
		
		for (Plan aux : todosLosPlanes) {
			planesNoDisponibles.add(aux);
		}
	}
	
	public void recuperarMiCentral() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		if(central == null)
		{
			central = new CentralAltice();
		}
		
		ArchivarCentral archivo = new ArchivarCentral();
		central = archivo.recuperar();
	}

	public ArrayList<Plan> getTodosLosPlanes() {
		return todosLosPlanes;
	}
	
}
