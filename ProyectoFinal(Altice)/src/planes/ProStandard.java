package planes;

public class ProStandard extends IlimitadoPRO {

	public ProStandard(float precioPlan, String roaming, String cantInternet, int cantMinuto) {
		super(precioPlan, roaming, cantInternet, cantMinuto);
	
		this.cantMinuto = 100;
		this.precioPlan = 1499;
		
	}
	

	/*
	public abstract precioXMinuto() {
		
		return precioMinuto;
		
	}
	*/
	

}
