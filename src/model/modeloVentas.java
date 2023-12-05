package model;
public class modeloVentas {
    private Integer precioLitro;
    private Double litros;
    private Double gananciaNeta;
    private Double retirarGanancia;
    private Double gananciaRestante;

    public modeloVentas(Integer precioLitro, Double litros, Double gananciaNeta, Double retirarGanancia,
            Double gananciaRestante) {
        this.precioLitro = precioLitro;
        this.litros = litros;
        this.gananciaNeta = gananciaNeta;
        this.retirarGanancia = retirarGanancia;
        this.gananciaRestante = gananciaRestante;
    }

    public modeloVentas() {
        this.gananciaNeta = 0.0;
    }

    public Integer getPrecioLitro() {
        return precioLitro;
    }

    public Double getLitros() {
        return litros;
    }

    public Double getGananciaNeta() {
        return gananciaNeta;
    }

    public Double getRetirarGanancia() {
        return retirarGanancia;
    }

    public Double getGananciaRestante() {
        return gananciaRestante;
    }

    public void setPrecioLitro(Integer precioLitro) {
        this.precioLitro = precioLitro;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }

    public void setGananciaNeta(Double gananciaNeta) {
        this.gananciaNeta = gananciaNeta;
    }

    public void setRetirarGanancia(Double retirarGanancia) {
        this.retirarGanancia = retirarGanancia;
    }

    public void setGananciaRestante(Double gananciaRestante) {
        this.gananciaRestante = gananciaRestante;
    }

    /*
     * método calcula y devuelve la ganancia neta basada en el precio por litro y la
     * cantidad de litros.
     */
    public double formulaGanancia() {
        if (precioLitro != null && litros != null) {
            gananciaNeta = precioLitro * litros;
            return gananciaNeta;
        } else {
            /*
             * Si alguno de estos valores es null, imprime un mensaje indicando que faltan
             * datos y retorna 0.0.
             */
            System.out.println("No se pueden calcular ganancias. Faltan datos.");
            return 0.0;
        }
    }

    /*
     * Este método permite retirar una cantidad específica de la ganancia. Si la
     * cantidad a retirar
     * es menor o igual a la ganancia disponible, resta la cantidad retirada de la
     * ganancia y devuelve la cantidad retirada.
     */
    public double retirarGanancia(Double retirar, Double ganancia) {
        if (ganancia >= retirar) {
            ganancia -= retirar;
            gananciaRestante = ganancia;
            return retirar;
        } else {
            // Si la cantidad a retirar es mayor que la ganancia disponible,
            // imprime un mensaje indicando que no se puede retirar esa cantidad y retorna
            // 0.0.
            System.out.println("No se puede retirar esa cantidad. La ganancia disponible es menor.");
            return 0.0;
        }
    }

    // Método para obtener la ganancia restante
    public Double obtenerGananciaRestante() {
        return gananciaRestante;
    }
}
