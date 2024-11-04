package manejoJSON;

import Clases.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GestionJSON {

    public static Concesionaria mapeoConcesionaria(){
        Concesionaria c = new Concesionaria();
        Inventario<Vehiculo> inventario = new Inventario<>();

        try {
            JSONObject json = new JSONObject(JSONUtiles.leer("concesionaria.json"));
            JSONObject Jconcesionaria = json.getJSONObject("concesionaria");

            c.setNombre(Jconcesionaria.getString("nombre"));
            c.setUbicacion(Jconcesionaria.getString("ubicacion"));

            JSONArray Jvehiculos = Jconcesionaria.getJSONArray("vehiculos");
            inventario.setVehiculos(mapeoVehiculos(Jvehiculos));
            c.setInventario(inventario);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return c;

    }

    public static List<Vehiculo> mapeoVehiculos(JSONArray Jvehiculos){
        List<Vehiculo> vehiculos = new ArrayList<>();

        for(int i = 0; i < Jvehiculos.length(); i++){
            try {
                JSONObject Jvehiculo = Jvehiculos.getJSONObject(i);

                if(Jvehiculo.getString("tipo").equals("Auto")){
                    Vehiculo a = new Auto();
                    mapeoVehiculo(Jvehiculo, a);
                    vehiculos.add(a);
                } else if (Jvehiculo.getString("tipo").equals("Deportivo")){
                    Deportivo d = new Deportivo();
                    d.setPotencia(Jvehiculo.getInt("potencia"));
                    mapeoVehiculo(Jvehiculo, d);
                    vehiculos.add(d);
                } else if (Jvehiculo.getString("tipo").equals("Camioneta")) {
                    Camioneta c = new Camioneta();
                    c.setTraccion(Jvehiculo.getString("traccion"));
                    mapeoVehiculo(Jvehiculo, c);
                    vehiculos.add(c);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return vehiculos;
    }

    private static void mapeoVehiculo(JSONObject Jvehiculo, Vehiculo vehiculo) {
        try {
            vehiculo.setTipo(Jvehiculo.getString("tipo"));
            vehiculo.setMarca(Jvehiculo.getString("marca"));
            vehiculo.setModelo(Jvehiculo.getString("modelo"));
            vehiculo.setPrecio(Jvehiculo.getDouble("precio"));
            vehiculo.setAnio(Jvehiculo.getInt("anio"));

            JSONArray Jcaracteristicas = Jvehiculo.getJSONArray("caracteristicas");
            List<String> caracteristicas = new ArrayList<>();

            for(int i = 0; i < Jcaracteristicas.length();i++){
                caracteristicas.add(Jcaracteristicas.getString(i));
            }
            vehiculo.setCaracteristicas(caracteristicas);

            JSONObject Jproveedores = Jvehiculo.getJSONObject("proveedor");
            Proveedor p = new Proveedor();
            p.setNombre(Jproveedores.getString("nombre"));
            p.setPais(Jproveedores.getString("pais"));
            vehiculo.setProveedor(p);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
