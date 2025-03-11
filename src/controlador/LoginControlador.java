package controlador;

import modelo.ImplementacionBD;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaLogin;

import java.util.Map;

public class LoginControlador {
	UsuarioDAO dao=new ImplementacionBD();
	
	public void visualizarPantalla() {
		VentanaLogin ven = new VentanaLogin(this);
		ven.setVisible(true);	
	}
	
	public boolean comprobarUsuario(Usuario usuario){
		return dao.comprobarUsuario(usuario);	
	}
	
	/*public boolean insertarUsuario(Usuario usuario) {
		return dao.insertarUsuario(usuario);
	}*/
	
	public Map <String,Usuario> mostrar() {
		return dao.mostrar();
	}
}