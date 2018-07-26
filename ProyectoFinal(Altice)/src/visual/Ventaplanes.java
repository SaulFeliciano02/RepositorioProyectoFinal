package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
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
import planes.Plan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventaplanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDireccion;
	private Cliente miCliente;
	private JFormattedTextField formattedTextTelefono;
	private JFormattedTextField formattedTextCedula;
	

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
		setBounds(100, 100, 740, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 31, 217, 391);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Arial", Font.BOLD, 13));
		lblCedula.setBounds(10, 27, 123, 14);
		panel.add(lblCedula);
		
		JFormattedTextField formattedTextCedula = new JFormattedTextField();
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
		
		JFormattedTextField formattedTextTelefono = new JFormattedTextField();
		formattedTextTelefono.setEnabled(false);
		formattedTextTelefono.setBounds(10, 205, 185, 27);
		panel.add(formattedTextTelefono);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente aux = CentralAltice.getInstance().buscarCliente(formattedTextCedula.getText());
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
				
			
		});
		btnNewButton.setIcon(new ImageIcon(Ventaplanes.class.getResource("/ImagenesVentanaP/Lupa21x21.png")));
		btnNewButton.setBounds(155, 45, 40, 29);
		panel.add(btnNewButton);
		
		/*JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Planes") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Planes moviles");
						node_2= new DefaultMutableTreeNode("Planes Limitados PRO Friends & Family");
							node_1.add(new DefaultMutableTreeNode(""));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Planes Limitados Apps");
							node_2.add(new DefaultMutableTreeNode(""));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Planes Prepago");
							node_2.add(new DefaultMutableTreeNode(""));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Planes Ilimitados");
							node_2.add(new DefaultMutableTreeNode(""));
						node_1.add(node_2);
						add(node_1);
					node_1 = new DefaultMutableTreeNode("Planes Internet");
						node_2 = new DefaultMutableTreeNode("Plan Ilimitado");
					add(new DefaultMutableTreeNode("Ilimitado1"));
					add(new DefaultMutableTreeNode("Ilimitado2"));
						add(new DefaultMutableTreeNode("Ilimitado3"));
						add(new DefaultMutableTreeNode("Ilimitado4"));
					add(node_2);
				add(node_1);
					node_1 = new DefaultMutableTreeNode("Planes por Capacidad");
					add(new DefaultMutableTreeNode(""));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Planes combo");
						add(new DefaultMutableTreeNode(""));
					add(new DefaultMutableTreeNode(""));
				add(node_1);
				}
			}
		));
		tree.setBounds(237, 31, 186, 391);
		contentPanel.add(tree);*/
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBackground(Color.WHITE);
		panelInformacion.setBounds(433, 31, 281, 391);
		contentPanel.add(panelInformacion);
		panelInformacion.setLayout(null);
		
		JLabel lblInformacionDelPlan = new JLabel("Informaci\u00F3n del plan");
		lblInformacionDelPlan.setFont(new Font("Arial", Font.BOLD, 13));
		lblInformacionDelPlan.setBounds(63, 11, 208, 14);
		panelInformacion.add(lblInformacionDelPlan);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(27, 59, 231, 297);
		panelInformacion.add(textPane);
		
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Planes") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Plenes mov\u00EDles");
					node_2 = new DefaultMutableTreeNode("Planes Limitados PRO Friends & Family");
				     node_2.add(new DefaultMutableTreeNode(""));
				  node_1.add(node_2);
					     
					  node_2 = new DefaultMutableTreeNode("Planes Limitados Apps");
					     node_2.add(new DefaultMutableTreeNode(""));
					  node_1.add(node_2);
					  node_2 = new DefaultMutableTreeNode("Planes Prepago");
					     node_2.add(new DefaultMutableTreeNode(""));
					  node_1.add(node_2);   
					  node_2 = new DefaultMutableTreeNode("Planes Ilimitados");
					     node_2.add(new DefaultMutableTreeNode(""));
					  node_1.add(node_2);
					  
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Planes Internet");
					  node_2 = new DefaultMutableTreeNode("Planes Ilimitado");
				         node_2.add(new DefaultMutableTreeNode("Ilimitado 1"));
				         node_2.add(new DefaultMutableTreeNode("Ilimitado 2"));
				         node_2.add(new DefaultMutableTreeNode("Ilimitado 3"));
				         node_2.add(new DefaultMutableTreeNode("Ilimitado 4"));
				      node_1.add(node_2);
				      node_2 = new DefaultMutableTreeNode("Plan por capacidad");
				         node_2.add(new DefaultMutableTreeNode(""));
				         node_2.add(new DefaultMutableTreeNode(""));
				         node_2.add(new DefaultMutableTreeNode(""));
				         node_2.add(new DefaultMutableTreeNode(""));
				      node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Plan todo");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
					
					
					
				}
			}
		));
		tree.setBounds(237, 30, 186, 392);
		contentPanel.add(tree);
		
        
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Adquirir");
				okButton.setBackground(Color.BLACK);
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
}
