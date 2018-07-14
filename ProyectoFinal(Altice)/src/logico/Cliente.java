package logico;

public class Cliente extends Persona {
	
	;
	private Plan planesDisponibles;
	private ArrayList<Factura>misFacturas;
	private String estado;
	
	
	/**
	 * @param cedula
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param planesDisponibles
	 * @param misFacturas
	 * @param estado
	 */
	public Cliente(String cedula, String nombre, String direccion, String telefono, Plan planesDisponibles,
			ArrayList<Factura> misFacturas, String estado) {
		super(cedula, nombre, direccion, telefono);
		
		this.planesDisponibles = planesDisponibles;
		this.misFacturas = misFacturas;
		this.estado = estado;
	}

	
	
	
	public Plan getMisPlames() {
		return planesDisponibles;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public String getEstado() {
		return estado;
	}
	
	public void agregarPlan(Plan aux)
	{
		planesDisponibles.add(aux);
	}
	
	
	
	public static float mora(){
		Factura ffactura=null;
		float retor=0;
		int x;
		float monto=0;
		
		int num[]=new int[2];
		while(retor!=0){
			if(misFacturas.size()==0){
				return 0;
			}
			else{
				if(retor==num[x]){
					 ffacturas = misFacturas.get(x);
					 boolean estado=false;
					 
					 if(x==1){
						 monto=(montoTotal()*5)/100;
					 }
					 
					 if(x==2){
						 monto=((montoTotal*2)*5)/100;
					 }
					 
					 if(x==3){
						 monto=((montoTotal*3)*5)/100;
						 
						 int elemento,i,j;
						 boolean resultado = false;
					        for (int x = 0; x < Plan.length; i++) {
					            if (Plan[i] == elemento) {
					                for (int j = i; j < arreglo.length - 1; j++) {
					                    Plan[j] = plan[j+1];
					                }
					                plan[plan.length - 1] = 0;
					                resultado = true;
					            }
					        }
					        
					    }
					 }
				}
			}
		 return mora();
		}
	 
	public  float DeudaTotal(){
		float DineroaDeber=0;
		 Factura u;
		u.getMontoTotal();
		
		DineroaDeber=(u.getMontoTotal()*mora());
		
		return DeudaTotal();
	}
	
	




		
	
	}
	

	
	

	

	


	


	
	
	
	
	

	
	
	