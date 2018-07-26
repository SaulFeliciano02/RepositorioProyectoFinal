package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class LoginComercial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JPasswordField txtContraseña;
	private char cogerinformacion;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public LoginComercial() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 560);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(140, 367, 162, 20);
		contentPanel.add(txtContraseña);
		cogerinformacion = txtContraseña.getEchoChar();
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/icons8-grupo-de-usuarios-hombre-y-mujer-90.png")));
		lblIcono.setBounds(80, 90, 121, 99);
		contentPanel.add(lblIcono);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setForeground(Color.BLACK);
		lblCdula.setFont(new Font("Arial", Font.BOLD, 22));
		lblCdula.setBounds(140, 252, 83, 26);
		contentPanel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(140, 277, 162, 22);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 22));
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setBounds(140, 317, 126, 37);
		contentPanel.add(lblContrasea);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(349, 523, 76, 25);
		contentPanel.add(btnSalir);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//
				
				
				
			}
		});
		btnIniciarSesin.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
		btnIniciarSesin.setBounds(202, 523, 135, 25);
		contentPanel.add(btnIniciarSesin);
		
		JLabel lblComercial_1 = new JLabel("REGISTRO");
		lblComercial_1.setForeground(Color.WHITE);
		lblComercial_1.setFont(new Font("Futura Bk BT", Font.BOLD, 22));
		lblComercial_1.setBounds(210, 137, 127, 28);
		contentPanel.add(lblComercial_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/RegistrarPersonal1.png")));
		label.setBounds(180, 108, 162, 81);
		contentPanel.add(label);
		
		JLabel iconCandado = new JLabel("");
		iconCandado.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/icons8-privacidad-24.png")));
		iconCandado.setBounds(111, 365, 46, 22);
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
		chckboxVerContraseña.setBounds(177, 397, 126, 23);
		contentPanel.add(chckboxVerContraseña);
		
		JLabel ImagenAlticeFondo = new JLabel("");
		ImagenAlticeFondo.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		ImagenAlticeFondo.setBounds(-33, -1, 559, 567);
		contentPanel.add(ImagenAlticeFondo);
		
		JLabel iconVisible = new JLabel("");
		iconVisible.setIcon(new ImageIcon(LoginComercial.class.getResource("/ImagenesVentanaP/Visible png 3.png")));
		iconVisible.setBounds(148, 401, 31, 14);
		contentPanel.add(iconVisible);
		
		JLabel lblComercial = new JLabel("Comercial");
		lblComercial.setFont(new Font("Futura Md BT", Font.PLAIN, 13));
		lblComercial.setBounds(180, 15, 75, 14);
		contentPanel.add(lblComercial);
	}
}
