package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.SystemColor;

public class VentanaPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	
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
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				
				
			}
		});
		setResizable(false);
		setUndecorated(true);
		setBounds(108, 108, 1108, 603);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(0, 0, 270, 603);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblInicio = new JLabel("INICIO");
			lblInicio.setBounds(103, 23, 64, 26);
			lblInicio.setFont(new Font("Arial", Font.BOLD, 22));
			panel.add(lblInicio);
			
			JLabel ImagenAltice = new JLabel("");
			ImagenAltice.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Altice logo.png")));
			ImagenAltice.setBounds(54, 159, 191, 208);
			panel.add(ImagenAltice);
			
			JLabel lblSlogan = new JLabel("Juntos no tenemos l\u00EDmites");
			lblSlogan.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
			lblSlogan.setBounds(34, 365, 204, 14);
			panel.add(lblSlogan);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(269, 39, 839, 564);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel iconoCliente = new JLabel("");
		iconoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				iconoCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
				
				
			}
		});
		iconoCliente.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				//iconoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
				iconoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
				
				
				
				
			}
		});
		iconoCliente.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Icono cliente5.png")));
		iconoCliente.setBounds(72, 37, 136, 148);
		panel.add(iconoCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCliente.setBounds(110, 201, 80, 14);
		panel.add(lblCliente);
		
		JLabel iconoPersonalA = new JLabel("");
		iconoPersonalA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			iconoPersonalA.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));	
				
			}
		});
		iconoPersonalA.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
			iconoPersonalA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
			
			
				
			}
		});
		iconoPersonalA.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Personal Aurtorizado12.png")));
		iconoPersonalA.setBounds(321, 37, 206, 141);
		panel.add(iconoPersonalA);
		
		JLabel lblPersonalA = new JLabel("Personal Autorizado\r\n");
		lblPersonalA.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPersonalA.setBounds(342, 201, 173, 14);
		panel.add(lblPersonalA);
		
		JLabel iconoPlanes = new JLabel("");
		iconoPlanes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
			
				iconoPlanes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));	
				
				
			}
		});
		iconoPlanes.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				iconoPlanes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
				
			}
		});
		iconoPlanes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Plan3.png")));
		iconoPlanes.setBounds(632, 43, 128, 129);
		panel.add(iconoPlanes);
		
		JLabel lblPlanes = new JLabel("Planes");
		lblPlanes.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlanes.setBounds(674, 201, 64, 14);
		panel.add(lblPlanes);
		
		JLabel iconoFactura = new JLabel("");
		iconoFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				iconoFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
				
			}
		});
		iconoFactura.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				iconoFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
				
			}
		});
		iconoFactura.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Factura4.png")));
		iconoFactura.setBounds(204, 298, 118, 157);
		panel.add(iconoFactura);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFactura.setBounds(254, 466, 86, 14);
		panel.add(lblFactura);
		
		JLabel iconoConsultas = new JLabel("");
		iconoConsultas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				iconoConsultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
				
			}
		});
		iconoConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				iconoConsultas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));	
			
			}
		});
		iconoConsultas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Consultas6.png")));
		iconoConsultas.setBounds(506, 298, 159, 147);
		panel.add(iconoConsultas);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConsultas.setBounds(547, 466, 87, 14);
		panel.add(lblConsultas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.setBounds(759, 530, 70, 23);
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(269, 0, 839, 38);
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
		
		btnCerrar = new JButton("");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
				
			}
		});
		btnCerrar.setBackground(SystemColor.menu);
		btnCerrar.setForeground(Color.LIGHT_GRAY);
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonCerrar.png")));
		btnCerrar.setBounds(791, 8, 38, 23);
		btnCerrar.setBorderPainted(false);
		panel_1.add(btnCerrar);
	}
}
