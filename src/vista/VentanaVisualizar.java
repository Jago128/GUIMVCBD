package vista;

import java.awt.event.*;
import javax.swing.*;

import controlador.LoginControlador;

public class VentanaVisualizar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton btnNewButton;
	private JComboBox<String> comboBox;

	public VentanaVisualizar(JFrame parent, LoginControlador cont) {
		
		setTitle("Visualizar Usuarios");
		setBounds(100, 100, 430, 190);
		getContentPane().setLayout(null);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(86, 30, 243, 22);
		getContentPane().add(comboBox);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(160, 96, 89, 23);
		getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
