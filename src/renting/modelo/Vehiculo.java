public class Vehiculo {
    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private EstadoVehiculo Estado;
    
    public enum EstadoVehiculo {
        DISPONIBLE,
        ALQUILADO
    }

    public Vehiculo(String placa, String marca, int modelo, float precioDiario, EstadoVehiculo estado) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        PrecioDiario = precioDiario;
        Estado = estado;
    }

    public Vehiculo() {
    }

    public String getPlaca() {
        return Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public float getPrecioDiario() {
        return PrecioDiario;
    }

    public void setPrecioDiario(float precioDiario) {
        PrecioDiario = precioDiario;
    }

    public EstadoVehiculo getEstado() {
        return Estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        Estado = estado;
    }


}
