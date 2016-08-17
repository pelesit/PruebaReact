package pruebaReact;

import back.Banco;
import back.Bancos;
import back.ImplBancos;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Path("home")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }



    @GET
    @Path("listBancos")
    public List<Banco> obtenerBancos() {

        Bancos objeto = new ImplBancos();
        List<Banco> resultado = new ArrayList<Banco>();
        try {
            resultado = objeto.recuperarBancos();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @POST
    @Path("crearBanco")
    public void crearBanco(Banco item) {
        Bancos objeto = new ImplBancos();

        try {
            objeto.crearBanco(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ;
    }


    @POST
    @Path("actualizarBanco")
    public void actualizarBanco(Banco item) {
        Bancos objeto = new ImplBancos();

        try {
            objeto.actualizarBanco(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ;
    }

    @POST
    @Path("eliminarBanco")
    public void eliminarBanco(Integer id) {
        Bancos objeto = new ImplBancos();

        try {
            objeto.eliminarBanco(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ;
    }


}

