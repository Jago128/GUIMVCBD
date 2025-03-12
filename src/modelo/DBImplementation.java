package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class DBImplementation implements UsuarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResourceBundle configFile;

	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String SQLLOGIN = "SELECT * FROM usuario WHERE nombre = ? AND contraseña = ?";
	final String SQLINSERT = "INSERT INTO usuario VALUES (?,?)";
	final String SQLSHOW = "SELECT * FROM usuario";
	final String SQLUPDATE = "UPDATE usuario SET contraseña=? WHERE nombre=?";
	final String SQLDELETE = "DELETE FROM usuario WHERE nombre=?";

	public DBImplementation() {
		this.configFile = ResourceBundle.getBundle("modelo.classConfig");
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
			stmt = con.prepareStatement(SQLLOGIN);
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
			System.out.println("Error al verificar credenciales: "+e.getMessage());
		}
		return existe;
	} 

	@Override
	public boolean insertarUsuario(Usuario usuario) {
		boolean ok=false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERT);
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
	public Map <String,Usuario> mostrar() {
		ResultSet rs=null;
		Usuario usuario;
		Map<String,Usuario> usuarios=new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSHOW);
			rs = stmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setContrasena(rs.getString("contraseña"));
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

	@Override
	public boolean update(Usuario usuario) {
		boolean check=false;

		try {
			stmt=con.prepareStatement(SQLUPDATE);
			stmt.setString(1, usuario.getContrasena());
			stmt.setString(2, usuario.getNombre());
			if (stmt.executeUpdate()>0) {
				check=true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean delete(String nom) {
		boolean check=false;
		try {
			stmt=con.prepareStatement(SQLDELETE);
			stmt.setString(1, nom);
			if (stmt.executeUpdate()>0) {
				check=true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
}
