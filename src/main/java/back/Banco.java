package back;

import java.io.Serializable;

public class Banco implements Serializable {

    private int id;
    private String nombre;
    private String nit;

    public Banco(){
        nombre = "";
        nit = "";
        id=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null){
            nombre ="";
        }
        this.nombre = nombre;
    }

    public String getNit() {
        if (nit == null){
            nit = "";
        }
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }




}