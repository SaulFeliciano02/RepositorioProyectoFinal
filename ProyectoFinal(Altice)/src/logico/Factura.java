package logico;

import java.io.Serializable;
import java.util.Date;

import planes.Plan;

public class Factura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente miCliente;
	private Plan planSeleccionado;
	private float montoTotal;
	private boolean estado;
	private Date fecha;
	
	public Factura(Cliente miCliente, Plan planSeleccionado) {
		super();
		this.miCliente = miCliente;
		this.planSeleccionado = planSeleccionado;
		this.estado = false; //False = adeudado, True = saldado
		this.fecha = new Date();
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public Plan getPlanSeleccionado() {
		return planSeleccionado;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public boolean isEstado() {
		return estado;
	}
	
	public void calcularMontoTotal()
	{
		montoTotal = planSeleccionado.getPrecioPlan() + itbis() + miCliente.calcularMora();
	}

	private float itbis() {
		
		float itbis = 0;
		
		itbis = (planSeleccionado.getPrecioPlan() * 18) / 100;
		
		return itbis;
	}

}
