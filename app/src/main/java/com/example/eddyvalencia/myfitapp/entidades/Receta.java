package com.example.eddyvalencia.myfitapp.entidades;

public class Receta {

    private Integer id;
    private String nombre;
    private String preparacion;

    public Receta(Integer id, String nombre, String preparacion) {
        this.id = id;
        this.nombre = nombre;
        this.preparacion = preparacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
}
