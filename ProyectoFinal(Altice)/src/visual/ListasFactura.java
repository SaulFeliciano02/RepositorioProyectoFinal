package visual;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

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
import java.awt.Color;
import java.awt.Toolkit;

public class ListasFactura extends JDialog {

	private final JPanel contentPane;
	private JTextField txtCedula;
	private static DefaultTableModel modoTabla  = new DefaultTableModel();
	private static CentralAltice listarCliente;
	private static Object fila[];
	private static JTable table;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListasFactura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListasFactura.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		setResizable(false);
		setTitle("Lista de facturas");
		setBounds(100, 100, 767, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 737, 323);
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
		String columna[] = {"Fecha", "Nombre del cliente", "C�dula", "Plan", "Monto", "Estado de Factura"};
		modoTabla.setColumnIdentifiers(columna);
		scrollPane.setViewportView(table);
		
		JLabel lblIntroducirCedula = new JLabel("Introducir c\u00E9dula");
		lblIntroducirCedula.setFont(new Font("Arial", Font.BOLD, 14));
		lblIntroducirCedula.setBounds(622, 32, 139, 14);
		contentPane.add(lblIntroducirCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(547, 56, 154, 22);
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
		btnSearch.setBounds(708, 55, 41, 23);
		contentPane.add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(547, 50, 202, 3);
		contentPane.add(separator);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.addMouseListener(new MouseAdapter() {
			
		});
		btnSalir.setBounds(660, 427, 89, 23);
		contentPane.add(btnSalir);
		
		
		cargartabla();
		
		
	}

	public static void cargartabla() {
		
	
		modoTabla.setRowCount(0);
		fila = new Object[modoTabla.getColumnCount()];
		for (Cliente cli: CentralAltice.getInstance().getMisClientes())
		{
			for (int i = 0; i < cli.getMisFacturas().size(); i++) {
				fila[0] = cli.getMisFacturas().get(i).getFecha().get(Calendar.MONTH)+1 + "/" + cli.getMisFacturas().get(i).getFecha().get(Calendar.DAY_OF_MONTH) + "/" + cli.getMisFacturas().get(i).getFecha().get(Calendar.YEAR);
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
