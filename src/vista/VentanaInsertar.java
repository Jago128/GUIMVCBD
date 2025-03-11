package vista;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import controlador.LoginControlador;

public class VentanaInsertar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	
	public VentanaInsertar(JFrame parent, LoginControlador cont) {
		super(parent,true);
		this.cont=cont;
		setTitle("INSERTAR USUARIOS");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>();
		String[] claves = cont.mostrar().keySet().toArray(new String[0]);
		comboBox.setModel(new DefaultComboBoxModel<>(claves));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(115, 11, 200, 22);
		getContentPane().add(comboBox);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
