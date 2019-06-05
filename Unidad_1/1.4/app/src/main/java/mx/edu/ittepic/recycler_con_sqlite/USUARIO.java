package mx.edu.ittepic.recycler_con_sqlite;

import java.io.Serializable;

public class USUARIO implements Serializable {

    private Integer Id;
    private String Nombre;
    private String Clave;
    private String Telefono;

    public USUARIO(Integer ID, String NOMBRE, String CLAVE, String TELEFONO) {
        this.Id = ID;
        this.Nombre = NOMBRE;
        this.Clave = CLAVE;
        this.Telefono = TELEFONO;
    }

    public USUARIO(){}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer ID) {
        this.Id = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String NOMBRE) {
        this.Nombre = NOMBRE;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String CLAVE) {
        this.Clave = CLAVE;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String TELEFONO) { this.Telefono = TELEFONO; }



}