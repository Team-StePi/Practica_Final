public class CamionetaSUV extends Vehiculo {

    public enum TipoTraccion {
        _4x2,
        _4x4
    }
    private TipoTraccion Traccion;
    private float CapacidadMaletero;

    public CamionetaSUV() {
    }

    public CamionetaSUV(String placa, String marca, int modelo, float precioDiario, Vehiculo.EstadoVehiculo estado,
            CamionetaSUV.TipoTraccion traccion, float capacidadMaletero) {
        super(placa, marca, modelo, precioDiario, estado);
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }

    public CamionetaSUV(CamionetaSUV.TipoTraccion traccion, float capacidadMaletero) {
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }

    public TipoTraccion getTraccion() {
        return Traccion;
    }

    public void setTraccion(TipoTraccion traccion) {
        Traccion = traccion;
    }

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

}
