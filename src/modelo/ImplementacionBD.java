package modelo;

import java.sql.*;
import java.util.*;

public class ImplementacionBD implements UsuarioDAO {
	private Connection con;
	private PreparedStatement stmt;

	private ResourceBundle configFile;
	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String sql = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
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
			con=DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
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
			ResultSet resultado=stmt.executeQuery();
			if (resultado.next()) {
				existe = true;
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: "+e.getMessage());
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
			System.out.println("Error al verificar credenciales: "+e.getMessage());
		}
		return ok;
	}

	@Override
	public Map<String, Usuario> show(Usuario usuario) {
		Map<String, Usuario> users=new TreeMap<>();
		Usuario user;
		ResultSet rs=null;
		this.openConnection();
		try {
			stmt=con.prepareStatement(sqlConsulta);
			rs=stmt.executeQuery();
			while (rs.next()) {
				user=new Usuario();
				user.setNombre(rs.getString("nombre"));
				user.setContrasena("contraseña");
				users.put(user.getNombre(), user);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
