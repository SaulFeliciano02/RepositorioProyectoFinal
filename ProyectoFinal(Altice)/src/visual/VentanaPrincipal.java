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
import javax.swing.JSeparator;

public class VentanaPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JPanel panelMenu;
	private JPanel panelAltice;
	private JPanel panelCerrar;
	private JPanel panelPlanes;
	private JPanel panelConsulta;
	private JPanel panelFactura;
	private JPanel panelPersonalA;
	private JPanel panelCliente;
	
	
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
		
		panelPersonalA = new JPanel();
		panelPersonalA.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panelPersonalA.setBounds(0, 0, 270, 603);
		contentPanel.add(panelPersonalA);
		panelPersonalA.setLayout(null);
		
		JLabel lblPersonalAutorizado = new JLabel("Personal Autorizado");
		lblPersonalAutorizado.setFont(new Font("Arial", Font.BOLD, 22));
		lblPersonalAutorizado.setBounds(27, 21, 216, 26);
		panelPersonalA.add(lblPersonalAutorizado);
		
		JLabel lblComercial = new JLabel("Comercial:");
		lblComercial.setFont(new Font("Arial", Font.PLAIN, 16));
		lblComercial.setBounds(53, 163, 119, 14);
		panelPersonalA.add(lblComercial);
		
		JLabel lblAdministrativo = new JLabel("Administrativo:");
		lblAdministrativo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAdministrativo.setBounds(53, 280, 119, 14);
		panelPersonalA.add(lblAdministrativo);
		
		JLabel lblListarPersonal = new JLabel("Listar personal:");
		lblListarPersonal.setFont(new Font("Arial", Font.PLAIN, 16));
		lblListarPersonal.setBounds(53, 395, 119, 14);
		panelPersonalA.add(lblListarPersonal);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 232, 223, 2);
		panelPersonalA.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 347, 223, 2);
		panelPersonalA.add(separator_2);
		
		panelAltice = new JPanel();
		panelAltice.setBounds(0, 0, 270, 603);
		contentPanel.add(panelAltice);
		panelAltice.setLayout(null);
		panelAltice.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel label = new JLabel("INICIO");
		label.setFont(new Font("Arial", Font.BOLD, 22));
		label.setBounds(103, 23, 64, 26);
		panelAltice.add(label);
		
		JLabel lblAltice = new JLabel("");
		lblAltice.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Altice logo.png")));
		lblAltice.setBounds(56, 134, 169, 208);
		panelAltice.add(lblAltice);
		
		JLabel label_2 = new JLabel("Juntos no tenemos l\u00EDmites");
		label_2.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		label_2.setBounds(33, 339, 204, 14);
		panelAltice.add(label_2);
		
		panelConsulta = new JPanel();
		panelConsulta.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panelConsulta.setBounds(0, 0, 270, 603);
		contentPanel.add(panelConsulta);
		panelConsulta.setLayout(null);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Arial", Font.BOLD, 22));
		lblConsulta.setBounds(83, 21, 108, 20);
		panelConsulta.add(lblConsulta);
		
		panelFactura = new JPanel();
		panelFactura.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panelFactura.setBounds(0, 0, 270, 603);
		contentPanel.add(panelFactura);
		panelFactura.setLayout(null);
		
		JLabel lblFactura_1 = new JLabel("Factura");
		lblFactura_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblFactura_1.setBounds(87, 21, 93, 20);
		panelFactura.add(lblFactura_1);
		
		JLabel lblListarFactura = new JLabel("Listar factura:");
		lblListarFactura.setFont(new Font("Arial", Font.PLAIN, 16));
		lblListarFactura.setBounds(53, 163, 127, 14);
		panelFactura.add(lblListarFactura);
		
		JLabel lblFacturacionDelMes = new JLabel("Facturaci\u00F3n del mes:");
		lblFacturacionDelMes.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFacturacionDelMes.setBounds(53, 280, 145, 14);
		panelFactura.add(lblFacturacionDelMes);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(20, 232, 223, 2);
		panelFactura.add(separator_5);
		
		panelPlanes = new JPanel();
		panelPlanes.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panelPlanes.setBounds(0, 0, 270, 603);
		contentPanel.add(panelPlanes);
		panelPlanes.setLayout(null);
		
		JLabel lblPlanes_1 = new JLabel("Planes");
		lblPlanes_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblPlanes_1.setBounds(92, 21, 78, 20);
		panelPlanes.add(lblPlanes_1);
		
		JLabel lblVentasDePlanes = new JLabel("Ventas de planes:");
		lblVentasDePlanes.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVentasDePlanes.setBounds(53, 163, 160, 14);
		panelPlanes.add(lblVentasDePlanes);
		
		JLabel lblManejoDePlanes = new JLabel("Manejo de planes:");
		lblManejoDePlanes.setFont(new Font("Arial", Font.PLAIN, 16));
		lblManejoDePlanes.setBounds(53, 280, 160, 20);
		panelPlanes.add(lblManejoDePlanes);
		
		JLabel lblGrafica = new JLabel("Gr\u00E1fica:");
		lblGrafica.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGrafica.setBounds(53, 395, 70, 14);
		panelPlanes.add(lblGrafica);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(20, 232, 223, 2);
		panelPlanes.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(20, 347, 223, 2);
		panelPlanes.add(separator_4);
		{
			panelCliente = new JPanel();
			panelCliente.setBounds(0, 0, 270, 603);
			panelCliente.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
			contentPanel.add(panelCliente);
			panelCliente.setLayout(null);
			
			JLabel lblInicio = new JLabel("Cliente");
			lblInicio.setBounds(104, 21, 85, 26);
			lblInicio.setFont(new Font("Arial", Font.BOLD, 22));
			panelCliente.add(lblInicio);
			
			JLabel lblRegistrarClientes = new JLabel("Registrar Cliente:");
			lblRegistrarClientes.setFont(new Font("Arial", Font.PLAIN, 16));
			lblRegistrarClientes.setBounds(39, 142, 173, 26);
			panelCliente.add(lblRegistrarClientes);
			
			JLabel lblListarClientes = new JLabel("Listar Clientes: ");
			lblListarClientes.setFont(new Font("Arial", Font.PLAIN, 16));
			lblListarClientes.setBounds(39, 250, 125, 14);
			panelCliente.add(lblListarClientes);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(23, 212, 237, 2);
			panelCliente.add(separator);
		}
		
		panelMenu = new JPanel();
		panelMenu.setBounds(269, 39, 839, 564);
		contentPanel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel iconoCliente = new JLabel("");
		iconoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				iconoCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelCliente.setVisible(true);
				panelAltice.setVisible(false);
				panelConsulta.setVisible(false);
				panelFactura.setVisible(false);
				panelPersonalA.setVisible(false);
				panelPlanes.setVisible(false);
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
		panelMenu.add(iconoCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCliente.setBounds(110, 201, 80, 14);
		panelMenu.add(lblCliente);
		
		JLabel iconoPersonalA = new JLabel("");
		iconoPersonalA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelCliente.setVisible(false);
				panelAltice.setVisible(false);
				panelConsulta.setVisible(false);
				panelFactura.setVisible(false);
				panelPersonalA.setVisible(true);
				panelPlanes.setVisible(false);
				
				
				
				
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
		panelMenu.add(iconoPersonalA);
		
		JLabel lblPersonalA = new JLabel("Personal Autorizado\r\n");
		lblPersonalA.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPersonalA.setBounds(342, 201, 173, 14);
		panelMenu.add(lblPersonalA);
		
		JLabel iconoPlanes = new JLabel("");
		iconoPlanes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
			
				iconoPlanes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));	
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelCliente.setVisible(true);
				panelAltice.setVisible(false);
				panelConsulta.setVisible(false);
				panelFactura.setVisible(false);
				panelPersonalA.setVisible(false);
				panelPlanes.setVisible(true);
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
		panelMenu.add(iconoPlanes);
		
		JLabel lblPlanes = new JLabel("Planes");
		lblPlanes.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlanes.setBounds(674, 201, 64, 14);
		panelMenu.add(lblPlanes);
		
		JLabel iconoFactura = new JLabel("");
		iconoFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				iconoFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelCliente.setVisible(false);
				panelAltice.setVisible(false);
				panelConsulta.setVisible(false);
				panelFactura.setVisible(true);
				panelPersonalA.setVisible(false);
				panelPlanes.setVisible(false);
			}
		});
		iconoFactura.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				iconoFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
				
			}
		});
		iconoFactura.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Factura4.png")));
		iconoFactura.setBounds(205, 298, 118, 157);
		panelMenu.add(iconoFactura);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFactura.setBounds(254, 466, 86, 14);
		panelMenu.add(lblFactura);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelCliente.setVisible(false);
				panelAltice.setVisible(false);
				panelConsulta.setVisible(true);
				panelFactura.setVisible(false);
				panelPersonalA.setVisible(false);
				panelPlanes.setVisible(false);
			}
		});
		iconoConsultas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/Consultas6.png")));
		iconoConsultas.setBounds(506, 298, 159, 147);
		panelMenu.add(iconoConsultas);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConsultas.setBounds(539, 466, 87, 14);
		panelMenu.add(lblConsultas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.setBounds(759, 530, 70, 23);
		panelMenu.add(btnSalir);
		
		panelCerrar = new JPanel();
		panelCerrar.setBounds(269, 0, 839, 38);
		contentPanel.add(panelCerrar);
		panelCerrar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonCerrar.png")));
		lblNewLabel.setBounds(1039, 11, 46, 20);
		panelCerrar.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ImagenesVentanaP/BotonMinimizar.png")));
		label_1.setBounds(998, 11, 38, 22);
		panelCerrar.add(label_1);
		
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
		panelCerrar.add(btnCerrar);
	}
}
