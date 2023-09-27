import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Conversor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox opciones;
	private JButton botonConvertir;
	private JButton botonSalir;
	private static JLabel resultado;
	private JTextField cantidadAConvertir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setTitle("Alura challenge ONE G5 converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency converter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel.setBounds(84, 22, 261, 28);
		contentPane.add(lblNewLabel);
		
		opciones = new JComboBox();
		opciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		opciones.setModel(new DefaultComboBoxModel(new String[] {"Select an option:", "Mexican pesos to Dollars", "Mexican pesos to Euros", "Mexican Pesos to Sterling Pounds", "Mexican pesos to Japanes yen", "Mexican pesos to South-Korean won", "Dollars to Mexican pesos", "Euros to Mexican pesos", "Sterling Pounds to Mexican pesos", "Japanes yen to Mexican pesos", "South-Korean won to Mexican pesos"}));
		opciones.setBounds(85, 56, 255, 21);
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_1.setBounds(113, 100, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		cantidadAConvertir = new JTextField();
		cantidadAConvertir.setText("0");
		cantidadAConvertir.setFont(new Font("Arial", Font.BOLD, 12));
		cantidadAConvertir.setBounds(222, 99, 86, 20);
		contentPane.add(cantidadAConvertir);
		cantidadAConvertir.setColumns(10);
		
		botonConvertir = new JButton("Convert");
		botonConvertir.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		botonConvertir.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				String valorAConvertir = cantidadAConvertir.getText();
				double cantidad = Double.parseDouble(valorAConvertir);
				
				switch (opciones.getSelectedIndex()) {
				
				case 0:
					resultado.setText("Select a valid option");
					break;
				case 1:  //pesos a dolares
					Conversor.convertir(17.6945, cantidad);
					break;
				case 2:  // pesos a euros
					Conversor.convertir(18.5837, cantidad);
					break;
				case 3:  // pesos a libras esterlinas
					Conversor.convertir(21.45, cantidad);
					break;
				case 4:  // pesos a Yen Japones
					Conversor.convertir(0.1182, cantidad);
					break;
				case 5:  // pesos a won sur-coreano
					Conversor.convertir(0.0100, cantidad);
					break;
				case 6:  // dolares a pesos
					Conversor.convertir(0.05653, cantidad );
					break;
				case 7:  // euros a pesos
					Conversor.convertir(0.05381, cantidad);
					break;
				case 8:  // libras esterlinas a pesos
					Conversor.convertir(0.047, cantidad);
					break;
				case 9:  // yen japones a pesos
					Conversor.convertir(8.4602, cantidad);
					break;
				case 10:  // won sur-coreano a pesos
					Conversor.convertir(76.7300, cantidad);
					break;
				default:
					System.exit(0);
					break;
			}
			}});
		
		botonConvertir.setBounds(163, 130, 120, 23);
		contentPane.add(botonConvertir);
		
		botonSalir = new JButton("Exit");
		botonSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(335, 227, 89, 23);
		contentPane.add(botonSalir);
		
		resultado = new JLabel("");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBackground(new Color(128, 128, 128));
		resultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		resultado.setBounds(113, 175, 231, 26);
		contentPane.add(resultado);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About...");
		mnNewMenu.add(mntmNewMenuItem);
	}

	protected static void convertir(double tipoDeCambio, double cantidad) {
		
		double resultadoFinal = 0; 
		DecimalFormat formatear = new DecimalFormat("00.0000");
		
		if (cantidad != 0) {
			
		resultadoFinal = cantidad / tipoDeCambio;
		resultado.setText(String.valueOf(formatear.format(resultadoFinal)));
		
		}else {
			resultado.setText("Enter a value different from 0");

		}
	}
}
