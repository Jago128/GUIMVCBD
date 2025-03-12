package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import controlador.LoginControlador;
import modelo.Usuario;

public class WindowModify extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JButton btnNewButton;
	private JLabel lblResult;
	private JPasswordField passwordField;
	private LoginControlador cont;

	public WindowModify(JFrame parent, LoginControlador cont) {
		this.cont=cont;
		setBounds(100, 100, 370, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(155, 29, 118, 20);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(127, 100, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(99, 32, 46, 14);
		contentPanel.add(lblName);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(85, 72, 60, 14);
		contentPanel.add(lblPassword);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(21, 134, 323, 46);
		contentPanel.add(lblResult);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 69, 118, 20);
		contentPanel.add(passwordField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnNewButton) {
			if (cont.update(new Usuario(textFieldName.getText(), new String(passwordField.getPassword())))) {
				lblResult.setText("El usuario ha sido modificado correctamente.");
			} else {
				lblResult.setText("Ha habido un problema al modificar el usuario.");
			}
		}
	}
}
