package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Usuario;

public class VentanaInsertar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnShow;
	private LoginControlador cont;
	private JComboBox<String> comboBox;

	public VentanaInsertar(JFrame parent, LoginControlador cont) {
		super(parent,true);
		this.cont=cont;
		setTitle("INSERTAR USUARIOS");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		btnShow = new JButton("Mostrar usuarios");
		btnShow.setBounds(145, 208, 131, 42);
		getContentPane().add(btnShow);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(92, 41, 238, 22);
		getContentPane().add(comboBox);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnShow.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnShow) {
			if (cont.insertarUsuario(new Usuario(textField.getText(),textField_1.getText()))) {
				lblNewLabel_2.setText("Inserción ok");
			} else {
				lblNewLabel_2.setText("Inserción NO ok");
			}
		}
	}
}
