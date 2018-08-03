package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.CentralAltice;
import logico.Cliente;
import logico.PersonalAuto;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object fila[];
	private String cedula;
	private JTextField txtCedula;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListarClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarClientes.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		setFont(new Font("Futura Bk BT", Font.PLAIN, 12));
		setTitle("Listado de Clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 767, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(new Color(240, 240, 240));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(12, 91, 737, 311);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.setFont(new Font("Arial", Font.PLAIN, 13));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0)
							{
								btnModificar.setEnabled(true);
								int index = table.getSelectedRow();
								cedula = (String)table.getModel().getValueAt(index, 0);
							}
						}
					});
					table.setBackground(Color.WHITE);
					model = new DefaultTableModel();
					String[] columnNames = {"Cédula", "Nombre", "Teléfono", "Dirección", "Estado"};
					model.setColumnIdentifiers(columnNames);
					loadtable();
					scrollPane.setViewportView(table);
				}
			}
			
			txtCedula = new JTextField();
			txtCedula.setBounds(543, 54, 154, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JButton btnSearch = new JButton("");
			btnSearch.setIcon(new ImageIcon(ListarClientes.class.getResource("/ImagenesVentanaP/LupaNegra21x21.png")));
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cedula = txtCedula.getText();
					Cliente elBuscado = CentralAltice.getInstance().buscarCliente(cedula);
					if(!txtCedula.getText().equalsIgnoreCase("") && elBuscado!=null)
					{
						model.setRowCount(0);
						fila[0] = elBuscado.getCedula();
						fila[1] = elBuscado.getNombre();
						fila[2] = elBuscado.getTelefono();
						fila[3] = elBuscado.getDireccion();
						fila[4] = elBuscado.isEstado();
						model.addRow(fila);
						table.setModel(model);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSearch.setBounds(709, 54, 40, 25);
			panel.add(btnSearch);
			
			JLabel lblCdula = new JLabel("C\u00E9dula");
			lblCdula.setFont(new Font("Arial", Font.BOLD, 14));
			lblCdula.setBounds(700, 29, 73, 16);
			panel.add(lblCdula);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(543, 49, 206, 2);
			panel.add(separator);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
			btnSalir.setBackground(Color.BLACK);
			btnSalir.setActionCommand("Cancel");
			btnSalir.setBounds(680, 415, 65, 31);
			panel.add(btnSalir);
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(!cedula.equalsIgnoreCase("")) {
						
						Cliente modifica = CentralAltice.getInstance().buscarCliente(cedula);
						RegistroCliente listado = new RegistroCliente("Modificar", modifica);
						listado.setLocationRelativeTo(null);
						listado.setVisible(true);
						listado.setModal(true);
						btnModificar.setEnabled(false);
					}
				}
			});
			btnModificar.setForeground(Color.WHITE);
			btnModificar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
			btnModificar.setEnabled(false);
			btnModificar.setBackground(Color.BLACK);
			btnModificar.setActionCommand("OK");
			btnModificar.setBounds(570, 415, 105, 31);
			panel.add(btnModificar);
		}
	}

	public static void loadtable() {
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Cliente aux: CentralAltice.getInstance().getMisClientes())
		{
			fila[0] = aux.getCedula();
			fila[1] = aux.getNombre();
			fila[2] = aux.getTelefono();
			fila[3] = aux.getDireccion();
			fila[4] = aux.isEstado();
			model.addRow(fila);
		}
		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
	}
}
