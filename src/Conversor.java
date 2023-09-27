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
		setTitle("Conversor Alura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de divisas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel.setBounds(84, 22, 261, 28);
		contentPane.add(lblNewLabel);
		
		opciones = new JComboBox();
		opciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		opciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción:", "Pesos a Dolares", "Pesos a Euros", "Pesos a Yen Japones", "Pesos a Won Coreano", "Dolares a Pesos", "Euros a Pesos", "Yen Japones a Pesos", "Won Coreano a Pesos"}));
		opciones.setBounds(128, 56, 180, 21);
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese la cantidad");
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
		
		botonConvertir = new JButton("Convertir");
		botonConvertir.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		botonConvertir.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				String valorAConvertir = cantidadAConvertir.getText();
				double cantidad = Double.parseDouble(valorAConvertir);
				
				switch (opciones.getSelectedIndex()) {
				
				case 0:
					resultado.setText("Seleccione una opcion valida ");
					break;
				case 1:
					Conversor.convertir(17.6945, cantidad);
					break;
				case 2:
					Conversor.convertir(18.5837, cantidad);
					break;
				case 3:
					Conversor.convertir(0.1182, cantidad);
					break;
				case 4:
					Conversor.convertir(0.0100, cantidad);
					break;
				case 5:
					Conversor.convertir(0.05653, cantidad );
					break;
				case 6:
					Conversor.convertir(0.05381, cantidad);
					break;
				case 7:
					Conversor.convertir(8.4602, cantidad);
					break;
				case 8:
					Conversor.convertir(76.7000, cantidad);
					break;
				default:
					System.exit(0);
					break;
			}
			}});
		
		botonConvertir.setBounds(163, 130, 120, 23);
		contentPane.add(botonConvertir);
		
		botonSalir = new JButton("Salir");
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Acerca de...");
		mnNewMenu.add(mntmNewMenuItem);
	}

	protected static void convertir(double tipoDeCambio, double cantidad) {
		
		double resultadoFinal = 0; 
		DecimalFormat formatear = new DecimalFormat("00.0000");
		
		if (cantidad != 0) {
			
		resultadoFinal = cantidad / tipoDeCambio;
		resultado.setText(String.valueOf(formatear.format(resultadoFinal)));
		
		}else {
			resultado.setText("Introduzca un valor diferente de 0");

		}
	}
}
