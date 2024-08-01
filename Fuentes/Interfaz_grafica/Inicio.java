package Interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import Logica.*;
import javax.swing.JPasswordField;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private Administracion admin;
	private Inscripcion inscrip;
	private Logica logica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		logica = new Logica();
		admin = new Administracion(logica, this);
		inscrip = new Inscripcion(logica, this); 
		setTitle("Vacunate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 238, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JButton btnInscripcion = new JButton("Inscripcion");
		btnInscripcion.setBounds(5, 120, 207, 32);
		btnInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			inscrip.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnInscripcion);
		
		JButton btnAdministracion = new JButton("Administracion");
		btnAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String respuesta = JOptionPane.showInputDialog("Escribe la contraseña.");
			if (respuesta.equals("Estructuras 2021."))
				{JOptionPane.showMessageDialog(btnAdministracion, "Constraseña aceptada.");
				setVisible(false);
				admin.setVisible(true);}
			else
				JOptionPane.showMessageDialog(btnAdministracion, "Constraseña rechazada.");
			}
		});
		btnAdministracion.setBounds(5, 190, 207, 32);
		contentPane.add(btnAdministracion);
		
		JLabel lblBienvenidos = new JLabel("Bienvenidos");
		lblBienvenidos.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBienvenidos.setBounds(66, 35, 116, 25);
		contentPane.add(lblBienvenidos);
	}
}
