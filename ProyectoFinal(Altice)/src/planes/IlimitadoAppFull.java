package planes;

public class IlimitadoAppFull extends IlimitadoApp {

	public IlimitadoAppFull(float precioPlan, String minuto, String roaming) {
		super(precioPlan, minuto, roaming);
		
		this.precioPlan = 999;
		this.portabilidad = 1000;
		this.cantInternet = calcularInternet();
	}
	
	
	/*public float 
	 * calculoPrecioPlan(): return precioTotal;
	 */

}
