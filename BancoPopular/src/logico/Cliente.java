package logico;

import java.util.ArrayList;

public class Cliente {
	
	private String cedula;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private ArrayList<Cuenta> misCuentas;
	
	public Cliente(String cedula, String nombre, String apellidos, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		misCuentas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getCedula() {
		return cedula;
	}

	public ArrayList<Cuenta> getMisCuentas() {
		return misCuentas;
	}
	
	public Cuenta buscarCuenta(String codCuenta)
	{
		int i = 0;
		boolean encontrado = false;
		Cuenta aux = null;
		
		while(i<misCuentas.size() && !encontrado)
		{
			if(misCuentas.get(i).getCodigo().equalsIgnoreCase(codCuenta))
			{
				encontrado = true;
				aux = misCuentas.get(i);
			}
			i++;
		}
		return aux;
	}
	
	public void IngresarDinero(String codCuenta, float monto)
	{
		
		Cuenta aux = buscarCuenta(codCuenta);
		
		aux.CambiarMonto(monto);
		
	}
	
	public boolean RealizarRetiro(String codCuenta, float monto)
	{
		Cuenta aux = buscarCuenta(codCuenta);
		
		boolean retiro = aux.PermisoRetiro(monto);
		
		return retiro;
	}
	
	public float RevisionGeneral()
	{
		float monto = 0;
		
		for (Cuenta cuenta : misCuentas) {
			monto+= cuenta.RevisionMensual();
		}
		
		return monto;
	}
}
