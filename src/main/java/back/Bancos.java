package back;

import back.Banco;

import java.sql.SQLException;
import java.util.List;

public interface Bancos{
    void crearBanco(Banco item) throws SQLException;
    void actualizarBanco(Banco item) throws SQLException;
    void eliminarBanco(Integer id) throws SQLException;
    List<Banco> recuperarBancos() throws SQLException;
}