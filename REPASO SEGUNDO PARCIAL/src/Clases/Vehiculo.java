package Clases;

import Excepciones.ExcepcionPrecioNegativo;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    private String tipo;
    private String marca;
    private String modelo;
    private double precio;
    private  int anio;
    private List<String> caracteristicas;
    private Proveedor proveedor;

    public Vehiculo() {
        this.caracteristicas = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio < 0){
            throw new ExcepcionPrecioNegativo("ERROR!! no se pueden ingresar valores negativos");
        }
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "\n tipo='" + tipo + '\'' +
                "\n marca='" + marca + '\'' +
                "\n modelo='" + modelo + '\'' +
                "\n precio=" + precio +
                "\n anio=" + anio +
                "\n caracteristicas=" + caracteristicas +
                "\n proveedor=" + proveedor +
                '}' +"\n------------------------------\n";
    }
}
