package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;

import javax.swing.JLabel;
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
	public CreateFactura() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		setResizable(false);
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
			lblCdula.setBounds(39, 39, 85, 29);
			panel.add(lblCdula);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
				lblNombre.setBounds(39, 72, 85, 29);
				panel.add(lblNombre);
			}
			{
				JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
				lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
				lblTelefono.setBounds(39, 135, 85, 29);
				panel.add(lblTelefono);
			}
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
				lblDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
				lblDireccion.setBounds(39, 100, 104, 29);
				panel.add(lblDireccion);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 435, 520, 45);
				panel.add(buttonPane);
				{
					JButton btnPagar = new JButton("Pagar:");
					btnPagar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						}
						@Override
						public void mousePressed(MouseEvent e) {
						}
					});
					btnPagar.setBounds(307, 5, 95, 29);
					btnPagar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
					btnPagar.setForeground(Color.WHITE);
					btnPagar.setBackground(Color.BLACK);
					btnPagar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					buttonPane.setLayout(null);
					btnPagar.setActionCommand("OK");
					buttonPane.add(btnPagar);
					getRootPane().setDefaultButton(btnPagar);
				}
				{
					JButton btnSalir = new JButton("Salir");
					btnSalir.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						}
						@Override
						public void mousePressed(MouseEvent e) {
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
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 194, 584, 7);
			panel.add(separator);
			
			JLabel lblResuemenDeFacturacion = new JLabel("Resumen de facturaci\u00F3n:");
			lblResuemenDeFacturacion.setFont(new Font("Arial", Font.PLAIN, 13));
			lblResuemenDeFacturacion.setBounds(211, 175, 145, 14);
			panel.add(lblResuemenDeFacturacion);
			
			JLabel lblNombreDelPlan = new JLabel("Nombre del plan:");
			lblNombreDelPlan.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNombreDelPlan.setBounds(39, 212, 104, 14);
			panel.add(lblNombreDelPlan);
			
			JLabel lblMora = new JLabel("Mora:");
			lblMora.setFont(new Font("Arial", Font.PLAIN, 13));
			lblMora.setBounds(39, 237, 36, 14);
			panel.add(lblMora);
			
			JLabel lblItbis = new JLabel("Itbis:");
			lblItbis.setFont(new Font("Arial", Font.PLAIN, 13));
			lblItbis.setBounds(39, 270, 36, 14);
			panel.add(lblItbis);
			
			JLabel lblMontoDelPlan = new JLabel("Monto del plan:");
			lblMontoDelPlan.setFont(new Font("Arial", Font.PLAIN, 13));
			lblMontoDelPlan.setBounds(39, 295, 97, 14);
			panel.add(lblMontoDelPlan);
			
			JLabel lblCantidadDeFacturas = new JLabel("Cantidad de facturas pendientes:");
			lblCantidadDeFacturas.setFont(new Font("Arial", Font.PLAIN, 13));
			lblCantidadDeFacturas.setBounds(39, 320, 195, 14);
			panel.add(lblCantidadDeFacturas);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(39, 391, 224, 7);
			panel.add(separator_1);
			
			JLabel lblMontoAPagar = new JLabel("Monto a pagar:");
			lblMontoAPagar.setFont(new Font("Arial", Font.PLAIN, 13));
			lblMontoAPagar.setBounds(113, 398, 104, 14);
			panel.add(lblMontoAPagar);
			
			textNombre = new JTextField();
			textNombre.setBackground(new Color(240, 240, 240));
			textNombre.setBorder(null);
			textNombre.setBounds(123, 43, 153, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			
			textDireccion = new JTextField();
			textDireccion.setBackground(new Color(240, 240, 240));
			textDireccion.setBorder(null);
			textDireccion.setBounds(122, 104, 164, 20);
			panel.add(textDireccion);
			textDireccion.setColumns(10);
			
			textNomPlan = new JTextField();
			textNomPlan.setBackground(new Color(240, 240, 240));
			textNomPlan.setBorder(null);
			textNomPlan.setBounds(160, 209, 209, 20);
			panel.add(textNomPlan);
			textNomPlan.setColumns(10);
			
			textMora = new JTextField();
			textMora.setBackground(new Color(240, 240, 240));
			textMora.setBorder(null);
			textMora.setBounds(113, 237, 255, 20);
			panel.add(textMora);
			textMora.setColumns(10);
			
			txtItbis = new JTextField();
			txtItbis.setBackground(new Color(240, 240, 240));
			txtItbis.setBorder(null);
			txtItbis.setBounds(112, 262, 257, 20);
			panel.add(txtItbis);
			txtItbis.setColumns(10);
			
			textMontoPlan = new JTextField();
			textMontoPlan.setBackground(new Color(240, 240, 240));
			textMontoPlan.setBorder(null);
			textMontoPlan.setBounds(158, 292, 215, 20);
			panel.add(textMontoPlan);
			textMontoPlan.setColumns(10);
			
			textCantFactuPend = new JTextField();
			textCantFactuPend.setBackground(new Color(240, 240, 240));
			textCantFactuPend.setBorder(null);
			textCantFactuPend.setBounds(244, 327, 172, 20);
			panel.add(textCantFactuPend);
			textCantFactuPend.setColumns(10);
			
			textMontoPagar = new JTextField();
			textMontoPagar.setBackground(new Color(240, 240, 240));
			textMontoPagar.setBorder(null);
			textMontoPagar.setBounds(34, 368, 229, 20);
			panel.add(textMontoPagar);
			textMontoPagar.setColumns(10);
			
			textTelefono = new JTextField();
			textTelefono.setBackground(new Color(240, 240, 240));
			textTelefono.setBorder(null);
			textTelefono.setBounds(123, 139, 164, 20);
			panel.add(textTelefono);
			textTelefono.setColumns(10);
			
			textCedula = new JTextField();
			textCedula.setBackground(new Color(240, 240, 240));
			textCedula.setBorder(null);
			textCedula.setBounds(112, 76, 164, 20);
			panel.add(textCedula);
			textCedula.setColumns(10);
			
			
		}
	}
}
