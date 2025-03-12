package vista;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import controlador.LoginControlador;
import modelo.Usuario;

public class WindowInsert extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel=new JPanel();
	private LoginControlador cont;
	private JTextField textFieldName;
	private JButton btnAdd;
	private JLabel lblResult;
	private JPasswordField passwordField;

	public WindowInsert(JFrame parent, LoginControlador cont) {
		super(parent,true);
		this.cont=cont;
		setTitle("Insertar Usuarios");
		setBounds(100, 100, 350, 240);
		getContentPane().setLayout(null);

		textFieldName = new JTextField();
		textFieldName.setBounds(151, 32, 107, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblName = new JLabel("Nombre de usuario:");
		lblName.setBounds(50, 35, 99, 14);
		getContentPane().add(lblName);

		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setBounds(78, 85, 66, 14);
		getContentPane().add(lblPass);

		btnAdd = new JButton("Insertar");
		btnAdd.setBounds(114, 113, 89, 23);
		getContentPane().add(btnAdd);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 147, 314, 43);
		getContentPane().add(lblResult);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 82, 107, 20);
		getContentPane().add(passwordField);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAdd) {
			if (cont.insertarUsuario(new Usuario(textFieldName.getText(), new String(passwordField.getPassword())))) {
				lblResult.setText("El usuario ha sido añadido correctamente.");
			} else {
				lblResult.setText("Ha occurido un error al añadir el usuario.");
			}
		}
	}
}
