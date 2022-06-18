package mantenimiento.modelo;

import inicio.controlador.clsConexion;
import inicio.controlador.clsVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edwin
 */
public class daoVentas {
     private static final String SQL_SELECT = "SELECT codproducto, cantidadventas, costoventa, precioventa FROM ventas_detalle";
    private static final String SQL_INSERT = "INSERT INTO ventas_detalle ( cantidadventas, costoventa, precioventa) VALUES ( ?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE ventas_detalle SET cantidadventas = ?, costoventa = ?, precioventa = ?, cuentareferencia = ?, comid = ?, provid = ?, cuentafechaemi = ?, cuentafechavenci = ?  WHERE ventas_detalle = ?";
    private static final String SQL_DELETE = "DELETE FROM ventas_detalle WHERE ventas_detalle = ?";
    private static final String SQL_QUERY = "SELECT cantidadventas, costoventa, precioventa FROM ventas_detalle  WHERE ventas_detalle = ?";

    public List<clsVentas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVentas ventas = null;
        List<clsVentas> cuent = new ArrayList<clsVentas>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cantidadventas = rs.getInt("cantidadventas");
                int costoventa = rs.getInt("costoventa");
                int precioventa = rs.getInt("precioventa");
                int cuentareferencia = rs.getInt("cuentareferencia");
                int comid = rs.getInt("comid");
                int Provid = rs.getInt("provid");
                String cuentafechaemi = rs.getString("cuentafechaemi");
                String cuentafechavenci = rs.getString("cuentafechavenci");
                System.out.println(cuentafechavenci);
                
                ventas = new clsVentas();
                ventas.setCantidadventa(cantidadventas);
                ventas.setCostoventa(costoventa);
                ventas.setPrecioventa(precioventa);
                
                cuent.add(ventas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cuent;
    }

    public int insert(clsVentas ventas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, ventas.getCantidadventa());
            stmt.setInt(2, ventas.getCostoventa());
            stmt.setInt(3, ventas.getPrecioventa());

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


    public int update(clsVentas ventas) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, ventas.getCantidadventa());
            stmt.setInt(2, ventas.getCostoventa());
            stmt.setInt(3, ventas.getPrecioventa());
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

    public int delete(clsVentas ventas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
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

    public clsVentas query(clsVentas ventas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cantidadventas = rs.getInt("cantidadventas");
                int costoventa = rs.getInt("costoventa");
                int precioventa = rs.getInt("precioventa");
                int cuentareferencia = rs.getInt("cuentareferencia");
                int comid = rs.getInt ("comid");
                int provid = rs.getInt("provid");
                String cuentafechaemi = rs.getString("cuentafechaemi");
                String cuentafechavenci = rs.getString("cuentafechavenci");

                ventas = new clsVentas();
                ventas.setCantidadventa(cantidadventas);
                ventas.setCostoventa(costoventa);
                ventas.setPrecioventa(precioventa);
                
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
        return ventas;
    }
    
}
