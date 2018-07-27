package planes;

import java.io.Serializable;

public abstract class Plan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float precioPlan;

	public float getPrecioPlan() {
		return precioPlan;
	}

	public void setPrecioPlan(float precioPlan) {
		this.precioPlan = precioPlan;
	}
	
	

}
