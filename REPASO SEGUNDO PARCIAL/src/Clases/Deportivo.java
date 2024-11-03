package Clases;

public class Deportivo extends Concesionaria{
    private String potencia;

    public Deportivo(String potencia) {
        this.potencia = potencia;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Deportivo{" +
                "potencia='" + potencia + '\'' +
                "} " + super.toString();
    }
}
