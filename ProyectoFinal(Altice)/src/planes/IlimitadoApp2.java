package planes;

public class IlimitadoApp2 extends IlimitadoApp {

	public IlimitadoApp2(float precioPlan, String minuto, String roaming) {
		super(precioPlan, minuto, roaming);
		
		this.precioPlan = 399;
		this.portabilidad = 100;
		this.bonoInternet = 100;
		this.cantInternet = calcularInternet();
		
	}
		
	
	/*public float 
	 * calculoPrecioPlan(): return precioTotal;
	 */

}
