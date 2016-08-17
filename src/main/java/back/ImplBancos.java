package back;

import back.Banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplBancos implements Bancos{

    private Connection obtenerConexion(){
        Connection conn = null;
        try {
            conn = Conexion.obtenerConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    private void cerrarConexion(Connection conn){
        Conexion.cerrarConexion(conn);
    }


    public void crearBanco(Banco item) throws SQLException {

        StringBuilder query = new StringBuilder();
        query.append("insert into bancos (id,nombre,nit) values (");
        query.append(item.getId());
        query.append(",'");
        query.append(item.getNombre());
        query.append("','");
        query.append(item.getNit());
        query.append("');");

        Connection conn = obtenerConexion();
        conn.createStatement().executeQuery(query.toString());
        cerrarConexion(conn);
    }

    public void actualizarBanco(Banco item) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("update bancos set nombre = '");
        query.append(item.getNombre());
        query.append("',nit ='");
        query.append(item.getNit());
        query.append("' where id = ");
        query.append(item.getId());
        query.append(";");

        Connection conn = obtenerConexion();
        conn.createStatement().executeQuery(query.toString());
        cerrarConexion(conn);

    }

    public void eliminarBanco(Integer id) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("delete from bancos ");
        query.append("where id = ");
        query.append(id.toString());
        query.append(";");

        Connection conn = obtenerConexion();
        conn.createStatement().executeQuery(query.toString());
        cerrarConexion(conn);

    }

    public List<Banco> recuperarBancos() throws SQLException {

        List<Banco> resultado = new ArrayList<Banco>();


        StringBuilder query = new StringBuilder();
        query.append("select id,nombre,nit from bancos order by nombre ;");
        Connection conn = obtenerConexion();
        ResultSet rs = conn.createStatement().executeQuery(query.toString());

        while (rs.next()) {
            Banco item = new Banco();
            item.setId(rs.getInt("ID"));
            item.setNombre(rs.getString("Nombre"));
            item.setNit(rs.getString("Nit"));
            resultado.add(item);
        }

        cerrarConexion(conn);

        return resultado;
    }
}