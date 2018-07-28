package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import logico.CentralAltice;
import logico.Cliente;
import logico.Factura;
import persistivos.ArchivarCentral;
import planes.IlimitadoApp;
import planes.IlimitadoFamiliaAmigo;
import planes.IlimitadoPRO;
import planes.InternetMovil;
import planes.Plan;
import planes.PlanIlimitado;
import planes.PlanMovil;
import planes.PlanXCapacidad;
import planes.ilimitadoPROUltraHD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Ventaplanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDireccion;
	private Cliente miCliente;
	private JFormattedTextField formattedTextTelefono;
	private JFormattedTextField formattedTextCedula;
	private JTree treePlanes;
	private JTextPane textPaneInformation; 
	private JButton btnAdquirir;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Ventaplanes() {
		setTitle("Venta de Planes Altice");
		setResizable(false);
		setModal(true);
		this.miCliente=miCliente;
		setBounds(100, 100, 907, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 31, 224, 391);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Arial", Font.BOLD, 13));
		lblCedula.setBounds(10, 27, 123, 14);
		panel.add(lblCedula);
		
		formattedTextCedula = new JFormattedTextField();
		formattedTextCedula.setBounds(10, 45, 142, 27);
		panel.add(formattedTextCedula);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Arial", Font.BOLD, 13));
		lblDireccion.setBounds(10, 254, 123, 14);
		panel.add(lblDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setEnabled(false);
		textDireccion.setBounds(10, 278, 185, 27);
		panel.add(textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombre.setBounds(10, 96, 123, 14);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setBounds(10, 121, 185, 27);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefono.setBounds(10, 180, 123, 14);
		panel.add(lblTelefono);
		
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("(###)-###-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField formattedTextTelefono = new JFormattedTextField(mascara);
		formattedTextTelefono.setEnabled(false);
		formattedTextTelefono.setBounds(10, 205, 185, 27);
		panel.add(formattedTextTelefono);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!formattedTextCedula.getText().equalsIgnoreCase(""))
				{
					Cliente aux = CentralAltice.getInstance().buscarCliente(formattedTextCedula.getText());
					formattedTextCedula.setBackground(Color.WHITE);
					if(aux != null)
					{
						textNombre.setText(aux.getNombre());
						formattedTextTelefono.setText(aux.getTelefono());
						textDireccion.setText(aux.getDireccion());
					}
					else
					{
						textNombre.setEnabled(true);
						formattedTextTelefono.setEnabled(true);
						textDireccion.setEnabled(true);
					}
				}
				else
				{
					formattedTextCedula.setBackground(new Color(250, 60, 60));
				}
				
				
			}
				
			
		});
		btnSearch.setIcon(new ImageIcon(Ventaplanes.class.getResource("/ImagenesVentanaP/LupaNegra21x21.png")));
		btnSearch.setBounds(155, 44, 40, 27);
		panel.add(btnSearch);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBackground(Color.WHITE);
		panelInformacion.setBounds(541, 31, 348, 391);
		contentPanel.add(panelInformacion);
		panelInformacion.setLayout(null);
		
		JLabel lblInformacionDelPlan = new JLabel("Informaci\u00F3n del plan");
		lblInformacionDelPlan.setFont(new Font("Arial", Font.BOLD, 13));
		lblInformacionDelPlan.setBounds(105, 13, 208, 14);
		panelInformacion.add(lblInformacionDelPlan);
		
		textPaneInformation = new JTextPane();
		textPaneInformation.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaneInformation.setEditable(false);
		textPaneInformation.setBackground(Color.WHITE);
		textPaneInformation.setBounds(27, 59, 296, 297);
		panelInformacion.add(textPaneInformation);
		
		JPanel panelTree = new JPanel();
		panelTree.setBounds(246, 31, 283, 391);
		contentPanel.add(panelTree);
		panelTree.setLayout(new BorderLayout(0, 0));
		
		treePlanes = new JTree();
		treePlanes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode selected = (DefaultMutableTreeNode) treePlanes.getSelectionPath().getLastPathComponent();

				if(selected.isLeaf() && (CentralAltice.getInstance().buscarPlan(selected.toString()) instanceof PlanMovil))
				{
					Plan aux = (CentralAltice.getInstance().buscarPlan(selected.toString()));
					textPaneInformation.setText("Minutos: " + ((PlanMovil) aux).getMinutos()
							+ "\n\nCantidad de Megabytes: " + ((PlanMovil) aux).getMegas()
							+ "\n\nPrecio: " + aux.getPrecioPlan()
							+ "\n\nRoaming USA incluido"); 
					btnAdquirir.setEnabled(true);
				}
				if(selected.isLeaf() && (CentralAltice.getInstance().buscarPlan(selected.toString()) instanceof PlanIlimitado))
				{
					Plan aux = (CentralAltice.getInstance().buscarPlan(selected.toString()));
					textPaneInformation.setText("Velocidad: " + ((PlanIlimitado) aux).getVelocidad()
							+ "\n\nPrecio: " + aux.getPrecioPlan()); 
					btnAdquirir.setEnabled(true);
				}
				if(selected.isLeaf() && (CentralAltice.getInstance().buscarPlan(selected.toString()) instanceof PlanXCapacidad))
				{
					Plan aux = (CentralAltice.getInstance().buscarPlan(selected.toString()));
					textPaneInformation.setText("Cantidad de Internet adicional: " + ((PlanXCapacidad) aux).getInternetAdicional()
							+ "\n\nPrecio: " + aux.getPrecioPlan()
							+ "\n\nNavegación ilimitada gratis a 512Kbps"); 
					btnAdquirir.setEnabled(true);
				}
				
				if(!selected.isLeaf())
				{
					btnAdquirir.setEnabled(false);
					textPaneInformation.setText("");
				}
			}
		});
		panelTree.add(treePlanes, BorderLayout.CENTER);
        
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAdquirir = new JButton("Adquirir");
				btnAdquirir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!formattedTextCedula.getText().equalsIgnoreCase(""))
						{
							Cliente aux = CentralAltice.getInstance().buscarCliente(formattedTextCedula.getText());
							
							if(aux == null)
							{
								aux = new Cliente(formattedTextCedula.getText(), textNombre.getText(), textDireccion.getText(), formattedTextTelefono.getText());
								CentralAltice.getInstance().agregarCliente(aux);
							}
							
							Plan selecionado = CentralAltice.getInstance().buscarPlan(treePlanes.getSelectionPath().getLastPathComponent().toString());
							aux.agregarPlan(selecionado);
							try {
								ArchivarCentral archivo = new ArchivarCentral();
								archivo.guardar(CentralAltice.getInstance());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operación sactisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							formattedTextCedula.setBackground(new Color(250, 60, 60));
							JOptionPane.showMessageDialog(null, "Debe llenar los campos del Cliente", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				btnAdquirir.setEnabled(false);
				btnAdquirir.setBackground(Color.BLACK);
				btnAdquirir.setForeground(Color.WHITE);
				btnAdquirir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				btnAdquirir.setActionCommand("OK");
				buttonPane.add(btnAdquirir);
				getRootPane().setDefaultButton(btnAdquirir);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setBackground(Color.BLACK);
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		
		rellenarJtree();
	}


	private void rellenarJtree() {
		
		ArrayList<Plan> planesDis = CentralAltice.getInstance().getPlanesDisponibles();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Planes");
		DefaultMutableTreeNode planesMoviles = new DefaultMutableTreeNode("Planes Móviles");
		DefaultMutableTreeNode internetMovil = new DefaultMutableTreeNode("Internet Móvil");
		DefaultTreeModel model = new DefaultTreeModel(root);
		model.setRoot(root);
		
		model.insertNodeInto(planesMoviles, root, root.getChildCount());
		model.insertNodeInto(internetMovil, root, root.getChildCount());
		
		DefaultMutableTreeNode ilimitadoPro = new DefaultMutableTreeNode("Ilimitado Pro");
		DefaultMutableTreeNode ilimitadoF = new DefaultMutableTreeNode("Ilimitado Friends&Family");
		DefaultMutableTreeNode ilimitadoApp = new DefaultMutableTreeNode("Ilimitado Apps");
		DefaultMutableTreeNode ilimitadoInternet = new DefaultMutableTreeNode("Internet Ilimitado");
		DefaultMutableTreeNode planesXCapacidad = new DefaultMutableTreeNode("Planes por Capacidad");
		
		model.insertNodeInto(ilimitadoPro, planesMoviles, planesMoviles.getChildCount());
		model.insertNodeInto(ilimitadoF, planesMoviles, planesMoviles.getChildCount());
		model.insertNodeInto(ilimitadoApp, planesMoviles, planesMoviles.getChildCount());
		model.insertNodeInto(ilimitadoInternet, internetMovil, internetMovil.getChildCount());
		model.insertNodeInto(planesXCapacidad, internetMovil, internetMovil.getChildCount());
		
		for (Plan aux : planesDis) {
			if(aux instanceof IlimitadoPRO)
			{
				DefaultMutableTreeNode nuevoPlan = new DefaultMutableTreeNode(aux.getClass().getSimpleName());
				model.insertNodeInto(nuevoPlan, ilimitadoPro, ilimitadoPro.getChildCount());
			}
			if(aux instanceof IlimitadoFamiliaAmigo)
			{
				DefaultMutableTreeNode nuevoPlan = new DefaultMutableTreeNode(aux.getClass().getSimpleName());
				model.insertNodeInto(nuevoPlan, ilimitadoF, ilimitadoF.getChildCount());
			}
			if(aux instanceof IlimitadoApp)
			{
				DefaultMutableTreeNode nuevoPlan = new DefaultMutableTreeNode(aux.getClass().getSimpleName());
				model.insertNodeInto(nuevoPlan, ilimitadoApp, ilimitadoApp.getChildCount());
			}
			if(aux instanceof PlanIlimitado)
			{
				DefaultMutableTreeNode nuevoPlan = new DefaultMutableTreeNode(aux.getClass().getSimpleName());
				model.insertNodeInto(nuevoPlan, ilimitadoInternet, ilimitadoInternet.getChildCount());
			}
			if(aux instanceof PlanXCapacidad)
			{
				DefaultMutableTreeNode nuevoPlan = new DefaultMutableTreeNode(aux.getClass().getSimpleName());
				model.insertNodeInto(nuevoPlan, planesXCapacidad, planesXCapacidad.getChildCount());
			}
		}
		
		treePlanes.setModel(model);
	}
	
}
