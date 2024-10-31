package Clases;

import java.util.ArrayList;
import java.util.List;

public class Inventario<T extends Vehiculo> {
    private List<T> vehiculos;

    public Inventario() {
        this.vehiculos = new ArrayList<>();
    }

    public List<T> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<T> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "vehiculos=" + vehiculos +
                '}';
    }
}

//
