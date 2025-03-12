package windows;

import java.awt.event.*;
import javax.swing.*;

import controller.LoginController;

public class WindowDelete extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldName;
	private JLabel lblResult;
	private JButton btnDelete;
	private LoginController cont;

	public WindowDelete(JFrame parent, LoginController cont) {
		setTitle("Eliminar Usuario");
		this.cont=cont;
		setBounds(100, 100, 320, 170);
		getContentPane().setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(98, 11, 173, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(31, 14, 46, 14);
		getContentPane().add(lblName);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(108, 42, 89, 23);
		getContentPane().add(btnDelete);
		btnDelete.addActionListener(this);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 84, 291, 36);
		getContentPane().add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnDelete) {
			if (cont.delete(textFieldName.getText())) {
				lblResult.setText("El usuario ha sido eliminado correctamente.");
			} else {
				lblResult.setText("Ha habido un problema al eliminar el usuario.");
			}
		}
	}
}
