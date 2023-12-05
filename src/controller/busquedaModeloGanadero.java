package controller;
import java.util.ArrayList;

import model.modeloGanadero;

//algoritmo de búsqueda lineal, donde recorro una lista de elementos en busca de un elemento específico.
public class busquedaModeloGanadero {
    /*
     * Este método es estático (static), lo que significa que se puede llamar sin
     * necesidad de crear una instancia de la clase que lo contiene. Recibe tres
     * argumentos:
     * 
     * ArrayList<modeloGanadero> ganado: Es la lista en la que se va a buscar.
     * String colorBuscado: Es el color que estamos buscando en los objetos
     * modeloGanadero.
     * String razaBuscada: Es la raza que estamos buscando en los objetos
     * modeloGanadero.
     */
    public static modeloGanadero buscarPorColorYRaza(ArrayList<modeloGanadero> ganado, String colorBuscado,
            String razaBuscada) {
        for (int i = 0; i < ganado.size(); i++) {
            modeloGanadero animal = ganado.get(i);
            if (animal.getColor().equals(colorBuscado) && animal.getRaza().equals(razaBuscada)) {
                return animal;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
}
