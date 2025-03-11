package vista;

import javax.swing.*;

import controlador.LoginControlador;

public class VentanaVisualizar extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBox;
	private LoginControlador cont;

	public VentanaVisualizar(JFrame parent, LoginControlador cont) {
		this.cont=cont;
		setTitle("Visualizar Usuarios");
		setBounds(100, 100, 430, 190);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(78, 37, 239, 22);
		comboBox.setToolTipText("");
		String[] names = this.cont.mostrar().keySet().toArray(new String[0]);
		getContentPane().setLayout(null);
		comboBox.setModel(new DefaultComboBoxModel<>(names));
		comboBox.setSelectedIndex(-1);
		getContentPane().add(comboBox);
	}
}
