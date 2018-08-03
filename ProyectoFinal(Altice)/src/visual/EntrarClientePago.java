package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.CentralAltice;
import logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class EntrarClientePago extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField formattedCedula;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public EntrarClientePago() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EntrarClientePago.class.getResource("/ImagenesVentanaP/A de altice png1.png")));
		setTitle("Buscar cliente");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 411, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCdula.setBounds(71, 43, 72, 16);
		contentPanel.add(lblCdula);
		
		MaskFormatter mask = new MaskFormatter("###-#######-#");
		JFormattedTextField formattedCedula = new JFormattedTextField(mask);
		formattedCedula.setBounds(71, 72, 192, 22);
		contentPanel.add(formattedCedula);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setBackground(Color.BLACK);
				btnBuscar.setFont(new Font("Futura Bk BT", Font.PLAIN, 18));
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cedula = formattedCedula.getText();						
						Cliente buscado = CentralAltice.getInstance().buscarCliente(cedula);
						if(buscado != null && buscado.getDeudaTotal() > 0)
						{
							dispose();
							try {
								CreateFactura fac = new CreateFactura(buscado);
								fac.setModal(true);
								fac.setLocationRelativeTo(null);
								fac.setVisible(true);
							} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
									| UnsupportedLookAndFeelException | ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	
						}
						else
						{
							if(buscado == null)
							{
								JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
							if(buscado.getDeudaTotal() <= 0)
							{
								JOptionPane.showMessageDialog(null, "El cliente " + buscado.getNombre() + " no posee deudas a saldar", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				});
				btnBuscar.setActionCommand("OK");
				buttonPane.add(btnBuscar);
				getRootPane().setDefaultButton(btnBuscar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setBackground(Color.BLACK);
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
	}
}
