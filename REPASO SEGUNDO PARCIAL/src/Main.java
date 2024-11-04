import Clases.Concesionaria;
import Clases.Inventario;
import manejoJSON.GestionJSON;

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


    }
}