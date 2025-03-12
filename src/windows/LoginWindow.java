package windows;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;
import model.Usuario;

public class LoginWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textfieldName;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private LoginController cont;
	JLabel lblResult;

	public LoginWindow(LoginController controlador) {
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

		passwordField = new JPasswordField();
		passwordField.setBounds(147, 79, 105, 19);
		contentPane.add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(116, 119, 85, 21);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		JLabel lblName = new JLabel("Nombre de usuario:");
		lblName.setBounds(46, 41, 94, 16);
		contentPane.add(lblName);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(78, 81, 62, 16);
		contentPane.add(lblPassword);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 151, 304, 29);
		contentPane.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnLogin) {
			if (cont.comprobarUsuario(new Usuario (textfieldName.getText(),new String(passwordField.getPassword())))) {
				lblResult.setText("Usuario Logeado");
				WindowButtons frame = new WindowButtons(this,cont);
				frame.setVisible(true);
				dispose();
			} else {
				lblResult.setText("Usuario no encontrado");
			}
		}
	}
}
