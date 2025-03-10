package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarUsuario(Usuario usuario);
	public boolean insertarUsuario(Usuario usuario);
	public Map<String, Usuario> show(Usuario usuario);
}
