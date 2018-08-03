package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Formatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.CentralAltice;
import logico.PersonalAuto;

import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JFormattedTextField;

public class LoginComercial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtContraseña;
	private char cogerinformacion;
	
	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
	        try {
	            LoginComercial dialog = new LoginComercial();	            
	            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	            dialog.setVisible(true);	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	/**
	 * Create the dialog.
	 * @throws ParseException 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public LoginComercial() throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		 try {
				CentralAltice.getInstance().recuperarMiCentral();
			} catch (ClassNotFoundException | IOException e1) {
				JOptionPane.showMessageDialog(null, "Bienvenido por primera vez a nuestro sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			}
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 560);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		MaskFormatter mask = new MaskFormatter("###-#######-#");
		JFormattedTextField formattedCedula = new JFormattedTextField(mask);
		formattedCedula.setBounds(140, 214, 162, 22);
		contentPanel.add(formattedCedula);
		
		JLabel iconVisible = new JLabel("");
		iconVisible.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/Visible png 3.png")));
		iconVisible.setBounds(124, 366, 31, 14);
		contentPanel.add(iconVisible);
		
		JLabel lblA = new JLabel("");
		lblA.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/icons8-usuario-cedula.png")));
		lblA.setBounds(109, 207, 31, 37);
		contentPanel.add(lblA);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(Color.BLACK);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersonal reg = new RegistrarPersonal(null);
				reg.setLocationRelativeTo(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 13));
		btnRegistrarse.setBounds(149, 413, 117, 23);
		contentPanel.add(btnRegistrarse);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(140, 333, 162, 22);
		contentPanel.add(txtContraseña);
		cogerinformacion = txtContraseña.getEchoChar(); 
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/icons8-grupo-de-usuarios-hombre-y-mujer-90.png")));
		lblIcono.setBounds(98, 11, 121, 105);
		contentPanel.add(lblIcono);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setForeground(Color.BLACK);
		lblCdula.setFont(new Font("Arial", Font.BOLD, 22));
		lblCdula.setBounds(137, 177, 83, 26);
		contentPanel.add(lblCdula);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 22));
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setBounds(140, 285, 126, 37);
		contentPanel.add(lblContrasea);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(349, 523, 76, 25);
		contentPanel.add(btnSalir);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setForeground(Color.WHITE);
		btnIniciarSesin.setBackground(Color.BLACK);
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonalAuto user = CentralAltice.getInstance().iniciarSeccion(txtContraseña.getPassword(), formattedCedula.getText());
				
				if(user != null)
				{
					VentanaPrincipal ventanaP = null;										
					try {
						ventanaP = new VentanaPrincipal(user);
						dispose();		
						ventanaP.setUndecorated(true);
						ventanaP.getRootPane().setWindowDecorationStyle(JRootPane.NONE); //SetUndecorated(true)
						ventanaP.setVisible(true);	
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}									
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);	
				}
								
			}
		});
		btnIniciarSesin.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnIniciarSesin.setBounds(202, 523, 135, 25);
		contentPanel.add(btnIniciarSesin);
		
		JLabel lblComercial_1 = new JLabel("REGISTRO");
		lblComercial_1.setForeground(Color.WHITE);
		lblComercial_1.setFont(new Font("Futura Bk BT", Font.BOLD, 22));
		lblComercial_1.setBounds(211, 57, 127, 28);
		contentPanel.add(lblComercial_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/RegistrarPersonal1.png")));
		label.setBounds(190, 30, 162, 81);
		contentPanel.add(label);
		
		JLabel iconCandado = new JLabel("");
		iconCandado.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/icons8-privacidad-24.png")));
		iconCandado.setBounds(109, 331, 46, 22);
		contentPanel.add(iconCandado);
		
		
		
		JCheckBox chckboxVerContraseña = new JCheckBox("Ver contrase\u00F1a");
		chckboxVerContraseña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckboxVerContraseña.isSelected()) {
					
				
					txtContraseña.setEchoChar((char)0);
					
					
				}
				
				
				else {
					
					txtContraseña.setEchoChar(cogerinformacion);
					
				}
				
				
			}
		});
		chckboxVerContraseña.setBackground(SystemColor.menu);
		chckboxVerContraseña.setFont(new Font("Arial", Font.PLAIN, 13));
		chckboxVerContraseña.setBounds(150, 364, 126, 23);
		contentPanel.add(chckboxVerContraseña);
		
		JLabel ImagenAlticeFondo = new JLabel("");
		ImagenAlticeFondo.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		ImagenAlticeFondo.setBounds(-41, 0, 559, 567);
		contentPanel.add(ImagenAlticeFondo);
	}
}
