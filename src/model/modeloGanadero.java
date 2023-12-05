package model;
import java.sql.Date;

public class modeloGanadero {
    private String color; //
    private String raza; //
    private Integer chapa;
    private Double pesoAnimal; //
    private Double precio;
    private Date fechaDeCompra;

    // CREAMOS NUESTRO CONSTRUCTOR

    public modeloGanadero(String color, String raza, Integer chapa, Double pesoAnimal, Double precio,
            Date fechaDeCompra) {
        this.color = color;
        this.raza = raza;
        this.chapa = chapa;
        this.pesoAnimal = pesoAnimal;
        this.precio = precio;
        this.fechaDeCompra = fechaDeCompra;
    }

    public modeloGanadero() {

    }

    // METODOS GETTER Y SETTER

    public String getColor() {
        return color;
    }

    public String getRaza() {
        return raza;
    }

    public Integer getChapa() {
        return chapa;
    }

    public Double getPesoAnimal() {
        return pesoAnimal;
    }

    public Double getPrecio() {
        return precio;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setChapa(Integer chapa) {
        this.chapa = chapa;
    }

    public void setPesoAnimal(Double pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }
}