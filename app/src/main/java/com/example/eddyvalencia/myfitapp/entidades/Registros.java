package com.example.eddyvalencia.myfitapp.entidades;

public class Registros {

    private Integer id;
    private String fecha;
    private String tipoComida;
    private String idComida;

    public Registros(){}

    public Registros(Integer id, String fecha, String tipoComida, String idComida) {
        this.id = id;
        this.fecha = fecha;
        this.tipoComida = tipoComida;
        this.idComida = idComida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getIdComida() {
        return idComida;
    }

    public void setIdComida(String idComida) {
        this.idComida = idComida;
    }
}
