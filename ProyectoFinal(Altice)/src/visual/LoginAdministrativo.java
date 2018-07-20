package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginAdministrativo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public LoginAdministrativo() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 560);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(LoginAdministrativo.class.getResource("/ImagenesVentanaP/icons8-grupo-de-usuarios-hombre-y-mujer-90.png")));
		lblIcono.setBounds(171, 46, 121, 99);
		contentPanel.add(lblIcono);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setForeground(Color.BLACK);
		lblCdula.setFont(new Font("Arial", Font.BOLD, 22));
		lblCdula.setBounds(130, 158, 83, 26);
		contentPanel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(130, 197, 162, 22);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 22));
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setBounds(128, 315, 126, 37);
		contentPanel.add(lblContrasea);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(130, 359, 162, 22);
		contentPanel.add(txtContraseña);
		txtContraseña.setColumns(10);
		
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
		btnIniciarSesin.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
		btnIniciarSesin.setBounds(202, 523, 135, 25);
		contentPanel.add(btnIniciarSesin);
		{
			JLabel lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(LoginAdministrativo.class.getResource("/ImagenesVentanaP/Altice m\u00E1s clara.png")));
			lblFondo.setBounds(65, 0, 360, 646);
			contentPanel.add(lblFondo);
		}
	}
}
