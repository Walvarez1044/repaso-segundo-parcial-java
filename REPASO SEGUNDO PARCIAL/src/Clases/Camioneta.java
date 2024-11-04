package Clases;

public class Camioneta extends Vehiculo{
    private String traccion;

    public Camioneta(String traccion) {
        this.traccion = traccion;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return "Camioneta{" +
                "traccion='" + traccion + '\'' +
                "} " + super.toString();
    }
}
