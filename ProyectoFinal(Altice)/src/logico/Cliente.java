package logico;

public class Cliente extends Persona {
	
	;
	private Plan[] planesDisponibles;
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
	public Cliente(String cedula, String nombre, String direccion, String telefono, Plan[] planesDisponibles,
			ArrayList<Factura> misFacturas, String estado) {
		super(cedula, nombre, direccion, telefono);
		
		this.planesDisponibles = planesDisponibles;
		this.misFacturas = misFacturas;
		this.estado = estado;
	}

	
	
	
	public Plan[] getMisPlames() {
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
	
	public Plan buscarPlan(String nombre)
	{
		int i = 0;
		boolean encontrado = false;
		Plan aux = null;
		
		while(i<misPlanesDisponibles.size() && !encontrado)
		{
			if(misPlanesDisponibles.get(i).getCodigo().equalsIgnoreCase(nombre))
			{
				encontrado = true;
				aux = misPlanesDisponibles.get(i);
			}
			i++;
		}
		return aux;
	}
	
	
	public Factura buscarFactura(String codfactura)
	{
		int i = 0;
		boolean encontrado = false;
		Cuenta aux = null;
		
		while(i<misFacturas.size() && !encontrado)
		{
			if(misFacturas.get(i).getNombre().equalsIgnoreCase(codfactura))
			{
				encontrado = true;
				aux = misFacturas.get(i);
			}
			i++;
		}
		return aux;
	}
	
	
	public void IngresarDinero(String codfactura, float monto)
	{
		
		Factura aux = buscarFactura,add(codfactura);
		
		aux.IngresarMonto(monto);
		
	}
	
	
	public static float mora(String[]arg){
		Factura ffactura=null;
		float retor=0;
		int x;
		
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
						 monto1=(montototal*5)/100;
					 }
					 
					 if(x==2){
						 monto2=((montototal*2)*5)/100;
					 }
					 
					 if(x==3){
						 monto3=((montototal*3)*5)/100;
						 
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
					        return 0;
					    }
					 }
				}
			}
		}
	
	
	
	}
	

	
	

	

	


	


	
	
	
	
	

	
	
	