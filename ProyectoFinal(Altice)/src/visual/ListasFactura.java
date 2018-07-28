package visual;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtCedula;
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
		setBounds(100, 100, 767, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 72, 737, 251);
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
		String columna[] = {"Fecha", "Nombre del cliente", "Cédula", "Plan", "Monto", "Estado de Factura"};
		modoTabla.setColumnIdentifiers(columna);
		scrollPane.setViewportView(table);
		
		JLabel lblIntroducirCedula = new JLabel("Introducir c\u00E9dula");
		lblIntroducirCedula.setFont(new Font("Arial", Font.BOLD, 11));
		lblIntroducirCedula.setBounds(409, 11, 104, 14);
		contentPane.add(lblIntroducirCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(380, 39, 168, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				Cliente elBuscado = CentralAltice.getInstance().buscarCliente(cedula);
				if(!txtCedula.getText().equalsIgnoreCase("") && elBuscado!=null)
				{
					modoTabla.setRowCount(0);
					for (int i = 0; i < elBuscado.getMisFacturas().size(); i++) {
					fila[0] = elBuscado.getMisFacturas().get(i).getFecha();
					fila[1] = elBuscado.getNombre();
					fila[2] = elBuscado.getCedula();
					if(elBuscado.getPlanesDisponibles()!=null)
					{
						fila[3] = elBuscado.getPlanesDisponibles().getClass().getSimpleName();
					}
					else
					{
						fila[3] = "Anulado";
					}
					BigDecimal bd = new BigDecimal(elBuscado.getMisFacturas().get(i).getMontoTotal());
					bd = bd.setScale(2, RoundingMode.HALF_UP); //Metodo para redondear a dos cifras despues de punto
					fila[4] = bd;
					if(!elBuscado.getMisFacturas().get(i).isEstado())
					{
						fila[5] = "Adeudado";	
					}
					else
					{
						fila[5] = "Saldado";	
					}
					modoTabla.addRow(fila);
					}
					table.setModel(modoTabla);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setIcon(new ImageIcon(ListasFactura.class.getResource("/ImagenesVentanaP/LupaNegra21x21.png")));
		btnSearch.setBounds(558, 38, 41, 23);
		contentPane.add(btnSearch);
		
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
		btnSalir.setBounds(627, 336, 89, 23);
		contentPane.add(btnSalir);
		
		
		cargartabla();
		
		
	}

	private void cargartabla() {
		
	
		modoTabla.setRowCount(0);
		fila = new Object[modoTabla.getColumnCount()];
		for (Cliente cli: CentralAltice.getInstance().getMisClientes())
		{
			for (int i = 0; i < cli.getMisFacturas().size(); i++) {
				fila[0] = cli.getMisFacturas().get(i).getFecha();
				fila[1] = cli.getNombre();
				fila[2] = cli.getCedula();
				if(cli.getPlanesDisponibles()!=null)
				{
					fila[3] = cli.getPlanesDisponibles().getClass().getSimpleName();
				}
				else
				{
					fila[3] = "Anulado";
				}
				BigDecimal bd = new BigDecimal(cli.getMisFacturas().get(i).getMontoTotal());
				bd = bd.setScale(2, RoundingMode.HALF_UP);
				fila[4] = bd;
				if(!cli.getMisFacturas().get(i).isEstado())
				{
					fila[5] = "Adeudado";	
				}
				else
				{
					fila[5] = "Saldado";	
				}
				
				
				modoTabla.addRow(fila);
			}
		}
		table.setModel(modoTabla);
	}
	
	
	
	
	
	
}
