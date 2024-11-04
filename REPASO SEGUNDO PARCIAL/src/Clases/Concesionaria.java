package Clases;

import java.util.List;

public class Concesionaria {
    private String nombre;
    private String ubicacion;
    private Inventario<Vehiculo> inventario;

    public Concesionaria() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Inventario<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(Inventario<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    //metodos de filtrado

    public void filtrado1(double precio){

        System.out.println(inventario.filtrarXPrecioyProveedor(precio));
    }

    public void filtrado2(int potencia,String caracteristica){
        System.out.println(inventario.filtrarDeportivos(potencia,caracteristica));
    }

    public void filtrado3(int anio,String nombreProveedor){
        System.out.println(inventario.filtrarXanioXproveedotYxCaracteristica(anio,nombreProveedor));
    }



    @Override
    public String toString() {
        return "Concesionaria{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", inventario=" + inventario +
                '}';
    }
}

//Este sistema gestiona una colección de vehículos de alta gama,
// con una variedad que incluye autos, camionetas y deportivos.
// Los vehículos comparten información como el tipo, marca, modelo,
// precio, año, características técnicas y sus respectivos fabricantes.
//Por otro lado, cada tipo de vehículo, excepto un auto común,
// tendrá sistemas de potencia o tracción según corresponda.