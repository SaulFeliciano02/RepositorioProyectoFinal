package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import logico.CentralAltice;
import logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	public RegisCliente(String title, Cliente miCliente) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle(title);
		setResizable(false);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Futura Bk BT", Font.PLAIN, 12));
		setModal(true);
		setBounds(100, 100, 610, 352);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCdula = new JLabel("C\u00E9dula:");
				lblCdula.setFont(new Font("Arial", Font.PLAIN, 18));
				lblCdula.setBounds(53, 45, 93, 16);
				panel.add(lblCdula);
			}
			
			txtCedula = new JTextField();
			txtCedula.setForeground(Color.WHITE);
			txtCedula.setBackground(Color.BLACK);
			txtCedula.setBounds(53, 74, 152, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			if(miCliente!=null)
			{
				txtCedula.setEnabled(false);
				txtCedula.setText(miCliente.getCedula());
			}
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNombre.setBounds(369, 46, 77, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setForeground(Color.WHITE);
			txtNombre.setBackground(Color.BLACK);
			txtNombre.setBounds(369, 74, 152, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			if(miCliente!=null)
			{
				txtNombre.setText(miCliente.getNombre());
			}
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setFont(new Font("Arial", Font.PLAIN, 18));
			lblTelfono.setBounds(53, 152, 93, 16);
			panel.add(lblTelfono);
			
			txtTelefono = new JTextField();
			txtTelefono.setForeground(Color.WHITE);
			txtTelefono.setBackground(Color.BLACK);
			txtTelefono.setBounds(53, 181, 152, 22);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			if(miCliente!=null)
			{
				txtTelefono.setText(miCliente.getTelefono());
			}
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setFont(new Font("Arial", Font.PLAIN, 18));
			lblDireccin.setBounds(369, 153, 100, 16);
			panel.add(lblDireccin);
			
			txtDireccion = new JTextField();
			txtDireccion.setForeground(Color.WHITE);
			txtDireccion.setBackground(Color.BLACK);
			txtDireccion.setBounds(369, 181, 152, 22);
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
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setBackground(Color.BLACK);
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
