package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.CentralAltice;
import logico.Cliente;
import logico.Factura;

import java.awt.Color;
import java.awt.Toolkit;

public class GraficaGanaciaEstVsGananciaReal extends JFrame {

	private JPanel contentPane;
	private float[] valorEstimado = {0,0,0,0,0,0,0,0,0,0,0,0};
	private float[] valorReal = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GraficaGanaciaEstVsGananciaReal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaGanaciaEstVsGananciaReal.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		setTitle("Ganancia estimada por mes");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 923, 509);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			calcularMontoEstimadoPorMes();
			calcularMontoRealPorMes();
			dataset.setValue(valorEstimado[0], "Estimada", "Ene");
	        dataset.setValue(valorReal[0], "Real", "Ene");
	        dataset.setValue(valorEstimado[1], "Estimada", "Feb");
	        dataset.setValue(valorReal[1], "Real", "Feb");
	        dataset.setValue(valorEstimado[2], "Estimada", "Mar");
	        dataset.setValue(valorReal[2], "Real", "Mar");
	        dataset.setValue(valorEstimado[3], "Estimada", "Abr");
	        dataset.setValue(valorReal[3], "Real", "Abr");
	        dataset.setValue(valorEstimado[4], "Estimada", "May");
	        dataset.setValue(valorReal[4], "Real", "May");
	        dataset.setValue(valorEstimado[5], "Estimada", "Jun");
	        dataset.setValue(valorReal[5], "Real", "Jun");
	        dataset.setValue(valorEstimado[6], "Estimada", "Jul");
	        dataset.setValue(valorReal[6], "Real", "Jul");
	        dataset.setValue(valorEstimado[7], "Estimada", "Ago");
	        dataset.setValue(valorReal[7], "Real", "Ago");
	        dataset.setValue(valorEstimado[8], "Estimada", "Sep");
	        dataset.setValue(valorReal[8], "Real", "Sep");
	        dataset.setValue(valorEstimado[9], "Estimada", "Oct");
	        dataset.setValue(valorReal[9], "Real", "Oct");
	        dataset.setValue(valorEstimado[10], "Estimada", "Nov");
	        dataset.setValue(valorReal[10], "Real", "Nov");
	        dataset.setValue(valorEstimado[11], "Estimada", "Dic");
	        dataset.setValue(valorReal[11], "Real", "Dic");
	        
		 JFreeChart chart = ChartFactory.createBarChart3D
			        ("Ganancia estimada VS Ganancia real","Ganancias", "Meses", 
			        dataset, PlotOrientation.VERTICAL, true,true, false);
		 ChartPanel chartPanel = new ChartPanel(chart);
	     panel.add(chartPanel);
	}
	
	private void calcularMontoEstimadoPorMes()
	{
		for (Cliente cli : CentralAltice.getInstance().getMisClientes()) {
			
			for (Factura fac : cli.getMisFacturas()) {
				
				if(fac.getFecha().get(Calendar.MONTH) == 0)
				{
					valorEstimado[0]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 1)
				{
					valorEstimado[1]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 2)
				{
					valorEstimado[2]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 3)
				{
					valorEstimado[3]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 4)
				{
					valorEstimado[4]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 5)
				{
					valorEstimado[5]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 6)
				{
					valorEstimado[6]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 7)
				{
					valorEstimado[7]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 8)
				{
					valorEstimado[8]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 9)
				{
					valorEstimado[9]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 10)
				{
					valorEstimado[10]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 11)
				{
					valorEstimado[11]+=fac.getMontoTotal();
				}
			}
		}
	}
	
	private void calcularMontoRealPorMes()
	{
		for (Cliente cli : CentralAltice.getInstance().getMisClientes()) {
			
			for (Factura fac : cli.getMisFacturas()) {
				
				if(fac.getFecha().get(Calendar.MONTH) == 0 && fac.isEstado())
				{
					valorReal[0]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 1 && fac.isEstado())
				{
					valorReal[1]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 2 && fac.isEstado())
				{
					valorReal[2]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 3 && fac.isEstado())
				{
					valorReal[3]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 4 && fac.isEstado())
				{
					valorReal[4]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 5 && fac.isEstado())
				{
					valorReal[5]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 6 && fac.isEstado())
				{
					valorReal[6]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 7 && fac.isEstado())
				{
					valorReal[7]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 8 && fac.isEstado())
				{
					valorReal[8]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 9 && fac.isEstado())
				{
					valorReal[9]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 10 && fac.isEstado())
				{
					valorReal[10]+=fac.getMontoTotal();
				}
				
				if(fac.getFecha().get(Calendar.MONTH) == 11 && fac.isEstado())
				{
					valorReal[11]+=fac.getMontoTotal();
				}
			}
		}
	}
	
}
