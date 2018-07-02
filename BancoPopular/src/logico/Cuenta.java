package logico;

public abstract class Cuenta {
	
	protected String codigo;
	protected int mesesA;
	protected int diaCorte;
	protected String estado;
	protected int puntos;
	protected float saldo;
	protected float comision;
	
	public Cuenta(String codigo, int mesesA, int diaCorte, String estado) {
		super();
		this.codigo = codigo;
		this.mesesA = mesesA;
		this.diaCorte = diaCorte;
		this.estado = estado;
		this.comision = mesesA * 3;
	}

	public int getMesesA() {
		return mesesA;
	}

	public void setMesesA(int mesesA) {
		this.mesesA = mesesA;
	}

	public int getDiaCorte() {
		return diaCorte;
	}

	public void setDiaCorte(int diaCorte) {
		this.diaCorte = diaCorte;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getPuntos() {
		return puntos;
	}

	public float getSaldo() {
		return saldo;
	}
	
	public void CambiarMonto(float monto)
	{
		saldo += monto;
		
		puntos = (int) (getSaldo()/10);
	}
	
	abstract boolean PermisoRetiro(float dinero);
	
	public float RevisionMensual()
	{	
		saldo = getSaldo() + CalcularIntereses() - comision;
		
		return saldo;
	}

	abstract float CalcularIntereses();
}
