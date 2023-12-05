package controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.modeloMedicamentos;

public class ManejoMedicamentos {
    public static modeloMedicamentos buscarPorNombre(ArrayList<modeloMedicamentos> medicamentos,
            String nombreBuscado) {
        for (int i = 0; i < medicamentos.size(); i++) {
            modeloMedicamentos medicamento = medicamentos.get(i);
            if (medicamento.getNombreMedicamento().equals(nombreBuscado)
                    ) {
                return medicamento;
            }
        }

        return null; // Si no se encuentra, devuelve null
    }

    // Método para ordenar por precio (ascendente)
    public static void ordenarPorPrecioAscendente(ArrayList<modeloMedicamentos> medicamentos) {
        Collections.sort(medicamentos, Comparator.comparing(modeloMedicamentos::getNombreMedicamento));
    }
}
