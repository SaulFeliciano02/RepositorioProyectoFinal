package planes;

public abstract class IlimitadoPRO extends PlanMovil {
	
	protected String roaming = "Roaming a USA incluido";
	protected String cantInternet = "Ilimitado";
	protected int cantMinuto = 100;
	
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
