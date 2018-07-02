package logico;

public class FI extends Cuenta {
	
	private float porcentajeFijo;
	
	public FI(String codigo, int mesesA, int diaCorte, String estado, float porcentajeFijo) {
		super(codigo, mesesA, diaCorte, estado);
		this.porcentajeFijo = porcentajeFijo/100;
	}

	@Override
	boolean PermisoRetiro(float dinero) {
		
		boolean permiso = false;
		
		if(getEstado().equalsIgnoreCase("habilitada"))
		{
			if(dinero>500)
			{
				dinero = dinero * 0.1f;
			}
			permiso = true;
		}
		
		
		return permiso;
	}

	public float getPorcentajeFijo() {
		return porcentajeFijo;
	}

	public void setPorcentajeFijo(float porcentajeFijo) {
		this.porcentajeFijo = porcentajeFijo;
	}

	@Override
	float CalcularIntereses() {
		
		float interes = 0;
		
		interes = porcentajeFijo*mesesA;
		
		return interes;
	}

}
