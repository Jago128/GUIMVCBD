package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarUsuario(Usuario usuario);
	public boolean insertarUsuario(Usuario usuario);
	public Map <String,Usuario> mostrar();
	public boolean update(Usuario usuario);
	public boolean delete(String nom);
}
