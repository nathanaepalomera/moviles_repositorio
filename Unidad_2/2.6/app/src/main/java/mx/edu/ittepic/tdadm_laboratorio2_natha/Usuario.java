package mx.edu.ittepic.tdadm_laboratorio2_natha;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String licencia;
    private String monto;
    private String puntos;
    private String celular;
    private String email;

    public Usuario(Integer id, String licencia, String monto, String puntos, String celular, String email) {
        this.id = id;
        this.licencia = licencia;
        this.monto = monto;
        this.puntos = puntos;
        this.celular = celular;
        this.email = email;

    }

    public Usuario() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}