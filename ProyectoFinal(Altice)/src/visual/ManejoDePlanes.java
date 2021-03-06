package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import logico.CentralAltice;
import persistivos.ArchivarCentral;
import planes.Plan;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class ManejoDePlanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList<String> listPlanes;
	private JList<String> listDisponibles;
	private DefaultListModel<String> modelPlanes = new DefaultListModel<>();
	private DefaultListModel<String> modelDisponibles = new DefaultListModel<>();
	private String nombreDelPlan;
	private JButton btnDisponible;
	private JButton btnNoDisponible;

	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	
	
	public ManejoDePlanes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManejoDePlanes.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		setFont(new Font("Futura Bk BT", Font.PLAIN, 12));
		setTitle("Manejo de Planes Altice");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 869, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panelPlanes = new JPanel();
			panelPlanes.setBorder(null);
			panelPlanes.setBackground(Color.BLACK);
			panelPlanes.setBounds(34, 47, 334, 419);
			panel.add(panelPlanes);
			panelPlanes.setLayout(null);
			{
				JLabel lblPlanes = new JLabel("Planes");
				lblPlanes.setFont(new Font("Arial", Font.PLAIN, 23));
				lblPlanes.setForeground(Color.WHITE);
				lblPlanes.setBounds(12, 18, 91, 19);
				panelPlanes.add(lblPlanes);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 42, 334, 377);
			panelPlanes.add(scrollPane);
			{
				listPlanes = new JList<>();
				listPlanes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listPlanes.setModel(modelPlanes);
				listPlanes.setModel(modelPlanes);
				listPlanes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(listPlanes.getSelectedIndex()>=0)
						{
							nombreDelPlan = (String)listPlanes.getModel().getElementAt(listPlanes.getSelectedIndex());
							btnDisponible.setEnabled(true);
							btnNoDisponible.setEnabled(false);
						}
					}
				});
				
				listPlanes.setFont(new Font("Arial", Font.PLAIN, 14));
				listPlanes.setSize(332, 379);
				listPlanes.setBorder(null);
				scrollPane.setViewportView(listPlanes);
			}
			{
				JPanel panelDisponibles = new JPanel();
				panelDisponibles.setLayout(null);
				panelDisponibles.setBorder(null);
				panelDisponibles.setBackground(Color.BLACK);
				panelDisponibles.setBounds(468, 47, 334, 419);
				panel.add(panelDisponibles);
				{
					JLabel lblDisponibles = new JLabel("Disponibles");
					lblDisponibles.setForeground(Color.WHITE);
					lblDisponibles.setFont(new Font("Arial", Font.PLAIN, 23));
					lblDisponibles.setBounds(12, 13, 141, 29);
					panelDisponibles.add(lblDisponibles);
				}
				{
					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					scrollPane_1.setBounds(0, 42, 334, 377);
					panelDisponibles.add(scrollPane_1);
					{
						listDisponibles = new JList<String>();
						listDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						listDisponibles.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if(listDisponibles.getSelectedIndex()>=0)
								{
									nombreDelPlan = (String)listDisponibles.getModel().getElementAt(listDisponibles.getSelectedIndex());
									btnNoDisponible.setEnabled(true);
									btnDisponible.setEnabled(false);
								}
							}
						});
						listDisponibles.setFont(new Font("Arial", Font.PLAIN, 14));
						listDisponibles.setBorder(null);
						scrollPane_1.setViewportView(listDisponibles);
					}
				}
			}
			
			btnDisponible = new JButton("");
			btnDisponible.setIcon(new ImageIcon(ManejoDePlanes.class.getResource("/ImagenesVentanaP/disponibleAi.png")));
			btnDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnDisponible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!nombreDelPlan.equalsIgnoreCase(""))
					{
						modelDisponibles.addElement(modelPlanes.getElementAt(listPlanes.getSelectedIndex()));
						listDisponibles.setModel(modelDisponibles);
						modelPlanes.removeElementAt(listPlanes.getSelectedIndex());
						listPlanes.setModel(modelPlanes);
						btnDisponible.setEnabled(false);
						btnNoDisponible.setEnabled(false);
						nombreDelPlan = "";
					}
				}
			});
			btnDisponible.setEnabled(false);
			btnDisponible.setForeground(Color.WHITE);
			btnDisponible.setBackground(Color.BLACK);
			btnDisponible.setBounds(379, 215, 76, 36);
			panel.add(btnDisponible);
			
			btnNoDisponible = new JButton("");
			btnNoDisponible.setIcon(new ImageIcon(ManejoDePlanes.class.getResource("/ImagenesVentanaP/rechazado.png")));
			btnNoDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnNoDisponible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!nombreDelPlan.equalsIgnoreCase(""))
					{
						modelPlanes.addElement(modelDisponibles.getElementAt(listDisponibles.getSelectedIndex()));
						listPlanes.setModel(modelPlanes);
						modelDisponibles.removeElementAt(listDisponibles.getSelectedIndex());
						listDisponibles.setModel(modelDisponibles);
						btnDisponible.setEnabled(false);
						btnNoDisponible.setEnabled(false);
						nombreDelPlan = "";
					}
				}
			});
			btnNoDisponible.setEnabled(false);
			btnNoDisponible.setForeground(Color.WHITE);
			btnNoDisponible.setBackground(Color.BLACK);
			btnNoDisponible.setBounds(381, 283, 76, 36);
			panel.add(btnNoDisponible);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnGuardar = new JButton("Guardar");
					btnGuardar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actualizarArreglosDePlanes();
							try {
								ArchivarCentral archivo = new ArchivarCentral();
								archivo.guardar(CentralAltice.getInstance());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
					});
					btnGuardar.setForeground(Color.WHITE);
					btnGuardar.setBackground(Color.BLACK);
					btnGuardar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
					buttonPane.add(btnGuardar);
				}
				btnSalir.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setBackground(Color.BLACK);
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		loadPlanes();
	}
	
	private void loadPlanes()
	{
		for ( Plan aux : CentralAltice.getInstance().getPlanesNoDisponibles()) {
			modelPlanes.addElement(aux.getClass().getSimpleName());
		}
		listPlanes.setModel(modelPlanes);
	
	
		for ( Plan aux : CentralAltice.getInstance().getPlanesDisponibles()) {
			modelDisponibles.addElement(aux.getClass().getSimpleName());
		}
		listDisponibles.setModel(modelDisponibles);
	}
	
	private void actualizarArreglosDePlanes()
	{
		CentralAltice.getInstance().getPlanesDisponibles().removeAll(CentralAltice.getInstance().getPlanesDisponibles());
		CentralAltice.getInstance().getPlanesNoDisponibles().removeAll(CentralAltice.getInstance().getPlanesNoDisponibles());
		
		for (int i = 0; i < modelDisponibles.size(); i++) {
			CentralAltice.getInstance().getPlanesDisponibles().add(i, CentralAltice.getInstance().buscarPlan(modelDisponibles.getElementAt(i).toString()));
		}
		
		for (int i = 0; i < modelPlanes.size(); i++) {
			CentralAltice.getInstance().getPlanesNoDisponibles().add(i, CentralAltice.getInstance().buscarPlan(modelPlanes.getElementAt(i).toString()));	
		}
	}
}