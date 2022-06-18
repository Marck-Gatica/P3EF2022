package mantenimiento.modelo;

import inicio.controlador.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import inicio.controlador.clsUsuario;

/**
 *
 * @author Edwin
 */
public class daoUsuario {
    private static final String SQL_SELECT = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET usunombre=?, usucontrasena=?, usuultimasesion=?, usuestatus=?, usunombrereal=?, usucorreoe=?, usutelefono=?, usudireccion=? WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_QUERY = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_QUERYN = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion FROM tbl_usuario WHERE usunombre=?";    

    public List<clsUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsUsuario usuario = null;
        List<clsUsuario> usuarios = new ArrayList<clsUsuario>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String ultimasesion = rs.getString("usuultimasesion");
                String estatus = rs.getString("usuestatus");
                String nombrereal = rs.getString("usunombrereal");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuario.setUsuultimasesion(ultimasesion);
                usuario.setUsuestatus(estatus);
                usuario.setUsunombrereal(nombrereal);
                usuario.setUsucorreoe(correoe);
                usuario.setUsutelefono(telefono);
                usuario.setUsudireccion(direccion);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());
            stmt.setString(3, usuario.getUsuultimasesion());
            stmt.setString(4, usuario.getUsuestatus());
            stmt.setString(5, usuario.getUsunombrereal());            
            stmt.setString(6, usuario.getUsucorreoe());
            stmt.setString(7, usuario.getUsutelefono());            
            stmt.setString(8, usuario.getUsudireccion());            

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());
            stmt.setString(3, usuario.getUsuultimasesion());
            stmt.setString(4, usuario.getUsuestatus());
            stmt.setString(5, usuario.getUsunombrereal());            
            stmt.setString(6, usuario.getUsucorreoe());
            stmt.setString(7, usuario.getUsutelefono());            
            stmt.setString(8, usuario.getUsudireccion());            
            stmt.setInt(9, usuario.getUsuid());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getUsuid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsUsuario query(clsUsuario usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getUsuid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String ultimasesion = rs.getString("usuultimasesion");
                String estatus = rs.getString("usuestatus");
                String nombrereal = rs.getString("usunombrereal");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuario.setUsuultimasesion(ultimasesion);
                usuario.setUsuestatus(estatus);
                usuario.setUsunombrereal(nombrereal);
                usuario.setUsucorreoe(correoe);
                usuario.setUsutelefono(telefono);
                usuario.setUsudireccion(direccion);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
public clsUsuario queryn(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getUsunombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String ultimasesion = rs.getString("usuultimasesion");
                String estatus = rs.getString("usuestatus");
                String nombrereal = rs.getString("usunombrereal");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuario.setUsuultimasesion(ultimasesion);
                usuario.setUsuestatus(estatus);
                usuario.setUsunombrereal(nombrereal);
                usuario.setUsucorreoe(correoe);
                usuario.setUsutelefono(telefono);
                usuario.setUsudireccion(direccion);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }

}
