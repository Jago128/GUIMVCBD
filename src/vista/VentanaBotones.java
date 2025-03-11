package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.LoginControlador;

public class VentanaBotones extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnInsert;
	private JButton btnShow;
	private JButton btnUpdate;
	private JButton btnDelete;
	private LoginControlador cont;

	public VentanaBotones(JFrame parent, LoginControlador cont) {
		setTitle("Elija una opcion:");
		this.cont=cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnInsert = new JButton("Insertar");
		btnInsert.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnInsert.setBounds(10, 11, 183, 101);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(this);
		
		btnShow = new JButton("Visualizar");
		btnShow.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnShow.setBounds(211, 11, 183, 101);
		contentPane.add(btnShow);
		btnShow.addActionListener(this);

		
		btnUpdate = new JButton("Modificar");
		btnUpdate.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnUpdate.setBounds(211, 123, 183, 104);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnDelete = new JButton("Borrar");
		btnDelete.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnDelete.setBounds(10, 123, 183, 104);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnInsert) {
			VentanaInsertar v=new VentanaInsertar(this,cont);
			v.setVisible(true);
		} else if (e.getSource()==btnShow) {
			VentanaVisualizar dialog = new VentanaVisualizar(this,cont);
			dialog.setVisible(true);
		} else if (e.getSource()==btnUpdate) {
			
		} else if (e.getSource()==btnDelete) {
			
		}
	}
}
