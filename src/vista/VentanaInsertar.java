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
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton ;
	private LoginControlador cont;

	
	public VentanaInsertar(JFrame parent, LoginControlador cont) {
	//	super(parent,true);
		this.cont=cont;
		setTitle("INSERTAR USUARIOS");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(58, 83, 84, 19);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(178, 83, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(58, 126, 71, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 123, 96, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("INSERTAR");
		btnNewButton.setBounds(161, 169, 131, 42);
		getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(114, 227, 224, 26);
		getContentPane().add(lblNewLabel_2);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnNewButton.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnNewButton) {
			if (cont.insertarUsuario(new Usuario(textField.getText(),textField_1.getText()))) {
				lblNewLabel_2.setText("Inserción ok");
			}else {
				lblNewLabel_2.setText("Inserción NO ok");
				
			}
		}
	}

}
