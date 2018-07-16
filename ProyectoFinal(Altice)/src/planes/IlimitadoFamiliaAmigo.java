package planes;

public class IlimitadoFamiliaAmigo extends PlanMovil {

	public IlimitadoFamiliaAmigo(float precioPlan, String roaming) {
		super(precioPlan);
		this.roaming = roaming;
	}


	public IlimitadoFamiliaAmigo(float precioPlan) {
		super(precioPlan);
		
	}
	
	private String roaming = "Roaming USA incluido";

	public String getRoaming() {
		return roaming;
	}


	public void setRoaming(String roaming) {
		this.roaming = roaming;
	} 
	
	
	
	
	/*public abstract precioCantLineas;
	
	
	 */
	
	
}
