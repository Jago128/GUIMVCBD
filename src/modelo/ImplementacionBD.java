package modelo;

import java.sql.*;
import java.util.ResourceBundle;

public class ImplementacionBD implements UsuarioDAO{
	// Atributos
		private Connection con;
		private PreparedStatement stmt;

		// Los siguientes atributos se utilizan para recoger los valores del fich de
		// configuraci n
		private ResourceBundle configFile;
		private String driverBD;
		private String urlBD;
		private String userBD;
		private String passwordBD;

		// Sentencias SQL
		
		final String sql = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
		final String sqlInsert = "INSERT INTO usuario VALUES ( ?,?)";
		final String sqlConsulta = "SELECT * FROM usuario";

		// Para la conexi n utilizamos un fichero de configuaraci n, config que
		// guardamos en el paquete control:
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
			// Abrimos la conexion
			boolean existe=false;
			this.openConnection();

			
			try {
				stmt = con.prepareStatement(sql);
	            stmt.setString(1, usuario.getNombre());
	            stmt.setString(2, usuario.getContrasena());
	            ResultSet resultado = stmt.executeQuery();

	            //Si hay un resultado, el usuario existe
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
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

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

		
}

	
		
	


