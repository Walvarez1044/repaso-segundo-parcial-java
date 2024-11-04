package Clases;

import Excepciones.ExcepcionPrecioNegativo;
import Excepciones.ExcepcionVehiculoNoRegistrado;

import java.util.ArrayList;
import java.util.List;

public class Inventario<T extends Vehiculo> {
    private List<T> vehiculos;

    public Inventario(List<T> vehiculos) {
        this.vehiculos = new ArrayList<>();
    }

    public List<T> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<T> vehiculos) {
        this.vehiculos = vehiculos;
    }

    //metodos

    //● Filtrar vehículos cuyo precio sea superior a 100,000
// y cuyos proveedores sean de "Italia" o "Alemania".

    public List<Vehiculo> filtrarXPrecioyProveedor(double precio){
        if(precio < 0){
            throw new ExcepcionPrecioNegativo("El precio no puede ser negativo");
        }
        List<Vehiculo> vehiculosfiltrados = new ArrayList<>();

        for(Vehiculo v : vehiculos){
            if(v.getPrecio()>= precio && (v.getProveedor().getPais().equals("Italia")) || (v.getProveedor().getPais().equals("Alemania"))){
                vehiculosfiltrados.add(v);
            }
        }
        if(vehiculosfiltrados.isEmpty()){
            throw new ExcepcionVehiculoNoRegistrado("No existe vehiculo con las caracteristicas ingresadas");
        }

        return vehiculosfiltrados;
    }

//● Filtrar deportivos con más de 700 caballos de fuerza y
// que tengan "Turbo" como una de sus características.

    public List<Vehiculo> filtrarDeportivos (int potencia, String caracteristicas){
        List<Vehiculo> deportivosFiltrados = new ArrayList<>();

       for(Vehiculo v: vehiculos){
           if(v instanceof Deportivo d){
               if(d.getPotencia()> potencia && d.getCaracteristicas().contains("turbo")){
                    deportivosFiltrados.add(d);
               }
           }
       }
       if(deportivosFiltrados.isEmpty()){
           throw new ExcepcionVehiculoNoRegistrado("No existe vehiculo registrado");
       }
       return deportivosFiltrados;
    }

//● Filtrar vehículos fabricados después de 2020, con al
// menos tres características registradas, y cuyo proveedor
// no sea de "EEUU".

    public List<Vehiculo> filtrarXanioXproveedotYxCaracteristica(int anio, String paisProveedor){
        List<Vehiculo> vehiculosFiltrados = new ArrayList<>();

        for(Vehiculo v : vehiculos){
            if(v.getAnio()>=anio && !v.getProveedor().getPais().equals(paisProveedor) && v.getCaracteristicas()>=3){
                vehiculosFiltrados.add(v);
            }
        }
        return  vehiculosFiltrados;
    }



    @Override
    public String toString() {
        return "Inventario{" +
                "vehiculos=" + vehiculos +
                '}';
    }
}

//La información de los vehículos puede ser organizada y
// clasificada de manera eficiente, facilitando el manejo
// de grandes colecciones. También se permite crear un
//inventario genérico para tipos específicos de vehículos,
// mejorando la gestión de manera personalizada.


//Filtros de búsqueda:
//● Filtrar vehículos cuyo precio sea superior a 100,000
// y cuyos proveedores sean de "Italia" o "Alemania".
//● Filtrar deportivos con más de 700 caballos de fuerza y
// que tengan "Turbo" como una de sus características.
//● Filtrar vehículos fabricados después de 2020, con al
// menos tres características registradas, y cuyo proveedor no sea de "EEUU".