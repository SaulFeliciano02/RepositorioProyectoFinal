package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.CentralAltice;
import logico.Cliente;
import persistivos.ArchivarCentral;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class RegistroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private Cliente miCliente;
	private JButton btnRegistrar;
	private JFormattedTextField formattedtxtTelefono;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegistroCliente(String title, Cliente miCliente) {
		setResizable(false);
		setModal(true);
		this.miCliente = miCliente;
		setTitle(title);
		setBounds(100, 100, 673, 402);
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
			lblCdula.setBounds(74, 55, 80, 22);
			panel.add(lblCdula);
			
			txtCedula = new JTextField();
			txtCedula.setBackground(Color.LIGHT_GRAY);
			txtCedula.setBounds(74, 90, 166, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			if(miCliente!=null)
			{
				txtCedula.setText(miCliente.getCedula());
				txtCedula.setEnabled(false);
			}
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNombre.setBounds(393, 59, 80, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.LIGHT_GRAY);
			txtNombre.setBounds(393, 90, 166, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			if(miCliente!=null)
			{
				txtNombre.setText(miCliente.getNombre());
			}
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setFont(new Font("Arial", Font.PLAIN, 18));
			lblTelfono.setBounds(74, 188, 90, 16);
			panel.add(lblTelfono);
			if(miCliente!=null)
			{
				formattedtxtTelefono.setText(miCliente.getTelefono());
			}
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setFont(new Font("Arial", Font.PLAIN, 18));
			lblDireccin.setBounds(393, 189, 90, 16);
			panel.add(lblDireccin);
			
			txtDireccion = new JTextField();
			txtDireccion.setBackground(Color.LIGHT_GRAY);
			txtDireccion.setBounds(393, 217, 166, 22);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			MaskFormatter mascara = null;
			try {
				mascara = new MaskFormatter("(###)-###-####");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			formattedtxtTelefono = new JFormattedTextField(mascara);
			formattedtxtTelefono.setBackground(Color.LIGHT_GRAY);
			formattedtxtTelefono.setBounds(74, 217, 166, 22);
			panel.add(formattedtxtTelefono);
			if(miCliente!=null)
			{
				txtDireccion.setText(miCliente.getDireccion());
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("");
				btnRegistrar.setForeground(Color.WHITE);
				btnRegistrar.setBackground(Color.BLACK);
				btnRegistrar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				if(miCliente!=null)
				{
					btnRegistrar.setText("Modificar");
				}
				else
				{
					btnRegistrar.setText("Registrar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(miCliente==null)
						{
							
							Cliente nuevo = null;
							
							String cedula = txtCedula.getText();
							String direccion = txtDireccion.getText();
							String nombre = txtNombre.getText();
							String telefono = formattedtxtTelefono.getText();
							
							if(CentralAltice.getInstance().chequeoDeCedula(txtCedula.getText()))
							{
								nuevo = new Cliente(cedula, nombre, direccion, telefono);
								CentralAltice.getInstance().agregarCliente(nuevo);
								JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "La cédula introducida ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						
						else
						{
							Cliente modificado = null;
							
							String cedula = txtCedula.getText();
							String direccion = txtDireccion.getText();
							String nombre = txtNombre.getText();
							String telefono = formattedtxtTelefono.getText();
							
							modificado = new Cliente(cedula, nombre, direccion, telefono);
							int indice = CentralAltice.getInstance().getMisClientes().indexOf(miCliente);
							CentralAltice.getInstance().getMisClientes().set(indice, modificado);
							JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							ListarClientes.loadtable();
							dispose();
						}
						
						try {
							CentralAltice.getInstance();
							ArchivarCentral archivo = new ArchivarCentral();
							archivo.guardar(CentralAltice.getInstance());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setBackground(Color.BLACK);
				btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}


	private void clean() {
		txtCedula.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		formattedtxtTelefono.setText("");
	}
}
