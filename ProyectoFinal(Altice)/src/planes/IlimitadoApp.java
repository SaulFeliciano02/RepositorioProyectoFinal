package planes;

public class IlimitadoApp extends PlanMovil {

	public IlimitadoApp(float precioPlan, String minuto, String roaming) {
		super(precioPlan);
		this.minuto = minuto;
		this.roaming = roaming;
		
	}
	
	
	protected String minuto = "ilimitados los fines de semana";
	protected String roaming = "Roaming USA incluido";
	protected int portabilidad;
	protected int bonoInternet;
	protected int cantInternet;
	
	
	public String getMinuto() {
		return minuto;
	}
	public void setMinuto(String minuto) {
		this.minuto = minuto;
	}
	public String getRoaming() {
		return roaming;
	}
	public void setRoaming(String roaming) {
		this.roaming = roaming;
	}
	public int getPortabilidad() {
		return portabilidad;
	}
	public void setPortabilidad(int portabilidad) {
		this.portabilidad = portabilidad;
	}
	public int getBonoInternet() {
		return bonoInternet;
	}
	public void setBonoInternet(int bonoInternet) {
		this.bonoInternet = bonoInternet;
	}
	public int getCantInternet() {
		return cantInternet;
	}
	public void setCantInternet(int cantInternet) {
		this.cantInternet = cantInternet;
	} 
	
	
	public int calcularInternet() {
		
		int cantTotal;
		
		cantTotal = (getBonoInternet() + getPortabilidad());
		
		
		return cantTotal;
	}
	
	
	
	//abstract float calculoPrecioPlan; 
	
	//Calculo precio, ya que hay minutos de 100 hasta 200
	
	

}
