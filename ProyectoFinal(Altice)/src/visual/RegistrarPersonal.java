package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CentralAltice;
import logico.Comercial;
import logico.PersonalAdministra;
import logico.PersonalAuto;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class RegistrarPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombreyApellido;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtSueldo;
	JRadioButton rdbtnAministrativo;
	JRadioButton rdbtnComercial_1;
	JPanel panelRdbtn;
	ButtonGroup grupoBotones;
	private PersonalAuto personales; 
	private JPasswordField txtContraseña;
	private JPasswordField txtConfirmarC;
	private JCheckBox chckbxVerContraseña;
	private char cogerInformacion; 
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarPersonal() {
		setTitle("Registrar Personal");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 648, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(137, 87, 109, 4);
				panel.add(separator);
			}
			
			JLabel lblCedula = new JLabel("C\u00E9dula:");
			lblCedula.setFont(new Font("Arial", Font.PLAIN, 13));
			lblCedula.setBounds(27, 126, 46, 14);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setForeground(Color.BLACK);
			txtCedula.setBackground(Color.LIGHT_GRAY);
			txtCedula.setBounds(27, 151, 160, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNombreYApellido = new JLabel("Nombre(s) y/ apellido(s):");
			lblNombreYApellido.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNombreYApellido.setBounds(224, 126, 152, 14);
			panel.add(lblNombreYApellido);
			
			txtNombreyApellido = new JTextField();
			txtNombreyApellido.setBackground(Color.LIGHT_GRAY);
			txtNombreyApellido.setForeground(Color.BLACK);
			txtNombreyApellido.setBounds(224, 151, 235, 20);
			panel.add(txtNombreyApellido);
			txtNombreyApellido.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
			lblTelefono.setBounds(474, 126, 65, 14);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setBackground(Color.LIGHT_GRAY);
			txtTelefono.setForeground(Color.BLACK);
			txtTelefono.setBounds(475, 151, 142, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
			lblDireccion.setBounds(27, 200, 83, 14);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setBackground(Color.LIGHT_GRAY);
			txtDireccion.setForeground(Color.BLACK);
			txtDireccion.setBounds(27, 225, 165, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setFont(new Font("Arial", Font.PLAIN, 13));
			lblSueldo.setBounds(224, 198, 46, 14);
			panel.add(lblSueldo);
			
			txtSueldo = new JTextField();
			txtSueldo.setBackground(Color.LIGHT_GRAY);
			txtSueldo.setForeground(Color.BLACK);
			txtSueldo.setBounds(224, 225, 83, 20);
			panel.add(txtSueldo);
			txtSueldo.setColumns(10);
			
			JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
			lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
			lblContrasena.setBounds(317, 198, 83, 14);
			panel.add(lblContrasena);
			
			JLabel lblConfirmarContrasena = new JLabel("Confirmar contrase\u00F1a:");
			lblConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
			lblConfirmarContrasena.setBounds(475, 200, 142, 14);
			panel.add(lblConfirmarContrasena);
			
			panelRdbtn = new JPanel();
			panelRdbtn.setBorder(null);
			panelRdbtn.setBounds(10, 23, 289, 40);
			panel.add(panelRdbtn);
			panelRdbtn.setLayout(null);
			
			rdbtnAministrativo = new JRadioButton("Aministrativo");
			rdbtnAministrativo.setBounds(6, 7, 119, 23);
			panelRdbtn.add(rdbtnAministrativo);
			rdbtnAministrativo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					//radioButtunClicked();
				
					
				}

				//private void radioButtunClicked() {
					
					
					/*	
					if(rdbtnAministrativo.isSelected()) {
						rdbtnAministrativo.setEnabled(true);
						rdbtnComercial_1.setEnabled(false);
					
					}
					
					else if(rdbtnComercial_1.isSelected()) {
						rdbtnAministrativo.setEnabled(false);
						rdbtnComercial_1.setEnabled(true);
					}
					
					*/
					
				//}
			});
			
			rdbtnAministrativo.setFont(new Font("Arial", Font.PLAIN, 13));
			
			rdbtnComercial_1 = new JRadioButton("Comercial");
			rdbtnComercial_1.setBounds(127, 7, 83, 23);
			panelRdbtn.add(rdbtnComercial_1);
			rdbtnComercial_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//radioButtonClicked();
					
					
				}
