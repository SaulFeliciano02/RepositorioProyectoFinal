package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.CentralAltice;
import logico.PersonalAdministra;
import logico.PersonalAuto;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel tablaModelo  = new DefaultTableModel();
	private static Object fila[];

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListadoPersonal() {
		setTitle("Listado personal");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 750, 473);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 714, 321);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cédula", "Nombre(s) y/o apellido(s)", "Teléfono", "Dirección"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(215);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.getColumnModel().getColumn(3).setPreferredWidth(185);
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBounds(635, 401, 89, 23);
		contentPanel.add(btnSalir);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int aux = comboBox.getSelectedIndex();
				cargartabla(aux);
				
				
				
			}

			private void cargartabla(int ind) {
					
		
					tablaModelo.setRowCount(0);
					fila = new Object[tablaModelo.getColumnCount()];
						
					switch(ind) {
					
					case 0: {
					
						for(PersonalAuto todos : CentralAltice.getInstance().getMiPersonal()) {
							fila[0] = todos.getCedula();
							fila[1] = todos.getDireccion();
							fila[2]= todos.getNombre();
							fila[3]= todos.getTelefono();
							
							tablaModelo.addRow(fila);}}
						
					break;
					
					case 1: {
						
						for(PersonalAuto admin : CentralAltice.getInstance().getMiPersonal()) {
							if(admin instanceof PersonalAdministra) {
								fila[0] = admin.getCedula();
								fila[1] = admin.getDireccion();
								fila[2]= admin.getNombre();
								fila[3]= admin.getTelefono();
								
								tablaModelo.addRow(fila);}}
						
							break;
					}
					
					case 2: {
						
						for(PersonalAuto comercial : CentralAltice.getInstance().getMiPersonal()) {
							if(comercial instanceof PersonalAdministra) {
								fila[0] = comercial.getCedula();
								fila[1] = comercial.getDireccion();
								fila[2]= comercial.getNombre();
								fila[3]= comercial.getTelefono();
								
								tablaModelo.addRow(fila);}}
						
							break;}}
					
		
				table.setModel(tablaModelo);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				TableColumnModel tamañoTabla = table.getColumnModel();
				tamañoTabla.getColumn(0).setPreferredWidth(70);
				
				tamañoTabla.getColumn(1).setPreferredWidth(100);
				tamañoTabla.getColumn(2).setPreferredWidth(100);
				tamañoTabla.getColumn(3).setPreferredWidth(100);
				tamañoTabla.getColumn(4).setPreferredWidth(100);
				
			}
		});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Comercial", "Administrativo"}));
		comboBox.setBounds(612, 23, 112, 23);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}