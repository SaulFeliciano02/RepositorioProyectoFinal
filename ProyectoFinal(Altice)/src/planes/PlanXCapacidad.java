package planes;

public abstract class PlanXCapacidad extends InternetMovil {

	public PlanXCapacidad() {
		super();
		this.internetAdicional = 0;
	}

	
	protected int internetAdicional;


	public int getInternetAdicional() {
		return internetAdicional;
	}


	public void setInternetAdicional(int internetAdicional) {
		this.internetAdicional = internetAdicional;
	}
	
	

}
