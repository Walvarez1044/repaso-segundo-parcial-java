package Excepciones;

public class ExcepcionVehiculoNoRegistrado extends RuntimeException {
    public ExcepcionVehiculoNoRegistrado(String message) {
        super(message);
    }
}
