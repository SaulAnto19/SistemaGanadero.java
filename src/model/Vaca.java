package model;
// Subclase Vaca que extiende modeloGanadero
//aqui aplicamos nuestra herencia de nuestro modeloGanadero

import java.sql.Date;

public class Vaca extends modeloGanadero {
    private String tipoLeche;

    // Constructor de la subclase Vaca
    public Vaca(String color, String raza, Integer chapa, Double pesoAnimal, Double precio, Date fechaDeCompra,
            String tipoLeche) {
        super(color, raza, chapa, pesoAnimal, precio, fechaDeCompra); // Llama al constructor de la superclase                                                     // modeloGanadero
        this.tipoLeche = tipoLeche;
    }

    // Getter y setter específico para tipoLeche
    public String getTipoLeche() {
        return tipoLeche;
    }

    public void setTipoLeche(String tipoLeche) {
        this.tipoLeche = tipoLeche;
    }
}
