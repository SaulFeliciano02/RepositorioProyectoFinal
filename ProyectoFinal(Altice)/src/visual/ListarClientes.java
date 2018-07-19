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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;


public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static JButton btnModificar;
	private static DefaultTableModel model;
	private static Object fila[];
	private String cedula;
	private JTextField txtCedula;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public ListarClientes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		setFont(new Font("Futura Bk BT", Font.PLAIN, 12));
		setTitle("Listado de Clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 700, 537);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBackground(new Color(240, 240, 240));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(2, 100, 688, 359);
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
					String[] columnNames = {"Cédula", "Nombre", "Teléfono", "Dirección"};
					model.setColumnIdentifiers(columnNames);
					loadtable();
					scrollPane.setViewportView(table);
				}
			}
			
			txtCedula = new JTextField();
			txtCedula.setBounds(323, 46, 218, 29);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JButton button = new JButton("...");
			button.setBounds(553, 46, 45, 29);
			panel.add(button);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setFont(new Font("Arial", Font.BOLD, 14));
			lblCdula.setBounds(437, 13, 73, 16);
			panel.add(lblCdula);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(323, 37, 317, 2);
			panel.add(separator);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 240, 240));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setForeground(Color.WHITE);
				btnModificar.setBackground(Color.BLACK);
				btnModificar.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!cedula.equalsIgnoreCase(""))
						{
							Cliente aux = CentralAltice.getInstance().buscarCliente(cedula);
							RegistrarCliente2 reg = null;
							try {
								reg = new RegistrarCliente2("Modificación de Cliente", aux);
							} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
									| UnsupportedLookAndFeelException | ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							reg.setModal(true);
							reg.setVisible(true);
							btnModificar.setEnabled(false);
						}
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setFont(new Font("Futura Bk BT", Font.PLAIN, 16));
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula", "Nombre", "Tel\u00E9fono", "Direcci\u00F3n", "Estado"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
	}
}
