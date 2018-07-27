package planes;

public class IlimitadoAppFull extends IlimitadoApp {

	private int minutos;
	
	public IlimitadoAppFull() {
		super();
		
		this.precioPlan = 999;
		this.portabilidad = 1000;
		this.cantInternet = calcularInternet();
	}
	
	/*public float 
	 * calculoPrecioPlan(): return precioTotal;
	 */

}
