package planes;

public class ProHD extends IlimitadoPRO {

	public ProHD(float precioPlan, String roaming, String cantInternet, int cantMinuto) {
		super(precioPlan, roaming, cantInternet, cantMinuto);
		
		this.cantMinuto = 100;
		this.precioPlan = 2299;
		
		
		
		
	}

	/*
	public float precioXMinuto() {
		
		return precioMinuto;
	}
	
	*/

}
