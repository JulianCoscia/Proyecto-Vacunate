package Interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class Informacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacion frame = new Informacion();
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
	public Informacion() {
		setTitle("Informacion");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 637, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("Grupos de riesgo de covid-19");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(166, 11, 264, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nivel 5: Menores de 60 a\u00F1os, que no tienen enfermedades cardiovasculares ni respiratorias, diabetes,");
		lblNewLabel_1.setBounds(10, 61, 627, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("cualquier tipo de c\u00E1ncer, trasplantes recientes, deficiencias en el sistema inmune, o un tratamiento");
		lblNewLabel_1_1.setBounds(10, 77, 627, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("con corticoides.");
		lblNewLabel_2.setBounds(10, 98, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("con corticoides.");
		lblNewLabel_2_1.setBounds(10, 160, 122, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("cualquier tipo de c\u00E1ncer, trasplantes recientes, deficiencias en el sistema inmune, o un tratamiento");
		lblNewLabel_1_1_1.setBounds(10, 139, 627, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nivel 4: Mayores de 60 a\u00F1os, que no tienen enfermedades cardiovasculares ni respiratorias, diabetes,");
		lblNewLabel_1_2.setBounds(10, 123, 627, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("un tratamiento con corticoides.");
		lblNewLabel_2_2.setBounds(10, 222, 272, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("cualquier tipo de c\u00E1ncer, pero que no tienen trasplantes recientes, deficiencias en el sistema inmune, o");
		lblNewLabel_1_1_2.setBounds(10, 201, 627, 22);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nivel 3: Menores de 60 a\u00F1os, que tienen enfermedades cardiovasculares ni respiratorias, diabetes,");
		lblNewLabel_1_3.setBounds(10, 185, 627, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("un tratamiento con corticoides.");
		lblNewLabel_2_2_1.setBounds(10, 288, 242, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("cualquier tipo de c\u00E1ncer, pero que no tienen trasplantes recientes, deficiencias en el sistema inmune, o");
		lblNewLabel_1_1_2_1.setBounds(10, 267, 627, 22);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Nivel 2: Mayores de 60 a\u00F1os, que tienen enfermedades cardiovasculares ni respiratorias, diabetes,");
		lblNewLabel_1_3_1.setBounds(10, 251, 627, 22);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("un tratamiento con corticoides.");
		lblNewLabel_2_2_2.setBounds(10, 358, 242, 14);
		contentPane.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("cualquier tipo de c\u00E1ncer, y adem\u00E1s tienen trasplantes recientes, deficiencias en el sistema inmune, o");
		lblNewLabel_1_1_2_2.setBounds(10, 337, 627, 22);
		contentPane.add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Nivel 1: Mayores de 60 a\u00F1os, que tienen enfermedades cardiovasculares ni respiratorias, diabetes,");
		lblNewLabel_1_3_2.setBounds(10, 321, 627, 22);
		contentPane.add(lblNewLabel_1_3_2);
	}
}
