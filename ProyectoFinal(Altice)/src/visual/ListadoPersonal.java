package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import com.sun.javafx.property.adapter.JavaBeanPropertyBuilderHelper;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;
import logico.CentralAltice;
import logico.Comercial;
import logico.PersonalAdministra;
import logico.PersonalAuto;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class ListadoPersonal extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private static Object[] fila;
	private static DefaultTableModel tablaModelo;
	private static JComboBox comboBox;
	private static JButton btnModificar;
	private String cogeEldato;
	private JScrollPane scrollPane;
	private static JTable table;
	private JFormattedTextField formattedBuscar;
	private JButton button;
	

		
	//TODO imagenes ventanas
	//TODO animación pagina principal 
	
	
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @return 
	 */
	public ListadoPersonal() {
		setResizable(false);
		setModal(true);
		setTitle("Listar Personal");
		setBounds(100, 100, 567, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				{
					{
						{
						
							
						}
					}
					
					comboBox = new JComboBox();
					comboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						
							int aux = comboBox.getSelectedIndex();
							cargartabla(aux);
							
							
						}
					});
					comboBox.setModel(new DefaultComboBoxModel(new String[] {" \t<Todos>", "1.Administrativo", "2.Comercial"}));
					comboBox.setBounds(381, 7, 160, 24);
					panel.add(comboBox);
				
				}
				
				
				
				
				
				
				
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(0, 42, 551, 176);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							if(table.getSelectedRow() >= 0) {
								btnModificar.setEnabled(true);							
								int numero = table.getSelectedRow();
								cogeEldato = (String)table.getModel().getValueAt(numero, 0);
															
								
							}
							
							
						}
					});
					
					tablaModelo = new DefaultTableModel();
					String ColumnaTitulos[] = {"Cédula","Nombre(s) y/o apellidos", "Teléfono", "Dirección", "Sueldo"};
					tablaModelo.setColumnIdentifiers(ColumnaTitulos);
					cargartabla(0);
					scrollPane.setViewportView(table);
				}
				
			}
			{
				
			
				MaskFormatter mascara = null;
			try
			{
			    mascara = new MaskFormatter("###-#######-#");
			    formattedBuscar = new JFormattedTextField(mascara);
			    
			}
			catch (Exception e)
			{
			    e.printStackTrace();
			}
				
				
		
				formattedBuscar = new JFormattedTextField(mascara);
				formattedBuscar.setBounds(193, 8, 126, 22);
				panel.add(formattedBuscar);
				
				
			}
			
			
			
			
			{
				button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String cedula = formattedBuscar.getText();
						PersonalAuto buscado = CentralAltice.getInstance().buscarPersonal(cedula);
						
						if(!formattedBuscar.getText().equals("") && buscado!=null) {
							
							if(buscado instanceof PersonalAdministra){
								
								if(comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == 1)
								{
									tablaModelo.setRowCount(0);
									fila[0] = buscado.getCedula();
									fila[1] = buscado.getNombre();
									fila[2] = buscado.getTelefono();
									fila[3] = buscado.getDireccion();
									fila[4] = buscado.getSueldo();
									tablaModelo.addRow(fila);
									table.setModel(tablaModelo);
								}																	
							}
							
							if(buscado instanceof Comercial)
							{
								if(comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == 2)
								{
									tablaModelo.setRowCount(0);
									fila[0] = buscado.getCedula();
									fila[1] = buscado.getNombre();
									fila[2] = buscado.getTelefono();
									fila[3] = buscado.getDireccion();
									fila[4] = buscado.getSueldo();
									tablaModelo.addRow(fila);
									table.setModel(tablaModelo);
								}	
							}
							
						}
						
						else {
							
							JOptionPane.showMessageDialog(null, "No se ha encontrado el personal", "Busqueda de personal", JOptionPane.ERROR_MESSAGE);
						
						}
						
						
					}
				});
				button.setIcon(new ImageIcon(ListadoPersonal.class.getResource("/ImagenesVentanaP/LupaNegra21x21.png")));
				button.setBounds(322, 8, 49, 23);
				panel.add(button);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!cogeEldato.equalsIgnoreCase("")) {
							
							PersonalAuto modifica = CentralAltice.getInstance().buscarPersonal(cogeEldato);
							RegistrarPersonal listado = new RegistrarPersonal(modifica);
							listado.setLocationRelativeTo(null);
							listado.setVisible(true);
							listado.setModal(true);
							btnModificar.setEnabled(false);
						}
						
						
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnSalir = new JButton("Salir\r\n");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		} 
	}

	
	
	
	public static void cargartabla(int ind) {
		
		tablaModelo.setRowCount(0);
		fila = new Object[tablaModelo.getColumnCount()];
			
		switch(ind) {
		
		case 0: {
		
			for(PersonalAuto todos : CentralAltice.getInstance().getMiPersonal()) {
				fila[0] = todos.getCedula();
				fila[1] = todos.getNombre();
				fila[2]= todos.getTelefono();
				fila[3]= todos.getDireccion();
				fila[4]= todos.getSueldo();
				
				tablaModelo.addRow(fila);}}
			
		break;
		
		case 1: {
			
			for(PersonalAuto admin : CentralAltice.getInstance().getMiPersonal()) {
				if(admin instanceof PersonalAdministra) {
					fila[0] = admin.getCedula();
					fila[1] = admin.getNombre();
					fila[2]= admin.getTelefono();
					fila[3]= admin.getDireccion();
					fila[4]= admin.getSueldo();
					
					tablaModelo.addRow(fila);}}
			
				break;
		}
		
		case 2: {
			
			for(PersonalAuto comercial : CentralAltice.getInstance().getMiPersonal()) {
				if(comercial instanceof Comercial) {
					fila[0] = comercial.getCedula();
					fila[1] = comercial.getNombre();
					fila[2]= comercial.getTelefono();
					fila[3]= comercial.getDireccion();
					fila[4]= comercial.getSueldo();
				
					tablaModelo.addRow(fila);}}
			
				break;}
		
		}
	table.setModel(tablaModelo);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table.getTableHeader().setReorderingAllowed(false);
	TableColumnModel tamañoTabla = table.getColumnModel();
	tamañoTabla.getColumn(0).setPreferredWidth(160);
	
	tamañoTabla.getColumn(1).setPreferredWidth(150);
	tamañoTabla.getColumn(2).setPreferredWidth(150);
	tamañoTabla.getColumn(3).setPreferredWidth(100);
	tamañoTabla.getColumn(4).setPreferredWidth(100);
	
		
	}
	

	
}
	

		


