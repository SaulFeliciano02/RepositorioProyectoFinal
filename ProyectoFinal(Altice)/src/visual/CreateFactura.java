package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CentralAltice;
import logico.Cliente;
import logico.Factura;
import persistivos.ArchivarCentral;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.SystemColor;


public class CreateFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Cliente miCliente;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textNomPlan;
	private JTextField textMora;
	private JTextField txtItbis;
	private JTextField textMontoPlan;
	private JTextField textCantFactuPend;
	private JTextField textMontoPagar;
	private JTextField textTelefono;
	private JTextField textCedula;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public CreateFactura(Cliente miCliente) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		setResizable(false);
		this.miCliente = miCliente;
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Futura Bk BT", Font.PLAIN, 12));
		setTitle("Registrar factura");
		setModal(true);
		setBounds(100, 100, 555, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setFont(new Font("Arial", Font.PLAIN, 13));
			lblCdula.setBounds(39, 30, 85, 29);
			panel.add(lblCdula);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
				lblNombre.setBounds(39, 60, 85, 29);
				panel.add(lblNombre);
			}
			{
				JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
				lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
				lblTelefono.setBounds(39, 130, 85, 29);
				panel.add(lblTelefono);
			}
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
				lblDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
				lblDireccion.setBounds(39, 93, 104, 29);
				panel.add(lblDireccion);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 435, 520, 45);
				panel.add(buttonPane);
				{
					JButton btnPagar = new JButton("Pagar");										
					btnPagar.setBounds(307, 5, 95, 29);
					btnPagar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
					btnPagar.setForeground(Color.WHITE);
					btnPagar.setBackground(Color.BLACK);
					btnPagar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							miCliente.saldarmontopendiente();
							ArchivarCentral arch = new ArchivarCentral();
							try {
								arch.guardar(CentralAltice.getInstance());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							ListasFactura.cargartabla();
						}
					});
					buttonPane.setLayout(null);
					btnPagar.setActionCommand("OK");
					buttonPane.add(btnPagar);
					getRootPane().setDefaultButton(btnPagar);
				}
				{
					JButton btnSalir = new JButton("Salir");
					btnSalir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					btnSalir.setBounds(412, 5, 77, 29);
					btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
					btnSalir.setForeground(Color.WHITE);
					btnSalir.setBackground(Color.BLACK);
					btnSalir.setActionCommand("Cancel");
					buttonPane.add(btnSalir);
				}
			}
			
			JLabel lblResuemenDeFacturacion = new JLabel("Resumen de facturaci\u00F3n");
			lblResuemenDeFacturacion.setFont(new Font("Arial", Font.PLAIN, 13));
			lblResuemenDeFacturacion.setBounds(193, 187, 145, 14);
			panel.add(lblResuemenDeFacturacion);
			
			JLabel lblNombreDelPlan = new JLabel("Nombre del plan:");
			lblNombreDelPlan.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNombreDelPlan.setBounds(39, 233, 104, 14);
			panel.add(lblNombreDelPlan);
			
			JLabel lblMora = new JLabel("Mora:");
			lblMora.setFont(new Font("Arial", Font.PLAIN, 13));
			lblMora.setBounds(39, 263, 36, 14);
			panel.add(lblMora);
			
			JLabel lblItbis = new JLabel("Itbis:");
			lblItbis.setFont(new Font("Arial", Font.PLAIN, 13));
			lblItbis.setBounds(39, 290, 36, 14);
			panel.add(lblItbis);
			
			JLabel lblMontoDelPlan = new JLabel("Monto del plan:");
			lblMontoDelPlan.setFont(new Font("Arial", Font.PLAIN, 13));
			lblMontoDelPlan.setBounds(39, 317, 97, 14);
			panel.add(lblMontoDelPlan);
			
			JLabel lblCantidadDeFacturas = new JLabel("Cantidad de facturas pendientes:");
			lblCantidadDeFacturas.setFont(new Font("Arial", Font.PLAIN, 13));
			lblCantidadDeFacturas.setBounds(39, 347, 195, 14);
			panel.add(lblCantidadDeFacturas);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(39, 401, 224, 7);
			panel.add(separator_1);
			
			JLabel lblMontoAPagar = new JLabel("Monto a pagar:");
			lblMontoAPagar.setFont(new Font("Arial", Font.PLAIN, 13));
			lblMontoAPagar.setBounds(113, 411, 104, 14);
			panel.add(lblMontoAPagar);
			
			textNombre = new JTextField();
			textNombre.setEditable(false);
			textNombre.setEnabled(false);
			textNombre.setBackground(new Color(240, 240, 240));
			textNombre.setBorder(null);
			textNombre.setBounds(113, 34, 153, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			textNombre.setText(miCliente.getNombre());
			
			textDireccion = new JTextField();
			textDireccion.setEditable(false);
			textDireccion.setEnabled(false);
			textDireccion.setBackground(new Color(240, 240, 240));
			textDireccion.setBorder(null);
			textDireccion.setBounds(113, 97, 164, 20);
			panel.add(textDireccion);
			textDireccion.setColumns(10);
			textDireccion.setText(miCliente.getDireccion());
			
			textNomPlan = new JTextField();
			textNomPlan.setEditable(false);
			textNomPlan.setEnabled(false);
			textNomPlan.setBackground(new Color(240, 240, 240));
			textNomPlan.setBorder(null);
			textNomPlan.setBounds(160, 230, 209, 20);
			panel.add(textNomPlan);
			textNomPlan.setColumns(10);
			if(miCliente.getPlanesDisponibles() != null)
			{
				textNomPlan.setText(miCliente.getPlanesDisponibles().getClass().getSimpleName());
			}
			else
			{
				textNomPlan.setText("Anulado");
			}
			
			textMora = new JTextField();
			textMora.setEditable(false);
			textMora.setEnabled(false);
			textMora.setBackground(new Color(240, 240, 240));
			textMora.setBorder(null);
			textMora.setBounds(113, 260, 255, 20);
			panel.add(textMora);
			textMora.setColumns(10);
			textMora.setText(Float.toString(miCliente.calcularMora())); 
			
			txtItbis = new JTextField();
			txtItbis.setEditable(false);
			txtItbis.setEnabled(false);
			txtItbis.setBackground(new Color(240, 240, 240));
			txtItbis.setBorder(null);
			txtItbis.setBounds(112, 287, 257, 20);
			panel.add(txtItbis);
			txtItbis.setColumns(10);
			if(miCliente.getPlanesDisponibles()!=null)
			{
				txtItbis.setText(Float.toString((miCliente.getPlanesDisponibles().getPrecioPlan()*18)/100));	
			}
			else
			{
				txtItbis.setText("0");
			}
			
			textMontoPlan = new JTextField();
			textMontoPlan.setEditable(false);
			textMontoPlan.setEnabled(false);
			textMontoPlan.setBackground(new Color(240, 240, 240));
			textMontoPlan.setBorder(null);
			textMontoPlan.setBounds(158, 314, 215, 20);
			panel.add(textMontoPlan);
			textMontoPlan.setColumns(10);
			if(miCliente.getPlanesDisponibles()!=null)
			{
				textMontoPlan.setText(Float.toString(miCliente.getPlanesDisponibles().getPrecioPlan()));
			}
			else
			{
				textMontoPlan.setText("0");
			}
			
			textCantFactuPend = new JTextField();
			textCantFactuPend.setEditable(false);
			textCantFactuPend.setEnabled(false);
			textCantFactuPend.setBackground(new Color(240, 240, 240));
			textCantFactuPend.setBorder(null);
			textCantFactuPend.setBounds(244, 344, 172, 20);
			panel.add(textCantFactuPend);
			textCantFactuPend.setColumns(10);
			textCantFactuPend.setText(cantidadDeFacturasPend());
			
			textMontoPagar = new JTextField();
			textMontoPagar.setEditable(false);
			textMontoPagar.setEnabled(false);
			textMontoPagar.setBackground(new Color(240, 240, 240));
			textMontoPagar.setBorder(null);
			textMontoPagar.setBounds(99, 382, 145, 20);
			panel.add(textMontoPagar);
			textMontoPagar.setColumns(10);
			textMontoPagar.setText(Float.toString(miCliente.getDeudaTotal()));
			
			textTelefono = new JTextField();
			textTelefono.setEditable(false);
			textTelefono.setEnabled(false);
			textTelefono.setBackground(new Color(240, 240, 240));
			textTelefono.setBorder(null);
			textTelefono.setBounds(113, 134, 164, 20);
			panel.add(textTelefono);
			textTelefono.setColumns(10);
			textTelefono.setText(miCliente.getTelefono());
			
			textCedula = new JTextField();
			textCedula.setEditable(false);
			textCedula.setEnabled(false);
			textCedula.setBackground(new Color(240, 240, 240));
			textCedula.setBorder(null);
			textCedula.setBounds(112, 64, 164, 20);
			panel.add(textCedula);
			textCedula.setColumns(10);
			textCedula.setText(miCliente.getCedula());
			
			JSeparator separator = new JSeparator();
			separator.setBounds(12, 193, 181, 2);
			panel.add(separator);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(332, 193, 195, 2);
			panel.add(separator_2);
			
		}
	}

	private String cantidadDeFacturasPend() {
		
		String cantidad = "";
		int i=0;
		
		for (Factura fac : miCliente.getMisFacturas()) {
			if(!fac.isEstado())
			{
				i++;
			}
		}
		
		cantidad = Integer.toString(i);
		
		return cantidad;
	}
}
