package Interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.*;

public class Inscripcion extends JFrame {

	private JPanel contentPane;
	private JTextField TFApellido;
	private JTextField TFNombre;
	private JTextField TFDNI;
	private JTextField TFGdR;
	private String apellido;
	private String nombre;
	private int DNI;
	private int grupo;
	private Logica logica;
	private Informacion info;
	private Inicio inicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscripcion frame = new Inscripcion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Inscripcion(Logica log, Inicio ini) {
		this();
		logica = log;
		inicio = ini;
		info = new Informacion();
	}

	/**
	 * Create the frame.
	 */
	public Inscripcion() {
		info = new Informacion();
		setTitle("Inscripcion");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 14));
		lblApellido.setBounds(10, 11, 83, 23);
		contentPane.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombre.setBounds(10, 71, 83, 23);
		contentPane.add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDNI.setBounds(10, 126, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblGPdeRiesgo = new JLabel("Grupo de riesgo");
		lblGPdeRiesgo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGPdeRiesgo.setBounds(10, 173, 136, 23);
		contentPane.add(lblGPdeRiesgo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEstado.setBounds(10, 263, 65, 23);
		contentPane.add(lblEstado);
		
		TFApellido = new JTextField();
		TFApellido.setBounds(10, 33, 210, 20);
		contentPane.add(TFApellido);
		TFApellido.setColumns(10);
		
		TFNombre = new JTextField();
		TFNombre.setBounds(10, 94, 210, 20);
		contentPane.add(TFNombre);
		TFNombre.setColumns(10);
		
		TFDNI = new JTextField();
		TFDNI.setBounds(10, 142, 116, 20);
		contentPane.add(TFDNI);
		TFDNI.setColumns(10);
		
		TFGdR = new JTextField();
		TFGdR.setBounds(10, 201, 37, 20);
		contentPane.add(TFGdR);
		TFGdR.setColumns(10);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 20));
		lblResultado.setBounds(10, 288, 264, 33);
		contentPane.add(lblResultado);
		
		JButton btnInfo = new JButton("+ info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
			}
		});
		btnInfo.setBounds(57, 200, 76, 23);
		contentPane.add(btnInfo);
		
		JButton btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  if (TFApellido.getText().equals("") || TFNombre.getText().equals("") ||TFDNI.getText().equals("") || TFGdR.getText().equals("") )
			  	{lblResultado.setText("Rechazado");
				lblResultado.setForeground(Color.RED);}
			  
			  else {
				  	boolean aceptado;
				  	apellido = TFApellido.getText();
				  	nombre = TFNombre.getText();
				  	DNI = Integer.parseInt(TFDNI.getText());
				  	grupo = Integer.parseInt(TFGdR.getText());
				  	aceptado = logica.inscribir(apellido, nombre, DNI, grupo);
				
				  	if (aceptado)
				  		{lblResultado.setText("Aceptado");
				  		lblResultado.setForeground(Color.GREEN);}
				  	else
				  		{lblResultado.setText("Rechazado");
				  		lblResultado.setForeground(Color.RED);}
			  		}
			}
		});
		btnInscribirse.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInscribirse.setBounds(67, 234, 140, 23);
		contentPane.add(btnInscribirse);
		
		JButton btnVolver = new JButton("Volver al inicio");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				inicio.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setBounds(6, 328, 268, 23);
		contentPane.add(btnVolver);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFApellido.setText("");
				TFNombre.setText("");
				TFDNI.setText("");
				TFGdR.setText("");
				lblResultado.setText("");
			}
		});
		btnLimpiar.setBounds(195, 0, 89, 14);
		contentPane.add(btnLimpiar);
	}
}
