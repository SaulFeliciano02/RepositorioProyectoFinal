package logico;

public class CV extends Cuenta {
	
	private int tiempoAhorro;
	private float montoMensual;
	
	public CV(String codigo, int mesesA, int diaCorte, String estado, int tiempoAhorro, float montoMensual) {
		super(codigo, mesesA, diaCorte, estado);
		this.tiempoAhorro = tiempoAhorro;
		this.montoMensual = montoMensual;
	}
	

	public int getTiempoAhorro() {
		return tiempoAhorro;
	}



	public void setTiempoAhorro(int tiempoAhorro) {
		this.tiempoAhorro = tiempoAhorro;
	}



	public float getMontoMensual() {
		return montoMensual;
	}



	public void setMontoMensual(float montoMensual) {
		this.montoMensual = montoMensual;
	}



	@Override
	boolean PermisoRetiro(float dinero) {
		
		boolean permiso = false;
		
		return permiso;
	}

	@Override
	float CalcularIntereses() {
		
		float interes = 0;
		
		interes = (montoMensual*mesesA)*0.3f;
		
		return interes;
	}

}
