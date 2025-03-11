package vista;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.LoginControlador;
import modelo.Usuario;

public class VentanaLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	private JButton btnLogin;
	private JLabel lblNewLabel_1;
	private LoginControlador cont;

	public VentanaLogin(LoginControlador controlador) {
		this.cont=controlador;
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(147, 39, 105, 19);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(147, 79, 105, 19);
		contentPane.add(campoContrasena);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(116, 119, 85, 21);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Nombre de usuario:");
		lblNewLabel.setBounds(46, 41, 94, 16);
		contentPane.add(lblNewLabel);

		JLabel Contarseña = new JLabel("Contraseña:");
		Contarseña.setBounds(78, 81, 62, 16);
		contentPane.add(Contarseña);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(78, 240, 274, 23);
		contentPane.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnLogin) {
			if (cont.comprobarUsuario(new Usuario (campoUsuario.getText(),new String(campoContrasena.getPassword())))) {
				lblNewLabel_1.setText("Usuario Logeado");
				VentanaBotones frame = new VentanaBotones(this,cont);
				frame.setVisible(true);
				dispose();
			} else {
				lblNewLabel_1.setText("Usuario no encontrado");
			}
		}
	}
}
