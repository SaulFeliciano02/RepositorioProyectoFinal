package logico;

public class CC extends Cuenta {
	
	private float montoMaximo;
	
	public CC(String codigo, int mesesA, int diaCorte, String estado, float montoMaximo) {
		super(codigo, mesesA, diaCorte, estado);
		this.montoMaximo = montoMaximo;  
	}

	@Override
	boolean PermisoRetiro(float dinero) {
		
		boolean permiso = false;
		
		if(estado.equalsIgnoreCase("habilitada"))
		{
			if(dinero<saldo)
			{
				permiso = true;
			}
		}
		
		return permiso;
	}

	@Override
	float CalcularIntereses() {
		
		float interes = 0;
		
		interes = montoMaximo * 0.10f;
		
		return interes;
	}

}
