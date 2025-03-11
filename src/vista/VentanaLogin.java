package vista;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.LoginControlador;
import modelo.Usuario;

public class VentanaLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textfieldName;
	private JPasswordField textfieldPassword;
	private JButton btnLogin;
	private LoginControlador cont;
	JLabel lblResult;

	public VentanaLogin(LoginControlador controlador) {
		this.cont=controlador;
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textfieldName = new JTextField();
		textfieldName.setBounds(147, 39, 105, 19);
		contentPane.add(textfieldName);
		textfieldName.setColumns(10);

		textfieldPassword = new JPasswordField();
		textfieldPassword.setBounds(147, 79, 105, 19);
		contentPane.add(textfieldPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(116, 119, 85, 21);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		JLabel lblName = new JLabel("Nombre de usuario:");
		lblName.setBounds(46, 41, 94, 16);
		contentPane.add(lblName);

		JLabel PasswordField = new JLabel("Contraseña:");
		PasswordField.setBounds(78, 81, 62, 16);
		contentPane.add(PasswordField);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 151, 304, 29);
		contentPane.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnLogin) {
			if (cont.comprobarUsuario(new Usuario (textfieldName.getText(),new String(textfieldPassword.getPassword())))) {
				lblResult.setText("Usuario Logeado");
				VentanaBotones frame = new VentanaBotones(this,cont);
				frame.setVisible(true);
				dispose();
			} else {
				lblResult.setText("Usuario no encontrado");
			}
		}
	}
}
