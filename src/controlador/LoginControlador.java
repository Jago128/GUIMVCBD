package controlador;

import modelo.DBImplementation;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.LoginWindow;

import java.util.Map;

public class LoginControlador {
	UsuarioDAO dao=new DBImplementation();
	
	public void visualizarPantalla() {
		LoginWindow ven = new LoginWindow(this);
		ven.setVisible(true);	
	}
	
	public boolean comprobarUsuario(Usuario usuario){
		return dao.comprobarUsuario(usuario);	
	}
	
	public boolean insertarUsuario(Usuario usuario) {
		return dao.insertarUsuario(usuario);
	}
	
	public Map <String,Usuario> mostrar() {
		return dao.mostrar();
	}
	
	public boolean update(Usuario usuario) {
		return dao.update(usuario);
	}

	public boolean delete(String nom) {
		return delete(nom);
	}
}