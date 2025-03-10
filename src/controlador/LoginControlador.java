package controlador;

import modelo.ImplementacionBD;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaLogin;

public class LoginControlador {
	UsuarioDAO dao=new ImplementacionBD();

	public void visualizarPantalla() {
		VentanaLogin ven=new VentanaLogin(this);
		ven.setVisible(true);	
	}

	public boolean comprobarUsuario(Usuario usuario){
		return dao.comprobarUsuario(usuario);	
	}

	public boolean insertarUsuario(Usuario usuario) {
		return dao.insertarUsuario(usuario);
	}
}