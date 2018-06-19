package com.example.eddyvalencia.myfitapp.entidades;

public class Alimento {

    private Integer id;
    private String nombre;
    private Integer calorias;
    private Integer carbohidratos;
    private Integer grasas;
    private Integer cantidad;
    private String tipoCantidad;

    public Alimento(){}

    public Alimento(Integer id, String nombre, Integer calorias, Integer carbohidratos, Integer grasas, Integer cantidad, String tipoCantidad) {
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        this.cantidad = cantidad;
        this.tipoCantidad = tipoCantidad;
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

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Integer carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(String tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }
}
