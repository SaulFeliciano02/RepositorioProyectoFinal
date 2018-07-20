package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private Cliente miCliente;
	private JButton btnRegistrar;
	

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
			txtCedula.setBackground(Color.BLACK);
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
			txtNombre.setBackground(Color.BLACK);
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
			
			txtTelefono = new JTextField();
			txtTelefono.setBackground(Color.BLACK);
			txtTelefono.setBounds(74, 217, 166, 22);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			if(miCliente!=null)
			{
				txtTelefono.setText(miCliente.getTelefono());
			}
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setFont(new Font("Arial", Font.PLAIN, 18));
			lblDireccin.setBounds(393, 189, 90, 16);
			panel.add(lblDireccin);
			
			txtDireccion = new JTextField();
			txtDireccion.setBackground(Color.BLACK);
			txtDireccion.setBounds(393, 217, 166, 22);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
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
							String telefono = txtTelefono.getText();
							
							nuevo = new Cliente(cedula, nombre, direccion, telefono);
							CentralAltice.getInstance().agregarCliente(nuevo);
							JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						
						else
						{
							Cliente modificado = null;
							
							String cedula = txtCedula.getText();
							String direccion = txtDireccion.getText();
							String nombre = txtNombre.getText();
							String telefono = txtTelefono.getText();
							
							modificado = new Cliente(cedula, nombre, direccion, telefono);
							int indice = CentralAltice.getInstance().getMisClientes().indexOf(miCliente);
							CentralAltice.getInstance().getMisClientes().set(indice, modificado);
							JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnSalir = new JButton("Salir");
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
		txtTelefono.setText("");
	}
}
