package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class ImplementacionBD implements UsuarioDAO{
	private Connection con;
	private PreparedStatement stmt;
	private ResourceBundle configFile;

	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String sql = "SELECT * FROM usuario WHERE nombre = ? AND contrasena = ?";
	final String sqlInsert = "INSERT INTO usuario VALUES ( ?,?)";
	final String sqlConsulta = "SELECT * FROM usuario";

	public ImplementacionBD() {
		this.configFile = ResourceBundle.getBundle("modelo.configClase");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean comprobarUsuario(Usuario usuario){
		boolean existe=false;
		this.openConnection();

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getContrasena());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				existe = true;
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return existe;
	} 

	@Override
	public boolean insertarUsuario(Usuario usuario) {
		boolean ok=false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(sqlInsert);
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getContrasena());
			if (stmt.executeUpdate()>0) {
				ok=true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return ok;
	}

	public Map <String,Usuario> mostrar() {
		ResultSet rs=null;
		Usuario usuario;
		Map<String,Usuario> usuarios=new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(sqlConsulta);
			rs = stmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuarios.put(usuario.getNombre(), usuario);			
			}	
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL.");
		}
		return usuarios;
	}
}
