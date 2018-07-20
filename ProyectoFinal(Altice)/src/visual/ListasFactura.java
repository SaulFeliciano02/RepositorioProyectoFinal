package visual;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.CentralAltice;
import logico.Cliente;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListasFactura extends JDialog {

	private final JPanel contentPane;
	private JTextField textField;
	private static DefaultTableModel modoTabla  = new DefaultTableModel();
	private static CentralAltice listarCliente;
	private static Object fila[];
	private JTable table;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListasFactura() {
		setResizable(false);
		setTitle("Lista de facturas");
		setBounds(100, 100, 670, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 654, 251);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				if (table.getSelectedRow()>=0)
				{
					btnSalir.setEnabled(true);
					int index = table.getSelectedRow();
					cedula = (String)table.getModel().getValueAt(index, 0);}
				
				*/
				
				
			}
		});
		String columna[] = {"Fecha", "Nombre del cliente", "Nombre del plan","Monto"};
		modoTabla.setColumnIdentifiers(columna);
		scrollPane.setViewportView(table);
		
		JLabel lblIntroducirCedula = new JLabel("Introducir c\u00E9dula");
		lblIntroducirCedula.setFont(new Font("Arial", Font.BOLD, 11));
		lblIntroducirCedula.setBounds(409, 11, 104, 14);
		contentPane.add(lblIntroducirCedula);
		
		textField = new JTextField();
		textField.setBounds(380, 39, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ListasFactura.class.getResource("/ImagenesVentanaP/Lupa21x21.png")));
		btnNewButton.setBounds(558, 36, 41, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(316, 30, 283, 2);
		contentPane.add(separator);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.addMouseListener(new MouseAdapter() {
			
		});
		btnSalir.setBounds(565, 345, 89, 23);
		contentPane.add(btnSalir);
		
		
		cargartabla();
		
		
	}

	private void cargartabla() {
		
	
		modoTabla.setRowCount(0);
		Object[] fila = new Object[modoTabla.getColumnCount()];
		for (Cliente cli: CentralAltice.getInstance().getMisClientes())
		{
			fila[0] = cli.getCedula();
			fila[1] = cli.getNombre();
			fila[2] = cli.getTelefono();
			fila[3] = cli.isEstado();
					
			
			modoTabla.addRow(fila);
		}
		table.setModel(modoTabla);
	}
	
	
	
	
	
	
}
