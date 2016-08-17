package back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Conexion{

    public static Connection obtenerConexion()throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");

        return conn;
    }


    public static void cerrarConexion(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}