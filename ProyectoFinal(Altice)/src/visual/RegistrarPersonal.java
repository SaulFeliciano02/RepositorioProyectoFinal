package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtHola;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		setBounds(100, 100, 648, 347);
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
				separator.setBounds(10, 113, 607, 2);
				panel.add(separator);
			}
			{
				JLabel lblElegirSuRango = new JLabel("Elegir su rango:");
				lblElegirSuRango.setFont(new Font("Arial", Font.BOLD, 13));
				lblElegirSuRango.setBounds(20, 26, 106, 14);
				panel.add(lblElegirSuRango);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(10, 11, 607, 2);
				panel.add(separator);
			}
			
			JRadioButton rdbtnAministrativo = new JRadioButton("Aministrativo");
			rdbtnAministrativo.setFont(new Font("Arial", Font.PLAIN, 13));
			rdbtnAministrativo.setBounds(27, 63, 109, 23);
			panel.add(rdbtnAministrativo);
			
			JRadioButton rdbtnComercial = new JRadioButton("Comercial");
			rdbtnComercial.setFont(new Font("Arial", Font.PLAIN, 13));
			rdbtnComercial.setBounds(152, 63, 109, 23);
			panel.add(rdbtnComercial);
			
			JLabel lblCedula = new JLabel("C\u00E9dula:");
			lblCedula.setFont(new Font("Arial", Font.PLAIN, 13));
			lblCedula.setBounds(27, 126, 46, 14);
			panel.add(lblCedula);
			
			textField = new JTextField();
			textField.setForeground(Color.WHITE);
			textField.setBackground(Color.BLACK);
			textField.setBounds(27, 151, 160, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblNombreYApellido = new JLabel("Nombre(s) y/ apellido(s):");
			lblNombreYApellido.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNombreYApellido.setBounds(224, 126, 152, 14);
			panel.add(lblNombreYApellido);
			
			textField_1 = new JTextField();
			textField_1.setBackground(Color.BLACK);
			textField_1.setForeground(Color.WHITE);
			textField_1.setBounds(224, 151, 199, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
			lblTelefono.setBounds(433, 126, 65, 14);
			panel.add(lblTelefono);
			
			textField_2 = new JTextField();
			textField_2.setBackground(Color.BLACK);
			textField_2.setForeground(Color.WHITE);
			textField_2.setBounds(433, 151, 184, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
			lblDireccion.setBounds(27, 200, 83, 14);
			panel.add(lblDireccion);
			
			txtHola = new JTextField();
			txtHola.setBackground(Color.BLACK);
			txtHola.setForeground(Color.WHITE);
			txtHola.setBounds(27, 225, 165, 20);
			panel.add(txtHola);
			txtHola.setColumns(10);
			
			JLabel lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setFont(new Font("Arial", Font.PLAIN, 13));
			lblSueldo.setBounds(224, 198, 46, 14);
			panel.add(lblSueldo);
			
			textField_4 = new JTextField();
			textField_4.setBackground(Color.BLACK);
			textField_4.setForeground(Color.WHITE);
			textField_4.setBounds(224, 225, 83, 20);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
			lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
			lblContrasena.setBounds(317, 198, 83, 14);
			panel.add(lblContrasena);
			
			textField_5 = new JTextField();
			textField_5.setForeground(Color.WHITE);
			textField_5.setBackground(Color.BLACK);
			textField_5.setBounds(317, 225, 126, 20);
			panel.add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblConfirmarContrasena = new JLabel("Confirmar contrase\u00F1a:");
			lblConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
			lblConfirmarContrasena.setBounds(448, 198, 142, 14);
			panel.add(lblConfirmarContrasena);
			
			textField_6 = new JTextField();
			textField_6.setForeground(Color.WHITE);
			textField_6.setBackground(Color.BLACK);
			textField_6.setBounds(448, 225, 169, 20);
			panel.add(textField_6);
			textField_6.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegistarButton = new JButton("Registrar");
				RegistarButton.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				RegistarButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
					}
				});
				RegistarButton.setForeground(Color.WHITE);
				RegistarButton.setBackground(Color.BLACK);
				RegistarButton.setActionCommand("OK");
				buttonPane.add(RegistarButton);
				getRootPane().setDefaultButton(RegistarButton);
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
