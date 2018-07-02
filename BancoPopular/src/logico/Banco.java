package logico;

import java.util.ArrayList;

public class Banco {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Cuenta> misCuentas;
	private String hola; 

	public Banco() {//jjaja
		super();
		misClientes = new ArrayList<>();
		misCuentas = new ArrayList<>();
	}
	
	

	public ArrayList<Cuenta> getMisCuentas() {
		return misCuentas;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	
	public void IngresarDinero(String codCuenta, float monto, String cedula)
	{
		Cliente aux = buscarCliente(cedula);
		
		if(aux!=null)
		{
			Cuenta cuentaAux = aux.buscarCuenta(codCuenta);
			
			if(cuentaAux!=null)
			{
				cuentaAux.CambiarMonto(monto);
			}
			
		}
		
	}
	
	public boolean Retiro(String codCuenta, float monto, String cedula)
	{
		Cliente aux = buscarCliente(cedula);
		boolean retiro = false;
		
		if(aux != null)
		{
			Cuenta cuentaRetiro = aux.buscarCuenta(codCuenta);
			
			if(cuentaRetiro != null)
			{
				retiro = cuentaRetiro.PermisoRetiro(monto);
			}
		}
		
		return retiro;
	}
	
	public Cliente buscarCliente(String cedula)
	{
		int i = 0;
		boolean encontrado = false;
		Cliente aux = null;
		
		while(i<misClientes.size() && !encontrado)
		{
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula))
			{
				encontrado = true;
				aux = misClientes.get(i);
			}
			i++;
		}
		return aux;
	}
	
}
