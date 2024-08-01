package Interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.*;
import TDALista.*;
import javax.swing.JScrollPane;

public class Administracion extends JFrame {

	private JPanel contentPane;
	private Logica logica;
	private Inicio inicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administracion frame = new Administracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Administracion(Logica log, Inicio ini) {
		this();
		logica = log;
		inicio = ini;
	}
	
	/**
	 * Create the frame.
	 */
	public Administracion() {
		setTitle("Administracion");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(404, 45, 270, 311);
		contentPane.add(scrollPane);
		
		JTextPane TPDetalle = new JTextPane();
		scrollPane.setViewportView(TPDetalle);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPaciente.setBounds(24, 16, 84, 23);
		contentPane.add(lblPaciente);
		
		JButton btnEliminarPaciente = new JButton("Eliminar paciente");
		btnEliminarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Persona persona;
			String respuesta = JOptionPane.showInputDialog("DNI del paciente:");
			
			persona = logica.eliminarPaciente(Integer.parseInt(respuesta));
			if (persona != null)
				JOptionPane.showMessageDialog(btnEliminarPaciente, "Se elimino al paciente: "+persona.getApellido()+", "+persona.getNombre()+" - DNI: "+persona.getDNI()+".");
			else
				JOptionPane.showMessageDialog(btnEliminarPaciente, "No se encontro un paciente con ese DNI.");
			}
		});
		btnEliminarPaciente.setBounds(24, 98, 184, 29);
		contentPane.add(btnEliminarPaciente);
		
		JLabel lblListas = new JLabel("Listas:");
		lblListas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblListas.setBounds(24, 155, 84, 23);
		contentPane.add(lblListas);
		
		JButton btnListaDePacientes = new JButton("Lista de pacientes");
		btnListaDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionList<Persona> lista = logica.listaDePacientes();
				
				if (!lista.isEmpty())
				{
					try {
					Position<Persona> puntero = lista.first();
					
					while (puntero != lista.last())
						TPDetalle.setText(TPDetalle.getText()+puntero.element().toString());
					
					} catch (EmptyListException e1) {
					e1.printStackTrace();
					}
				}
				else
					TPDetalle.setText(TPDetalle.getText()+"No hay pacientes en la lista."+"\n");
				
			}
		});
		btnListaDePacientes.setBounds(24, 189, 184, 29);
		contentPane.add(btnListaDePacientes);
		
		JButton btnListaDePacientes_1 = new JButton("Lista de pacientes invertida");
		btnListaDePacientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionList<Persona> lista = logica.listaDePacientesInvertida();
				
				if (!lista.isEmpty())
				{	try {
					
					Position<Persona> puntero = lista.first();
					
					
					while (puntero != lista.last())
						TPDetalle.setText(TPDetalle.getText()+puntero.element().toString());
					
					} catch (EmptyListException e1) {
					e1.printStackTrace();
					}
				}
				else
					TPDetalle.setText(TPDetalle.getText()+"No hay pacientes en la lista."+"\n");	
				
			}
		});
		btnListaDePacientes_1.setBounds(24, 246, 184, 29);
		contentPane.add(btnListaDePacientes_1);
		
		JButton btnHistorialDePacientes = new JButton("Historial de pacientes");
		btnHistorialDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionList<Persona> lista = logica.historialDePacientes();
				
				for (Persona p:	lista)
					TPDetalle.setText(TPDetalle.getText()+p.toString());
					
				
			}
		});
		btnHistorialDePacientes.setBounds(24, 304, 184, 29);
		contentPane.add(btnHistorialDePacientes);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDetalle.setBounds(404, 16, 84, 23);
		contentPane.add(lblDetalle);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TPDetalle.setText("");
			}
		});
		btnLimpiar.setBounds(590, 361, 84, 17);
		contentPane.add(btnLimpiar);
		
		JButton btnPMR = new JButton("Paciente mas riesgoso");
		btnPMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				Persona persona = logica.pacienteMasRiesgoso();
				if (persona == null)
					TPDetalle.setText(TPDetalle.getText()+"No hay pacientes en cola."+"\n");
				else
					TPDetalle.setText(TPDetalle.getText()+persona.toString());
			}
		});
		btnPMR.setBounds(24, 45, 184, 29);
		contentPane.add(btnPMR);
		
		JButton btnVolver = new JButton("Volver al inicio");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				inicio.setVisible(true);
			}
		});
		btnVolver.setBounds(24, 361, 184, 23);
		contentPane.add(btnVolver);
		

	}
}
