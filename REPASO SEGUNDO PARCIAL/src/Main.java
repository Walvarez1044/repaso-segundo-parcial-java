import Clases.Concesionaria;
import Clases.Inventario;
import manejoJSON.GestionJSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Concesionaria c = GestionJSON.mapeoConcesionaria();

//● Filtrar vehículos cuyo precio sea superior a 100,000
// y cuyos proveedores sean de "Italia" o "Alemania".
        System.out.println("==============================");
        System.out.println("VEHICULOS SUPERIORES A 100.000 CON PROVEEDORES DE ITALIA Y ALEMANIA");
        c.filtrado1(100000);

        System.out.println("==============================");
//● Filtrar deportivos con más de 700 caballos de fuerza y
// que tengan "Turbo" como una de sus características.
        System.out.println("VEHICULOS DEPORTIVOS DE MAS DE 700 CABALLOS CON TURBO");
        c.filtrado2(700,"Turbo");

        System.out.println("==============================");
//● Filtrar vehículos fabricados después de 2020, con al
// menos tres características registradas, y cuyo proveedor
// no sea de "EEUU".
        System.out.println("VEHICULOS MAYORES 2020 CON MAS DE TRES CARACTERISTICAS QUE NO SEAN DE EEUU");
        c.filtrado3(2020,"Italia");

        JSONArray JnuevoAuto = new JSONArray();
        JSONObject JSONObject1 = new JSONObject();


        try {
            JSONObject1.put("nombre", "Concesionaria UTN");

            JSONObject1.put("ubicacion", "Avenida Segundo Parcial 2024");

            JSONArray Jvehiculos = new JSONArray();
            JSONObject Jvehiculo = new JSONObject();

            Jvehiculo.put("tipo", "Camioneta");
            Jvehiculo.put("marca", "Ford");
            Jvehiculo.put("modelo", "Ecosport");
            Jvehiculo.put("precio", 6000);
            Jvehiculo.put("anio", 2004);
            Jvehiculo.put("traccion", "4x2");

            JSONArray Jcaracteristicas = new JSONArray();
            String[] caracteristica = {"Motor 1.6", "Aire acondicionado"};




        } catch (JSONException e) {
            throw new RuntimeException(e);
        }






    }
}