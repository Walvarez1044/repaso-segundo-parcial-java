package manejoJSON;

import Clases.*;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
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
            JSONObject JConcesionaria = json.getJSONObject("concesionaria");
            c.setNombre(JConcesionaria.getString("nombre"));
            c.setUbicacion(JConcesionaria.getString("ubicacion"));

            JSONArray JVehiculos = JConcesionaria.getJSONArray("vehiculos");
            inventario.setVehiculos(mapeoVehiculos(JVehiculos));

            c.setInventario(inventario);


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return c;

    }

    public static List<Vehiculo> mapeoVehiculos(JSONArray JVehiculos){

        List<Vehiculo> vehiculos = new ArrayList<>();

        for(int i = 0; i < JVehiculos.length(); i++){

            try {
                JSONObject JVehiculo = JVehiculos.getJSONObject(i);

                if(JVehiculo.getString("tipo").equals("Auto")){

                    Vehiculo a = new Auto();

                    a.setTipo(JVehiculo.getString("tipo"));
                    a.setMarca(JVehiculo.getString("marca"));
                    a.setModelo(JVehiculo.getString("modelo"));
                    a.setPrecio(JVehiculo.getDouble("precio"));
                    a.setAnio(JVehiculo.getInt("anio"));

                    JSONArray JCaracteristicas = JVehiculo.getJSONArray("caracteristicas");
                    List<String> caracteristicas = new ArrayList<>();

                    for (int j = 0; i < JCaracteristicas.length();j++){
                        caracteristicas.add(JCaracteristicas.getString(j));

                    }

                    a.setCaracteristicas(caracteristicas);

                    JSONObject JProveedor = JVehiculo.getJSONObject("proveedor");
                    Proveedor p = new Proveedor();
                    p.setNombre(JProveedor.getString("nombre"));
                    p.setPais(JProveedor.getString("pais"));

                    a.setProveedor(p);
                    
                    vehiculos.add(a);
                } else if (JVehiculo.getString("tipo").equals("Deportivo")) {
                    Deportivo d = new Deportivo();
                    d.s



                    JSONArray JCaracteristicas = JVehiculo.getJSONArray("caracteristicas");
                    List<String> caracteristicas = new ArrayList<>();

                    for (int j = 0; i < JCaracteristicas.length();j++){
                        caracteristicas.add(JCaracteristicas.getString(j));

                    }

                    d.setCaracteristicas(caracteristicas);

                    JSONObject JProveedor = JVehiculo.getJSONObject("proveedor");
                    Proveedor p = new Proveedor();
                    p.setNombre(JProveedor.getString("nombre"));
                    p.setPais(JProveedor.getString("pais"));

                    d.setProveedor(p);

                    vehiculos.add(d);
                    
                } else if () {
                    
                }


            } catch (JSONException e) {
                throw new RuntimeException(e);
            }


        }

        return vehiculos;

    }


}
