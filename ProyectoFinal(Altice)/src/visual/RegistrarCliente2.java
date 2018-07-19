package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logico.CentralAltice;
import logico.Cliente;
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

public class RegistrarCliente2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private Cliente miCliente;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException
	 */
	public RegistrarCliente2(String title, Cliente miCliente) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		this.miCliente = miCliente;
		setTitle(title);
		setResizable(false);
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Futura Bk BT", Font.PLAIN, 12));
		setTitle("Registro de Cliente");
		setModal(true);
		setBounds(100, 100, 610, 352);
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
			lblCdula.setFont(new Font("Arial", Font.PLAIN, 18));
			lblCdula.setBounds(87, 38, 85, 29);
			panel.add(lblCdula);
			
			txtCedula = new JTextField();
			txtCedula.setForeground(Color.WHITE);
			txtCedula.setBackground(Color.BLACK);
			txtCedula.setBounds(87, 73, 116, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			if(miCliente!=null)
			{
				txtCedula.setEnabled(false);
				txtCedula.setText(miCliente.getCedula());
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
				lblNombre.setBounds(355, 38, 85, 29);
				panel.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setForeground(Color.WHITE);
				txtNombre.setBackground(Color.BLACK);
				txtNombre.setBounds(355, 73, 116, 22);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
				if(miCliente!=null)
				{
					txtNombre.setText(miCliente.getNombre());
				}
			}
			{
				JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
				lblTelefono.setFont(new Font("Arial", Font.PLAIN, 18));
				lblTelefono.setBounds(87, 157, 85, 29);
				panel.add(lblTelefono);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setForeground(Color.WHITE);
				txtTelefono.setBackground(Color.BLACK);
				txtTelefono.setBounds(87, 199, 116, 22);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
				if(miCliente!=null)
				{
					txtTelefono.setText(miCliente.getTelefono());
				}
			}
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
				lblDireccion.setFont(new Font("Arial", Font.PLAIN, 18));
				lblDireccion.setBounds(355, 157, 104, 29);
				panel.add(lblDireccion);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setForeground(Color.WHITE);
				txtDireccion.setBackground(Color.BLACK);
				txtDireccion.setBounds(355, 199, 116, 22);
				panel.add(txtDireccion);
				txtDireccion.setColumns(10);
				if(miCliente!=null)
				{
					txtDireccion.setText(miCliente.getDireccion());
				}
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 262, 594, 45);
				panel.add(buttonPane);
				{
					JButton btnRegistrar = new JButton("");
					if(miCliente == null)
					{
						btnRegistrar.setText("Registrar");
					}
					else
					{
						btnRegistrar.setText("Modificar");
					}
					btnRegistrar.setBounds(400, 5, 95, 29);
					btnRegistrar.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
					btnRegistrar.setForeground(Color.WHITE);
					btnRegistrar.setBackground(Color.BLACK);
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(miCliente == null)
							{
								Cliente miNuevoCliente = null;
								
								String cedula = txtCedula.getText();
								String nombre = txtNombre.getText();
								String telefono = txtTelefono.getText();
								String direccion = txtDireccion.getText();
								
								miNuevoCliente = new Cliente(nombre, direccion, telefono, cedula);
								CentralAltice.getInstance().agregarCliente(miNuevoCliente);
								JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							else 
							{
								Cliente miNuevoCliente = null;
								
								String cedula = txtCedula.getText();
								String nombre = txtNombre.getText();
								String telefono = txtTelefono.getText();
								String direccion = txtDireccion.getText();
								
								miNuevoCliente = new Cliente(nombre, direccion, telefono, cedula);
								int indice = CentralAltice.getInstance().getMisClientes().indexOf(miCliente);
								CentralAltice.getInstance().getMisClientes().set(indice, miNuevoCliente);
								JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
						}
					});
					buttonPane.setLayout(null);
					btnRegistrar.setActionCommand("OK");
					buttonPane.add(btnRegistrar);
					getRootPane().setDefaultButton(btnRegistrar);
				}
				{
					JButton btnSalir = new JButton("Salir");
					btnSalir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					btnSalir.setBounds(507, 5, 63, 29);
					btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
					btnSalir.setForeground(Color.WHITE);
					btnSalir.setBackground(Color.BLACK);
					btnSalir.setActionCommand("Cancel");
					buttonPane.add(btnSalir);
				}
			}
		}
	}

	private void clean() {
		
		txtCedula.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		
	}
}
