package com.example.eddyvalencia.myfitapp.entidades;

public class Usuario {

    private Integer id;
    private Integer pesoInicial;
    private Integer pesoActual;
    private Integer pesoDeseado;
    private Integer edad;
    private Integer estatura;
    private String reducirAumentar;
    private String semanaMes;
    private String nivelActividad;
    private Integer calorias;
    private Integer carbohidratos;
    private Integer proteinas;
    private Integer grasas;
    private String tipo;


    public Usuario(){}

    public Usuario(Integer id, Integer pesoInicial, Integer pesoActual, Integer pesoDeseado,
                   Integer edad, Integer estatura, String reducirAumentar, String semanaMes,
                   String nivelActividad, Integer calorias, Integer carbohidratos, Integer proteinas, Integer grasas, String tipo) {
        this.id = id;
        this.pesoInicial = pesoInicial;
        this.pesoActual = pesoActual;
        this.pesoDeseado = pesoDeseado;
        this.edad = edad;
        this.estatura = estatura;
        this.reducirAumentar = reducirAumentar;
        this.semanaMes = semanaMes;
        this.nivelActividad = nivelActividad;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Integer pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Integer getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Integer pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Integer getPesoDeseado() {
        return pesoDeseado;
    }

    public void setPesoDeseado(Integer pesoDeseado) {
        this.pesoDeseado = pesoDeseado;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public String getReducirAumentar() {
        return reducirAumentar;
    }

    public void setReducirAumentar(String reducirAumentar) {
        this.reducirAumentar = reducirAumentar;
    }

    public String getSemanaMes() {
        return semanaMes;
    }

    public void setSemanaMes(String semanaMes) {
        this.semanaMes = semanaMes;
    }

    public String getNivelActividad() {
        return nivelActividad;
    }

    public void setNivelActividad(String nivelActividad) {
        this.nivelActividad = nivelActividad;
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

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }
}
