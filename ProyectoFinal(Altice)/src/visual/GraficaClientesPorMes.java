package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

import logico.CentralAltice;
import logico.Cliente;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GraficaClientesPorMes extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private int[] meses = {0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] anios = {0,0,0,0,0};
	private JComboBox cbxVisualizar;
	private JSpinner spnAnio;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GraficaClientesPorMes() {
		setTitle("Clientes registrados en el a\u00F1o");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 923, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		 DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		 	
	        
	        cbxVisualizar = new JComboBox();
	        cbxVisualizar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(cbxVisualizar.getSelectedIndex()==0)
	        		{
	        			spnAnio.setEnabled(false);	        			
	        		}
	        		else
	        		{
	        			spnAnio.setEnabled(true);	        			
	        		}
	        	}
	        });
	        cbxVisualizar.setForeground(Color.WHITE);
	        cbxVisualizar.setBackground(new Color(64, 64, 64));
	        cbxVisualizar.setModel(new DefaultComboBoxModel(new String[] {"Anual", "Seleccionar a\u00F1o"}));
	        cbxVisualizar.setBounds(585, 433, 130, 22);
	        panel.add(cbxVisualizar);
	        
	        spnAnio = new JSpinner();
	        spnAnio.setEnabled(false);
	        spnAnio.setModel(new SpinnerNumberModel(2018, 2018, 2022, 1));	     
	        spnAnio.setBounds(727, 433, 94, 22);
	        JSpinner.NumberEditor de_spnAnio = new JSpinner.NumberEditor(spnAnio, "####");
	        spnAnio.setEditor(de_spnAnio);
	        panel.add(spnAnio);
	           	        	        
	        JButton btnSearch = new JButton("");
	        btnSearch.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(cbxVisualizar.getSelectedIndex() == 0)
	        		{	   
	        			registrosDeClientesPorVidaDeEmpresa();
	        			line_chart_dataset.clear();
	        			line_chart_dataset.addValue(anios[0], "registro", "2018");
	        			line_chart_dataset.addValue(anios[1], "registro", "2019");
	        			line_chart_dataset.addValue(anios[2], "registro", "2020");
	        			line_chart_dataset.addValue(anios[3], "registro", "2021");
	        			line_chart_dataset.addValue(anios[4], "registro", "2022");
	        		}
	        		if(cbxVisualizar.getSelectedIndex() == 1)
	        		{		        		
	        			registrosDeClientesDeUnAño(Integer.parseInt(spnAnio.getValue().toString()));
	        			line_chart_dataset.clear();
	        		 	line_chart_dataset.addValue(meses[0], "registro", "Ene");
	        	        line_chart_dataset.addValue(meses[1], "registro", "Feb");
	        	        line_chart_dataset.addValue(meses[2], "registro", "Mar");
	        	        line_chart_dataset.addValue(meses[3], "registro", "Abr"); 
	        	        line_chart_dataset.addValue(meses[4], "registro", "May");
	        	        line_chart_dataset.addValue(meses[5], "registro", "Jun");
	        	        line_chart_dataset.addValue(meses[6], "registro", "Jul");
	        	        line_chart_dataset.addValue(meses[7], "registro", "Ago");
	        	        line_chart_dataset.addValue(meses[8], "registro", "Sep");
	        	        line_chart_dataset.addValue(meses[9], "registro", "Oct"); 
	        	        line_chart_dataset.addValue(meses[10], "registro", "Nov");
	        	        line_chart_dataset.addValue(meses[11], "registro", "Dic");
	        	 
	        		}
	        	}
	        });
	        btnSearch.setIcon(new ImageIcon(GraficaClientesPorMes.class.getResource("/ImagenesVentanaP/LupaNegra21x21.png")));
	        btnSearch.setBounds(833, 433, 40, 22);
	        panel.add(btnSearch);
	        
	        JFreeChart chart=ChartFactory.createLineChart("Ingreso anual de clientes",
	                "","Registros",line_chart_dataset,PlotOrientation.VERTICAL,
	                true,true,false);
	        panel.setLayout(null);
	        	        	      
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBackground(Color.LIGHT_GRAY);
	        chartPanel.setBounds(0, 0, 907, 420);
	        panel.add(chartPanel);
	        chartPanel.setLayout(null);
	}
	
	private void registrosDeClientesPorVidaDeEmpresa() {
		
		for (int i = 0; i < anios.length; i++) {
			anios[i] = 0;
		}
		
		for (Cliente aux : CentralAltice.getInstance().getMisClientes()) {
			
			if(aux.getFechaDeIngreso().get(Calendar.YEAR) == 2018)
			{
				anios[0]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.YEAR) == 2019)
			{
				anios[1]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.YEAR) == 2020)
			{
				anios[2]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.YEAR) == 2021)
			{
				anios[3]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.YEAR) == 2022)
			{
				anios[4]++;
			}
		}
		
	}

	private void registrosDeClientesDeUnAño(int anioSeleccionado)
	{		
		for (int i = 0; i < meses.length; i++) {
			meses[i] = 0;
		}
		
		for (Cliente aux : CentralAltice.getInstance().getMisClientes()) {
			
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 0 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[0]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 1 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[1]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 2 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[2]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 3 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[3]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 4 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[4]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 5 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[5]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 6 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[6]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 7 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[7]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 8 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[8]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 9 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[9]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 10 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[10]++;
			}
			if(aux.getFechaDeIngreso().get(Calendar.MONTH) == 11 && aux.getFechaDeIngreso().get(Calendar.YEAR) == anioSeleccionado)
			{
				meses[11]++;
			}
		}
	}
}
