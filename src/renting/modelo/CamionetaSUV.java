public class CamionetaSUV extends Vehiculo {

    public enum TipoTraccion {
        _4x2,
        _4x4
    }
    private TipoTraccion Traccion;
    private Double CapacidadMaletero;

    public CamionetaSUV() {
    }

    public CamionetaSUV(String placa, String marca, int modelo, Double precioDiario, Vehiculo.EstadoVehiculo estado,
            CamionetaSUV.TipoTraccion traccion, Double capacidadMaletero) {
        super(placa, marca, modelo, precioDiario, estado);
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }

    public CamionetaSUV(CamionetaSUV.TipoTraccion traccion, Double capacidadMaletero) {
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }

    public TipoTraccion getTraccion() {
        return Traccion;
    }

    public void setTraccion(TipoTraccion traccion) {
        Traccion = traccion;
    }

    public Double getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(Double capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

}
