package planes;

public class ProUltraHD extends IlimitadoPRO {

	public ProUltraHD(float precioPlan, String roaming, String cantInternet, int cantMinuto) {
		super(precioPlan, roaming, cantInternet, cantMinuto);
		
		this.cantMinuto =100;
		this.precioPlan = 3299;
		
	}

	/*
	public float precioXMinuto() {
		
		return precioMinuto;
	}
	
	*/

}
