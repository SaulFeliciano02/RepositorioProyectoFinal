package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class VentanaPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPrincipal dialog = new VentanaPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 1095, 611);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(0, 0, 270, 611);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblInicio = new JLabel("INICIO");
			lblInicio.setBounds(103, 23, 64, 26);
			lblInicio.setFont(new Font("Arial", Font.BOLD, 22));
			panel.add(lblInicio);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Altice logo.png")));
			label.setBounds(54, 159, 191, 208);
			panel.add(label);
			
			JLabel lblJuntos = new JLabel("Juntos no tenemos l\u00EDmites");
			lblJuntos.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
			lblJuntos.setBounds(34, 365, 204, 14);
			panel.add(lblJuntos);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(269, 39, 826, 572);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Icono cliente5.png")));
		label.setBounds(72, 37, 137, 148);
		panel.add(label);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCliente.setBounds(110, 201, 80, 14);
		panel.add(lblCliente);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Personal Aurtorizado12.png")));
		label_2.setBounds(323, 37, 199, 141);
		panel.add(label_2);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConsultas.setBounds(388, 201, 96, 14);
		panel.add(lblConsultas);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Plan3.png")));
		label_3.setBounds(632, 43, 147, 129);
		panel.add(label_3);
		
		JLabel lblPlanes = new JLabel("Planes");
		lblPlanes.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlanes.setBounds(675, 201, 64, 14);
		panel.add(lblPlanes);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Factura4.png")));
		label_4.setBounds(204, 298, 137, 157);
		panel.add(label_4);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFactura.setBounds(254, 466, 86, 14);
		panel.add(lblFactura);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Consultas6.png")));
		label_5.setBounds(506, 298, 159, 147);
		panel.add(label_5);
		
		JLabel lblConsultas_1 = new JLabel("Consultas");
		lblConsultas_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConsultas_1.setBounds(554, 466, 87, 14);
		panel.add(lblConsultas_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.setBounds(735, 534, 70, 23);
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(269, 0, 826, 38);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonCerrar.png")));
		lblNewLabel.setBounds(1039, 11, 46, 20);
		panel_1.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonMinimizar.png")));
		label_1.setBounds(998, 11, 38, 22);
		panel_1.add(label_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonCerrar.png")));
		label_6.setBounds(780, 11, 36, 16);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonMinimizar.png")));
		label_7.setBounds(738, 11, 38, 20);
		panel_1.add(label_7);
	}
}
