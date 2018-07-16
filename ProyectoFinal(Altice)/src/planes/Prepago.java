package planes;

public class Prepago extends PlanMovil {

	public Prepago(float precioPlan, int cantMinutos) {
		super(precioPlan);
		this.cantMinutos = cantMinutos;
	}
	
	protected int cantMinutos;

	public int getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(int cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
	
	
	

}