/*
				
				private void radioButtonClicked() {
					
	
						if(rdbtnAministrativo.isSelected()) {
							rdbtnAministrativo.setEnabled(true);
							rdbtnComercial_1.setEnabled(false);
						
						}
						
						else if(rdbtnComercial_1.isSelected()) {
							rdbtnAministrativo.setEnabled(false);
							rdbtnComercial_1.setEnabled(true);
						}
					
					
				}*/
			});
			
			
			
			rdbtnComercial_1.setFont(new Font("Arial", Font.PLAIN, 13));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Elecci\u00F3n de rango", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			panel_1.setBounds(0, 0, 632, 68);
			panel.add(panel_1);
			
			JLabel lblDatosDelPersonal = new JLabel("Datos del personal");
			lblDatosDelPersonal.setFont(new Font("Arial", Font.BOLD, 13));
			lblDatosDelPersonal.setBounds(252, 79, 131, 14);
			panel.add(lblDatosDelPersonal);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(374, 87, 109, 4);
			panel.add(separator);
			
			txtContraseña = new JPasswordField();
			txtContraseña.setForeground(Color.BLACK);
			txtContraseña.setBackground(Color.LIGHT_GRAY);
			txtContraseña.setBounds(317, 225, 142, 20);
			panel.add(txtContraseña);
			
			txtConfirmarC = new JPasswordField();
			txtConfirmarC.setForeground(Color.BLACK);
			txtConfirmarC.setBackground(Color.LIGHT_GRAY);
			txtConfirmarC.setBounds(474, 225, 143, 20);
			panel.add(txtConfirmarC);
			
			chckbxVerContraseña = new JCheckBox("Ver contrase\u00F1a");
			chckbxVerContraseña.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(chckbxVerContraseña.isSelected()) {
						
						
						txtContraseña.setEchoChar((char)0);
						txtConfirmarC.setEchoChar((char)0);
						
					}
					
					
					else {
						
						txtContraseña.setEchoChar(cogerInformacion);
						txtConfirmarC.setEchoChar(cogerInformacion);
					}
					
					
					
					
					
				}
			});
			chckbxVerContraseña.setFont(new Font("Arial", Font.PLAIN, 13));
			chckbxVerContraseña.setBounds(501, 266, 125, 23);
			panel.add(chckbxVerContraseña);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(RegistrarPersonal.class.getResource("/ImagenesVentanaP/Visible png 3.png")));
			label.setBounds(474, 270, 28, 14);
			panel.add(label);
		}
		
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnAministrativo); 
		grupoBotones.add(rdbtnComercial_1);
	
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
							if(txtCedula.getText().isEmpty()||txtConfirmarC.getText().isEmpty()||txtContraseña.getText().isEmpty()||
									txtDireccion.getText().isEmpty()||txtNombreyApellido.getText().isEmpty()||txtSueldo.getText().isEmpty()
									||txtTelefono.getText().isEmpty()) {
								
								JOptionPane.showMessageDialog(null, "Rellenar todos los campos", "Estado de ejecución", JOptionPane.ERROR_MESSAGE);
							
								
							}
							
							//TODO Poner en un buble esta condicion, para que siga pidiendo las contraseñas.
							else {
								
								if((txtContraseña.getText().equals(txtConfirmarC.getText())==false)) {
									
									txtContraseña.setBackground(Color.RED);
									txtConfirmarC.setBackground(Color.RED);
									JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Información de ejecución", JOptionPane.ERROR_MESSAGE);
									txtContraseña.setText("");
									txtConfirmarC.setText("");
										
									}
								
								
								if(!CentralAltice.getInstance().chequeoDeCedula(txtCedula.getText())) {
									
									txtCedula.setBackground(Color.RED);
									JOptionPane.showMessageDialog(null, "La cédula ya existe en el registro", "Información de ejecución", JOptionPane.ERROR_MESSAGE);
									txtCedula.setText("");
									
								}
								
								
								else {
									
									if(personales == null) {
										
										if(rdbtnAministrativo.isSelected()) {
											
											String cedula = txtCedula.getText();
											String confirmarC = txtConfirmarC.getText();
											String contraseña = txtContraseña.getText();
											String direccion = txtDireccion.getText();
											String nombre = txtNombreyApellido.getText();
											Float sueldo = Float.parseFloat(txtSueldo.getText());
											String telefono = txtTelefono.getText();
											

											PersonalAuto registraP = new PersonalAdministra(cedula, nombre, direccion, telefono, contraseña, sueldo);
											CentralAltice.getInstance().agregarPersonal(registraP);
											clean();	
											grupoBotones.clearSelection();
										}
										
										
										
										if (personales==null) {
											if(rdbtnComercial_1.isSelected()) {
												
												String cedula = txtCedula.getText();
												String confirmarC = txtConfirmarC.getText();
												String contraseña = txtContraseña.getText();
												String direccion = txtDireccion.getText();
												String nombre = txtNombreyApellido.getText();
												Float sueldo = Float.parseFloat(txtSueldo.getText());
												String telefono = txtTelefono.getText();
												
												PersonalAuto registrarComercial = new Comercial(cedula, nombre, direccion, telefono, contraseña, sueldo);
												CentralAltice.getInstance().agregarPersonal(registrarComercial);
												clean();
												grupoBotones.clearSelection();
												
												} } }
									
												}
										

								}
								
								
								
											
					}

								
				

					private void clean() {
						txtCedula.setText("");
						txtConfirmarC.setText("");
						txtContraseña.setText("");
						txtDireccion.setText("");
						txtNombreyApellido.setText("");
						txtSueldo.setText("");
						txtTelefono.setText("");
						txtContraseña.setBackground(Color.BLACK);
						txtConfirmarC.setBackground(Color.BLACK);
						txtCedula.setBackground(Color.BLACK);
						
						
					}
					
					
				});
				
		
				btnRegistrar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					
				});
				btnRegistrar.setForeground(Color.WHITE);
				btnRegistrar.setBackground(Color.BLACK);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton SalirButton = new JButton("Salir");
				SalirButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				SalirButton.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				SalirButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
					}
				});
				SalirButton.setForeground(Color.WHITE);
				SalirButton.setBackground(Color.BLACK);
				SalirButton.setActionCommand("Cancel");
				buttonPane.add(SalirButton);
			}
			
			
			
			
			
	}
		
}
}

