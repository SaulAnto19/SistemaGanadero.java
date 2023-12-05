package model;
public class modeloMedicamentos {
    private String nombreMedicamento;
    private Double Precio;


    public modeloMedicamentos(String nombreMedicamento, Double precio) {
        this.nombreMedicamento = nombreMedicamento;
        Precio = precio;
    }

    public modeloMedicamentos() {
        
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    
}
