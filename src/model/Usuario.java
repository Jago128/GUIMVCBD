package model;

public class Usuario {
	private String nombre;
    private String contrasena;

    public Usuario() {
        this.nombre = "";
        this.contrasena = "";
    }
    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + "]";
    }

}
