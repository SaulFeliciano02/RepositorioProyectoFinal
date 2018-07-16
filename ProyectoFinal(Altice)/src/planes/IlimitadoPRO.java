package planes;

public class IlimitadoPRO extends PlanMovil {

	public IlimitadoPRO(float precioPlan, String roaming, String cantInternet, int cantMinuto) {
		super(precioPlan);
		this.roaming = roaming;
		this.cantInternet = cantInternet;
		this.cantMinuto = cantMinuto;
	}
	public IlimitadoPRO(float precioPlan) {
		super(precioPlan);
		
	}
	
	protected String roaming = "Roaming a USA incluido";
	protected String cantInternet = "Ilimitado";
	protected int cantMinuto;
	
	public String getRoaming() {
		return roaming;
	}
	public void setRoaming(String roaming) {
		this.roaming = roaming;
	}
	public String getCantInternet() {
		return cantInternet;
	}
	public void setCantInternet(String cantInternet) {
		this.cantInternet = cantInternet;
	}
	public int getCantMinuto() {
		return cantMinuto;
	}
	public void setCantMinuto(int cantMinuto) {
		this.cantMinuto = cantMinuto;
	}
	
	
	//protected abstract precioXminuto;
	
	

}
