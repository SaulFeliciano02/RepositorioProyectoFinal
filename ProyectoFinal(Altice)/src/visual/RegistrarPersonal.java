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
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;



import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

public class RegistrarPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreyApellido;
	private JTextField txtDireccion, txtSueldo;
	JRadioButton rdbtnAministrativo;
	JRadioButton rdbtnComercial_1;
	JPanel panelRdbtn;
	ButtonGroup grupoBotones;
	private PersonalAuto personales; 
	private JPasswordField txtContraseña, txtConfirmarC;
	private JCheckBox chckbxVerContraseña;
	private char cogerInformacion; 
	JFormattedTextField formattedTelefono, formattedCedula;
	private char[] CogerPasswordC, cogerPasswordConfirm;
	private PersonalAuto modificar;
	JButton btnRegistrar;
	
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarPersonal(PersonalAuto regPersonal) {
		
		setResizable(false);
		
		modificar = regPersonal;
		setTitle("");
		
		if(modificar == null) {
			setTitle("Registrar personal autorizado");}
		else {
			setTitle("Modificar personal autorizado");
			
		}
		
		
		
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
			
			
			JLabel lblNombreYApellido = new JLabel("Nombre(s) y/o apellido(s):");
			lblNombreYApellido.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNombreYApellido.setBounds(224, 126, 152, 14);
			panel.add(lblNombreYApellido);
			
			txtNombreyApellido = new JTextField();
			txtNombreyApellido.setBackground(Color.LIGHT_GRAY);
			txtNombreyApellido.setForeground(Color.BLACK);
			txtNombreyApellido.setBounds(224, 151, 235, 20);
			panel.add(txtNombreyApellido);
			txtNombreyApellido.setColumns(10);
			if(personales != null) {
				txtNombreyApellido.setText(personales.getNombre());
			}
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
			lblTelefono.setBounds(474, 126, 65, 14);
			panel.add(lblTelefono);
			
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
			if(personales != null) {
				txtDireccion.setText(personales.getDireccion());
			}
			
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
			if(personales != null) {
				txtSueldo.setText(Float.toString((float) personales.getSueldo()));
			}
			
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
			separator.setBounds(378, 87, 109, 4);
			panel.add(separator);
			
			txtContraseña = new JPasswordField();
			txtContraseña.setForeground(Color.BLACK);
			txtContraseña.setBackground(Color.LIGHT_GRAY);
			txtContraseña.setBounds(317, 225, 142, 20);
			panel.add(txtContraseña);
			cogerInformacion = txtContraseña.getEchoChar();
			
			
			txtConfirmarC = new JPasswordField();
			txtConfirmarC.setForeground(Color.BLACK);
			txtConfirmarC.setBackground(Color.LIGHT_GRAY);
			txtConfirmarC.setBounds(474, 225, 148, 20);
			panel.add(txtConfirmarC);
			cogerInformacion = txtConfirmarC.getEchoChar();
			
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
			try
			{
			    MaskFormatter mascara = new MaskFormatter("( ### ) - ### - ####");
			    formattedTelefono = new JFormattedTextField(mascara);
			    
			}
			catch (Exception e)
			{
			    e.printStackTrace();
			}
			
		
			formattedTelefono.setBackground(Color.LIGHT_GRAY);
			formattedTelefono.setBounds(471, 151, 148, 20);
			panel.add(formattedTelefono);
			if(personales != null) {
				formattedTelefono.setText(personales.getTelefono());
				
			}

			
			try
			{
			    MaskFormatter mascara = new MaskFormatter("###-#######-#");
			    formattedCedula = new JFormattedTextField(mascara);
			    formattedCedula.setForeground(Color.BLACK);
			    
			}
			catch (Exception e)
			{
			    e.printStackTrace();
			}
			
			formattedCedula.setBackground(Color.LIGHT_GRAY);
			formattedCedula.setBounds(27, 151, 165, 20);
			panel.add(formattedCedula);
			if(modificar != null) {
				formattedCedula.setText(modificar.getCedula());
				formattedCedula.setEnabled(false);
			}
			
		}
		
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnAministrativo); 
		grupoBotones.add(rdbtnComercial_1);
	
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("");
				if(modificar != null) {
					btnRegistrar.setText("Modificar");}
				else {
					btnRegistrar.setText("Registrar");
				}
				
				
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						//TODO MODIFICAR Y LISTAR ESTA MIELDA
						
						
						String cedula = formattedCedula.getText();
						String telefono = formattedTelefono.getText();
						String nombre = txtNombreyApellido.getText();
						String direccion = txtDireccion.getText();
						String contraseña = txtContraseña.getPassword().toString();
						String contraseñaConfirmar  = txtConfirmarC.getPassword().toString();
						
						
						
						float sueldo = 0;
						if(!txtSueldo.getText().equalsIgnoreCase(""))
						{
							sueldo = Float.parseFloat(txtSueldo.getText());
						}
						
					if(modificar == null) {
						
						if(Arrays.equals(txtContraseña.getPassword(), txtConfirmarC.getPassword()) && confirmarCampos() && CentralAltice.getInstance().chequeoDeCedula(cedula)) {
							
							if(rdbtnAministrativo.isSelected()) {
								
								PersonalAuto personalA = new PersonalAdministra(cedula, nombre, direccion, telefono, contraseñaConfirmar, sueldo);																
								CentralAltice.getInstance().agregarPersonal(personalA);								
								
							}
							
							if(rdbtnComercial_1.isSelected()) {
								PersonalAuto personalC = new Comercial(cedula, nombre, direccion, telefono, contraseñaConfirmar, sueldo);
								CentralAltice.getInstance().agregarPersonal(personalC);
															
							}
							
							JOptionPane.showMessageDialog(null, "¡Personal registrado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							
							grupoBotones.clearSelection();

							clean();
						
						}						
				
						else {
							
							
							if(!Arrays.equals(txtContraseña.getPassword(), txtConfirmarC.getPassword())) {
								
								txtConfirmarC.setBackground(new Color(250, 60, 60));
								txtContraseña.setBackground(new Color(250, 60, 60));
								
								JOptionPane.showMessageDialog(null, "Las contraseñas son distintas", "Error", JOptionPane.ERROR_MESSAGE);
								txtConfirmarC.setText("");
								txtContraseña.setText("");
								
							}
								
							if(!(CentralAltice.getInstance().chequeoDeCedula(formattedCedula.getText()))) {
								
								formattedCedula.setBackground(new Color(250, 60, 60));
								JOptionPane.showMessageDialog(null, "La cédula ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);
								formattedCedula.setText("");}}
							
											
						}
					else {
						
						if(Arrays.equals(txtContraseña.getPassword(), txtConfirmarC.getPassword()) && confirmarCampos()) {
							
							PersonalAuto personal = regPersonal;
							
							if(rdbtnAministrativo.isSelected()) {
								
								personal = new PersonalAdministra(cedula, nombre, direccion, telefono, contraseñaConfirmar, sueldo);																
								int indice = CentralAltice.getInstance().getMiPersonal().indexOf(regPersonal);								
								CentralAltice.getInstance().getMiPersonal().set(indice, personal);
								ListadoPersonal.cargartabla(0);
								dispose();								
								
							}
							if(rdbtnComercial_1.isSelected()) {
								personal = new Comercial(cedula, nombre, direccion, telefono, contraseñaConfirmar, sueldo);
								int indice = CentralAltice.getInstance().getMiPersonal().indexOf(regPersonal);								
								CentralAltice.getInstance().getMiPersonal().set(indice, personal);
								ListadoPersonal.cargartabla(0);
								dispose();	
															
							}	
							
						}
						
						else {
							
							
							if(!Arrays.equals(txtContraseña.getPassword(), txtConfirmarC.getPassword())) {
								
								txtConfirmarC.setBackground(new Color(250, 60, 60));
								txtContraseña.setBackground(new Color(250, 60, 60));
								
								JOptionPane.showMessageDialog(null, "Las contraseñas son distintas", "Error", JOptionPane.ERROR_MESSAGE);
								txtConfirmarC.setText("");
								txtContraseña.setText("");
								
							}
								
							}
						
						
					}

						
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


	private void clean() {
		formattedCedula.setText("");
		txtConfirmarC.setText("");
		txtContraseña.setText("");
		txtDireccion.setText("");
		txtNombreyApellido.setText("");
		txtSueldo.setText("");
		formattedTelefono.setText("");
		txtContraseña.setBackground(Color.LIGHT_GRAY);
		txtConfirmarC.setBackground(Color.LIGHT_GRAY);
		formattedCedula.setBackground(Color.LIGHT_GRAY);
		
		
	}


	public boolean confirmarCampos() {
		
		boolean bandera = true;
		
		if(formattedCedula.getText().equals("")) {
			
			bandera= false;
			
		}
		
		if(txtContraseña.getPassword().length  == 0) {
			
			bandera = false;
		}
		
		if(txtConfirmarC.getPassword().length == 0) {
			
			bandera = false;
		}
		
		
		if(txtDireccion.getText().isEmpty()) {
			
			bandera = false;
			
		}
		
		if(txtNombreyApellido.getText().isEmpty()) {
			
			bandera = false;
			
		}
		
		if(txtSueldo.getText().equalsIgnoreCase("")) {
			
			bandera= false;
			
		}
		
		
		if(formattedTelefono.getText().equalsIgnoreCase("")) {
			
			bandera= false;
			
		}
		
		
		if(!rdbtnAministrativo.isSelected() && !rdbtnComercial_1.isSelected())
		{
			
			bandera = false;
			
		}
		
		if(!bandera)
		{
			JOptionPane.showMessageDialog(null, "Llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return bandera;
		
		
	}
}

