package planes;

public class IlimitadoAppPlus extends IlimitadoApp {

	public IlimitadoAppPlus(float precioPlan, String minuto, String roaming) {
		super(precioPlan, minuto, roaming);
	
		
		this.precioPlan = 699;
		this.portabilidad = 500;
		this.bonoInternet = 500;
		this.cantInternet = calcularInternet();
		
	}
	
	
	
	
	/*public float 
	 * calculoPrecioPlan(): return precioTotal;
	 */

}
